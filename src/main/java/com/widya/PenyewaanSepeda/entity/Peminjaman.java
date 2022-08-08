package com.widya.PenyewaanSepeda.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Peminjaman")
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDpeminjaman", nullable = false)
    private Long iDpeminjaman;

    @Column(name="SepedaID")
    private String sepedaId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SepedaID", insertable = false,updatable = false)
    private Bicycle sepeda;

    @Column(name="CustomerID")
    private String customerId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CustomerID",insertable = false,updatable = false)
    private Customer customer;

    @Column(name = "Waktupeminjaman", nullable = false)
    private LocalTime waktupeminjaman;

    @Column(name = "WaktuPengembalian", nullable = false)
    private LocalTime waktuPengembalian;

    @Column(name = "WaktuDikembalikan")
    private LocalTime waktuDikembalikan;

    @Column(name = "BiayaPeminjaman", nullable = false)
    private Long biayaPeminjaman;

    @Column(name = "Denda")
    private Long denda;

    @Column(name = "Total_Biaya")
    private Long totalBiaya;

    public Peminjaman(Long iDpeminjaman, String sepedaId, String customerId,  LocalTime waktupeminjaman, LocalTime waktuPengembalian, LocalTime waktuDikembalikan, Long biayaPeminjaman, Long denda, Long totalBiaya) {
        this.iDpeminjaman = iDpeminjaman;
        this.sepedaId = sepedaId;
        this.customerId = customerId;
        this.waktupeminjaman = waktupeminjaman;
        this.waktuPengembalian = waktuPengembalian;
        this.waktuDikembalikan = waktuDikembalikan;
        this.biayaPeminjaman = biayaPeminjaman;
        this.denda = denda;
        this.totalBiaya = totalBiaya;
    }
}