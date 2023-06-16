package com.scaler.bookmyshow.models;

import java.util.List;

import jakarta.persistence.Entity;
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

    @ManyToMany
    private List<Genre> genres;

    @ManyToMany
    private List<MovieFeature> feature;
}
