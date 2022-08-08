package com.widya.PenyewaanSepeda.service.abstraction;

import com.widya.PenyewaanSepeda.dto.sepeda.SepedaGridDto;
import com.widya.PenyewaanSepeda.dto.sepeda.UpsertSepedaDto;
import com.widya.PenyewaanSepeda.entity.Bicycle;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BicycleService {
    Page<SepedaGridDto> getAllGrid(Integer page, String sepedaId);
    String getUpdate (String sepedaId, UpsertSepedaDto dto);
    String save (UpsertSepedaDto dto);
    Boolean delete (String id);
    public Long dependentdenganPeminjaman(String id);

}
