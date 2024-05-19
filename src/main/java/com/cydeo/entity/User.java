package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
//@ToString
@NoArgsConstructor
@Table(name = "user_account")
public class User extends BaseEntity{
    private String email;
    private String password;
    private String username;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_details_id") // we are changing foreign key therefore using @JoinColumn
    private Account account;
}
