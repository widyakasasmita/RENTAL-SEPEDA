package com.widya.PenyewaanSepeda.service.abstraction;

import com.widya.PenyewaanSepeda.dto.pelanggan.PelanganGridDto;
import com.widya.PenyewaanSepeda.dto.pelanggan.UpsertCustomer;
import com.widya.PenyewaanSepeda.dto.peminjaman.PeminjamanGridDto;
import com.widya.PenyewaanSepeda.dto.peminjaman.UpsertPeminjamanDto;
import org.springframework.data.domain.Page;

public interface PeminjamanService {
    Page<PeminjamanGridDto> getAllGrid(Integer page, Long id);
    Long save (UpsertPeminjamanDto dto);
}
