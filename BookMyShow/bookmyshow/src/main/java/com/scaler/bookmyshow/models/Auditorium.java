package com.scaler.bookmyshow.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Auditorium {
    private String name;

    @ManyToMany
    private List<MovieFeature> features;

    @OneToMany
    private List<Seat> seats;
}
