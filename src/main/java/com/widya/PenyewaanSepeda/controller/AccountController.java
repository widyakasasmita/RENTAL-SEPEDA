package com.widya.PenyewaanSepeda.controller;

import com.widya.PenyewaanSepeda.dto.account.RegisterDto;
import com.widya.PenyewaanSepeda.service.abstraction.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AccountController {


    @Autowired
    private AccountService accountService;
    @Autowired
    private AuthenticationManager authenticationManager;



    @GetMapping
    public Authentication index (Authentication authentication){
        return authentication;
    }

    @PostMapping("register")
    public void registration(@RequestBody RegisterDto dto){
        accountService.registration(dto);
    }

}
