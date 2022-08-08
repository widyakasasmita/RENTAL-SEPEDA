package com.widya.PenyewaanSepeda.dto.pelanggan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PelanganGridDto {

    private Long customerID;
    private String name;
    private String address;
    private String phone;
    private String email;
}
