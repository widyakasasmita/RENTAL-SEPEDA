package com.widya.PenyewaanSepeda.dao;

import com.widya.PenyewaanSepeda.dto.peminjaman.PeminjamanGridDto;
import com.widya.PenyewaanSepeda.dto.sepeda.SepedaGridDto;
import com.widya.PenyewaanSepeda.entity.Bicycle;
import com.widya.PenyewaanSepeda.entity.Customer;
import com.widya.PenyewaanSepeda.entity.Peminjaman;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalTime;

public interface PeminjamanRepositpory extends JpaRepository<Peminjaman,Long> {

    @Query(value= """
            SELECT *
            FROM Peminjaman as loan
            WHERE loan.SepedaID = :sepedaId
            """,nativeQuery=true)
    Long countDependentinLoanandsepeda (@Param("sepedaId") String sepedaid);

    @Query(value= """
            SELECT *
            FROM Peminjaman as loan
            WHERE loan.CustomerID = :customerID
            """,nativeQuery=true)
    Long countDependentinLoanandcustomer (@Param("customerID") Long customerID);

    @Query(value= """
            SELECT new com.widya.PenyewaanSepeda.dto.peminjaman.PeminjamanGridDto(
             loan.iDpeminjaman,
             loan.sepedaId,
             loan.customerId,
             loan.waktupeminjaman, 
             loan.waktuPengembalian,
             loan.waktuDikembalikan,
             loan.biayaPeminjaman,
             loan.denda,
             loan.totalBiaya
            ) FROM Peminjaman as loan
            WHERE loan.iDpeminjaman LIKE %:iDpeminjaman% 
            """)
    Page<PeminjamanGridDto> findall(@Param("iDpeminjaman")Long iDpeminjaman, Pageable pageable);

}
