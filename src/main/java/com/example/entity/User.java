package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

@Data
@NoArgsConstructor

public class User {
    private Long id;
    private String login;
    private String name;
    private String surname;
    private String password;
    private BigDecimal balance;
    private Integer rentedTransportId;
    private String role;

    public User(Long id, String login, String name, String surname, String password, BigDecimal balance, Integer rentedTransportId, String role) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.balance = balance;
        this.rentedTransportId = rentedTransportId;
        this.role = role;
    }
}
