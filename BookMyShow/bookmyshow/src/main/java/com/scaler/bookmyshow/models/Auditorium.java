package com.scaler.bookmyshow.models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel {
    private String name;
    private int capacity;

    // @ManyToMany
    @ElementCollection // since this is collection/List of String/Number that is going to be stored
    @Enumerated(EnumType.ORDINAL) // ORDINAL (Number), STRING
    private List<MovieFeature> features;

    @OneToMany
    private List<Seat> seats;

    // 1 A : 1 T
    // M A : 1 T
    @ManyToOne
    private Theatre theatre;
}
