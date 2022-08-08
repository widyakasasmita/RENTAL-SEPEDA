package com.widya.PenyewaanSepeda.service.Implementasi;

import com.widya.PenyewaanSepeda.dao.PelangganRepository;
import com.widya.PenyewaanSepeda.dao.PeminjamanRepositpory;
import com.widya.PenyewaanSepeda.dto.pelanggan.PelanganGridDto;
import com.widya.PenyewaanSepeda.dto.pelanggan.UpsertCustomer;
import com.widya.PenyewaanSepeda.entity.Customer;
import com.widya.PenyewaanSepeda.service.abstraction.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CustomerImpl implements CustomerService {

    @Autowired
    private PelangganRepository pelangganRepository;
    @Autowired
    private PeminjamanRepositpory peminjamanRepositpory;
    private final int rowinPage = 10;
    @Override
    public Page<PelanganGridDto> getAllGrid(Integer page, Long id) {
        var pageobject = PageRequest.of(page-1,rowinPage, Sort.by("id"));
        var grid = pelangganRepository.findall(id,pageobject);
        return grid;
    }

    @Override
    public UpsertCustomer getUpdate(Long  id) {
        var nullAbleEntity = pelangganRepository.findById(id);
        var entity = nullAbleEntity.get();
        UpsertCustomer dto = new UpsertCustomer(
                entity.getCustomerID(),
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail()
        );
        return dto;
    }

    @Override
    public Long save(UpsertCustomer dto) {
        var entity = new Customer(
                dto.getCustomerID(),
                dto.getName(),
                dto.getAddress(),
                dto.getPhone(),
                dto.getEmail()
        );
        pelangganRepository.save(entity);
        return entity.getCustomerID();
    }

    @Override
    public Boolean delete(Long id) {
        if(dependentdenganPeminjaman(id) == 0){
            pelangganRepository.deleteById(id);
            return true;
        }
        return false;

    }

    @Override
    public Long dependentdenganPeminjaman(Long id) {
        var dependent = peminjamanRepositpory.countDependentinLoanandcustomer(id);
        return dependent;
    }
}
