package com.widya.PenyewaanSepeda.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterDto {
    private String username;
    private String password;
    private String role;

}
