package com.widya.PenyewaanSepeda.service.Implementasi;

import com.widya.PenyewaanSepeda.dao.PeminjamanRepositpory;
import com.widya.PenyewaanSepeda.dao.SepedaRepository;
import com.widya.PenyewaanSepeda.dto.pelanggan.UpsertCustomer;
import com.widya.PenyewaanSepeda.dto.peminjaman.PeminjamanGridDto;
import com.widya.PenyewaanSepeda.dto.peminjaman.UpsertPeminjamanDto;
import com.widya.PenyewaanSepeda.entity.Peminjaman;
import com.widya.PenyewaanSepeda.service.abstraction.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;

@Service
public class PeminjamanImpl implements PeminjamanService {

    @Autowired
    private PeminjamanRepositpory peminjamanRepositpory;

    @Autowired private SepedaRepository sepedaRepository;

    private final int rowInPages = 10;

    @Override
    public Page<PeminjamanGridDto> getAllGrid(Integer page, Long id) {
        var pages = PageRequest.of(page-1,rowInPages, Sort.by("id"));
        var grid = peminjamanRepositpory.findall(id,pages);
        return grid;
    }

    @Override
    public Long save(UpsertPeminjamanDto dto) {
        var sepeda = sepedaRepository.findById(dto.getSepedaId()).get();
        Long denda;
        var durasipeminjaman = ChronoUnit.MINUTES.between(dto.getWaktupeminjaman(),dto.getWaktuPengembalian());
        var biayapeminjaman = (durasipeminjaman/60) * sepeda.getBiayaperJam();
        dto.setBiayaPeminjaman(biayapeminjaman);
        if(dto.getWaktuDikembalikan()== dto.getWaktuPengembalian() ){
            dto.setDenda(0l);
            dto.setTotalBiaya(biayapeminjaman);
        }else{
            var kelebihanwaktu = ChronoUnit.MINUTES.between(dto.getWaktuPengembalian(),dto.getWaktuDikembalikan());
            denda = (kelebihanwaktu/60)*sepeda.getBiayaperJam();
            dto.setDenda(denda);
            dto.setTotalBiaya(dto.getBiayaPeminjaman() + dto.getDenda());

        }

        var entity = new Peminjaman(
                dto.getIDpeminjaman(),
                dto.getSepedaId(),
                dto.getCustomerId(),
                dto.getWaktupeminjaman(),
                dto.getWaktuPengembalian(),
                dto.getWaktuDikembalikan(),
                dto.getBiayaPeminjaman(),
                dto.getDenda(),
                dto.getTotalBiaya()
        );
        peminjamanRepositpory.save(entity);
        return entity.getIDpeminjaman();
    }

}
