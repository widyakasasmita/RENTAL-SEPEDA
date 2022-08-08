package com.widya.PenyewaanSepeda.service.Implementasi;

import com.widya.PenyewaanSepeda.dao.PeminjamanRepositpory;
import com.widya.PenyewaanSepeda.dao.SepedaRepository;
import com.widya.PenyewaanSepeda.dto.sepeda.SepedaGridDto;
import com.widya.PenyewaanSepeda.dto.sepeda.UpsertSepedaDto;
import com.widya.PenyewaanSepeda.entity.Bicycle;
import com.widya.PenyewaanSepeda.service.abstraction.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BicycleImpl implements BicycleService {
    @Autowired
    private SepedaRepository sepedaRepository;
    @Autowired
    private PeminjamanRepositpory peminjamanRepositpory;
    private  final int roowInPage = 10;


    @Override
    public Page<SepedaGridDto> getAllGrid(Integer page, String sepedaId) {
        var  pagination = PageRequest.of(page-1,roowInPage, Sort.by("id"));
        var grid = sepedaRepository.findall(sepedaId,pagination);
        return  grid;
    }

    @Override
    public String getUpdate(String sepedaId , UpsertSepedaDto dto) {
        var sepeda = sepedaRepository.findById(sepedaId).get();
          sepeda.setJenisSepeda(dto.getJenisSepeda());
          sepeda.setMerekSepeda(dto.getMerekSepeda());
          sepeda.setWarnaSepeda(dto.getWarnaSepeda());
          sepeda.setBiayaperJam(dto.getBiayaperJam());
          sepedaRepository.save(sepeda);
        return sepeda.getSepedaID();
    }

    @Override
    public String save(UpsertSepedaDto dto) {
            Long totalSepeda = sepedaRepository.totalsepeda(dto.getJenisSepeda());
            String idSepeda = String.format("%s%d",dto.getJenisSepeda(),totalSepeda+1);
           var sepeda = new Bicycle(
                    idSepeda,
                    dto.getJenisSepeda(),
                    dto.getMerekSepeda(),
                    dto.getWarnaSepeda(),
                    dto.getBiayaperJam()
            );
            sepedaRepository.save(sepeda);
        return sepeda.getSepedaID();
    }

    @Override
    public Boolean delete(String id) {
        var dependent = peminjamanRepositpory.countDependentinLoanandsepeda(id);
        if(dependent == 0){
            sepedaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Long dependentdenganPeminjaman(String id){
        var dependent = peminjamanRepositpory.countDependentinLoanandsepeda(id);
        return dependent;
    }


}