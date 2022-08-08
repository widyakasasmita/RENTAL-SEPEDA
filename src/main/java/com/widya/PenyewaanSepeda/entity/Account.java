package com.widya.PenyewaanSepeda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    @Column(name = "Username", nullable = false, length = 50)
    private String username;

    @Column(name = "Password", nullable = false, length = 200)
    private String password;

    @Column(name = "Role", nullable = false, length = 20)
    private String role;


}