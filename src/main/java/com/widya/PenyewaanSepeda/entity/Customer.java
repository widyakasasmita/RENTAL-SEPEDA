package com.widya.PenyewaanSepeda.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID", nullable = false)
    private Long customerID;

    @Column(name = "Name", nullable = false, length = 20)
    private String name;

    @Column(name = "Address", nullable = false, length = 500)
    private String address;

    @Column(name = "Phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "Email", nullable = false, length = 20)
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Peminjaman> peminjaman = new ArrayList<>();

    public Customer(Long customerID, String name, String address, String phone, String email) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}