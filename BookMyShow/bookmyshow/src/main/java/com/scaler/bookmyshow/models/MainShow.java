package com.scaler.bookmyshow.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
// @Table(name = "MainShow")
public class MainShow extends BaseModel {
    private double price;
    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Movie movie;

    // 1 : m
    // 1 : 1
    @OneToMany(mappedBy = "mainShow")
    private List<ShowSeat> showSeats;

    // @ManyToMany
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<MovieFeature> features;

    @ManyToOne
    private Auditorium auditorium;
}
