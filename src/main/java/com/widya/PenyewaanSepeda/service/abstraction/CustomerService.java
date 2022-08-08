package com.widya.PenyewaanSepeda.service.abstraction;

import com.widya.PenyewaanSepeda.dto.pelanggan.PelanganGridDto;
import com.widya.PenyewaanSepeda.dto.pelanggan.UpsertCustomer;
import com.widya.PenyewaanSepeda.dto.sepeda.SepedaGridDto;
import com.widya.PenyewaanSepeda.dto.sepeda.UpsertSepedaDto;
import org.springframework.data.domain.Page;

public interface CustomerService {
    Page<PelanganGridDto> getAllGrid(Integer page, Long id);
    UpsertCustomer getUpdate (Long id);
    Long save (UpsertCustomer dto);
    Boolean delete (Long id);
    public Long dependentdenganPeminjaman(Long id);
}
