package com.scaler.bookmyshow.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel {
    private String name;
    private String address;

    @ManyToOne
    private City city;

    @OneToMany
    private List<Auditorium> auditoriums;
}
