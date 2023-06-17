package com.scaler.bookmyshow.models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
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

    // @OneToMany
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Auditorium> auditoriums;
}
