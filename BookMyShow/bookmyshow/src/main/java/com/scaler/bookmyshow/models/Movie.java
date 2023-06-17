package com.scaler.bookmyshow.models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Movie extends BaseModel {
    private String name;

    @ManyToMany
    private List<Actor> actors;

    // @ManyToMany
    @ElementCollection // Used when there is a List or Collection of Objects
    @Enumerated(EnumType.ORDINAL)
    private List<Genre> genres;

    // @ManyToMany
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<MovieFeature> feature;
}
