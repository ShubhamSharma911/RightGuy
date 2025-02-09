package com.rightguy.model;

import com.rightguy.enums.Specialization;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String mobileNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String userType; // "Provider" or "Requester"

    @Column(nullable = false)
    private Specialization specialization; // Applicable only id userType = "Provider"

    @Column(nullable = false)
    private String password;



}
