package com.rightguy.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Bid {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    @Column(length = 1000)
    private String bidMessage;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private User provider;
}