package com.widya.PenyewaanSepeda.service.Implementasi;

import com.widya.PenyewaanSepeda.Config.ApplicationSecurityConfig;
import com.widya.PenyewaanSepeda.dao.AccountRepository;
import com.widya.PenyewaanSepeda.dto.account.RegisterDto;
import com.widya.PenyewaanSepeda.entity.Account;
import com.widya.PenyewaanSepeda.entity.MyAccountDetails;
import com.widya.PenyewaanSepeda.service.abstraction.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountImpl implements UserDetailsService,AccountService {


    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void registration(RegisterDto dto) {
        PasswordEncoder passwordEncoder = ApplicationSecurityConfig.passwordEncoder();
        String hashPassword = passwordEncoder.encode(dto.getPassword());
            Account account = new Account(
                    dto.getUsername(),
                    hashPassword,
                    dto.getRole()
            );
            accountRepository.save(account);
         //   account.getPassword();
    }

    @Override
    public String getAccountRole(String username) {
        return null;
    }

    @Override
    public Boolean checkExistingAccount(String username) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("Usernam tidak ditemukan"));
        return new MyAccountDetails(account);
    }


}
