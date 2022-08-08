package com.widya.PenyewaanSepeda.dto.peminjaman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpsertPeminjamanDto {

    private Long iDpeminjaman;
    private String sepedaId;
    private String customerId;
    private LocalTime waktupeminjaman;
    private LocalTime waktuPengembalian;
    private LocalTime waktuDikembalikan;
    private Long biayaPeminjaman;
    private Long denda;
    private Long totalBiaya;
}
