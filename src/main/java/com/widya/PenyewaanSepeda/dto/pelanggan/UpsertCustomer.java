package com.widya.PenyewaanSepeda.dto.pelanggan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UpsertCustomer {
    private Long customerID;
    private String name;
    private String address;
    private String phone;
    private String email;
}
