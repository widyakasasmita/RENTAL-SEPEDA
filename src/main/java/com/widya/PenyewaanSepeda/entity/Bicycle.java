package com.widya.PenyewaanSepeda.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Bicycle")
public class Bicycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SepedaID", nullable = false, length = 50)
    private String sepedaID;

    @Column(name = "JenisSepeda", nullable = false, length = 20)
    private String jenisSepeda;

    @Column(name = "MerekSepeda", length = 50)
    private String merekSepeda;

    @Column(name = "WarnaSepeda", nullable = false, length = 20)
    private String warnaSepeda;

    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "BiayaperJam")
    private Long biayaperJam;

    @OneToMany(mappedBy = "sepeda")
    private List<Peminjaman> peminjaman = new ArrayList<>();

    public Bicycle(String sepedaID, String jenisSepeda, String merekSepeda, String warnaSepeda,  Long biayaperJam) {
        this.sepedaID = sepedaID;
        this.jenisSepeda = jenisSepeda;
        this.merekSepeda = merekSepeda;
        this.warnaSepeda = warnaSepeda;
        this.status = "AVAILABLE";
        this.biayaperJam = biayaperJam;
    }
}
