package com.DailyDash.AccountManagement.entity;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class DashUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String firstName;


    private String email;


    private String password;

    @Nullable
    private Boolean isAccountVerified;

    @ManyToOne
    private City city;

    @Enumerated(EnumType.STRING)
    private Role role;
}

