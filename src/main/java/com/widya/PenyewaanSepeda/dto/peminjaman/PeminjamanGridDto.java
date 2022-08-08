package com.widya.PenyewaanSepeda.dto.peminjaman;

import com.widya.PenyewaanSepeda.entity.Bicycle;
import com.widya.PenyewaanSepeda.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PeminjamanGridDto {


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
