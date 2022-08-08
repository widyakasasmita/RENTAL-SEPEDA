package com.widya.PenyewaanSepeda.dao;

import com.widya.PenyewaanSepeda.dto.pelanggan.PelanganGridDto;
import com.widya.PenyewaanSepeda.dto.sepeda.SepedaGridDto;
import com.widya.PenyewaanSepeda.entity.Bicycle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SepedaRepository extends JpaRepository<Bicycle,String> {

    @Query(value= """
            SELECT new  com.widya.PenyewaanSepeda.dto.sepeda.SepedaGridDto(
              sepeda.sepedaID,
              sepeda.jenisSepeda,
             sepeda.merekSepeda,sepeda.warnaSepeda, sepeda.biayaperJam,sepeda.status
            ) FROM Bicycle as sepeda
            WHERE sepeda.sepedaID LIKE %:sepedaId% 
            """)
    Page<SepedaGridDto> findall(@Param("sepedaId")String sepedaId, Pageable pageable);

    @Query(value = """
                 SELECT count(sepeda.SepedaID)
                       FROM Bicycle as sepeda
                       WHERE sepeda.JenisSepeda = :sepeda
            """, nativeQuery=true)
    long totalsepeda (String sepeda);

}
