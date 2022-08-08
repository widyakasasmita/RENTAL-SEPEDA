package com.widya.PenyewaanSepeda.dao;

import com.widya.PenyewaanSepeda.dto.pelanggan.PelanganGridDto;
import com.widya.PenyewaanSepeda.dto.pelanggan.UpsertCustomer;
import com.widya.PenyewaanSepeda.dto.sepeda.SepedaGridDto;
import com.widya.PenyewaanSepeda.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Column;

public interface PelangganRepository extends JpaRepository<Customer,Long> {

    @Query(value= """
            SELECT new  com.widya.PenyewaanSepeda.dto.pelanggan.PelanganGridDto (
              cust.customerID, cust.name, cust.address, cust.phone,
              cust.email
            ) FROM Customer as cust
            WHERE cust.customerID LIKE %:customerId% 
            """)
    Page<PelanganGridDto> findall(@Param("customerId")Long customerId, Pageable pageable);


}
