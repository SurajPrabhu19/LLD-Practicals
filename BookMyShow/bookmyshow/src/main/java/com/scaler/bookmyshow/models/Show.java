package com.scaler.bookmyshow.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Show {
    private double price;
    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Movie movie;

    @ManyToMany
    private List<MovieFeature> features;

    @ManyToOne
    private Auditorium auditorium;
}
