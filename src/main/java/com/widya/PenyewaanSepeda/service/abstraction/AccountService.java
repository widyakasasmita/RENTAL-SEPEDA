package com.widya.PenyewaanSepeda.service.abstraction;

import com.widya.PenyewaanSepeda.dto.account.RegisterDto;

public interface AccountService {
    public void registration (RegisterDto dto);
    public String getAccountRole(String username);
    public Boolean checkExistingAccount(String username);
}
