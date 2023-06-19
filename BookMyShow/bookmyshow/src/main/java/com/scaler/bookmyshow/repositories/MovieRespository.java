package com.scaler.bookmyshow.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.bookmyshow.models.Movie;

@Repository
public interface MovieRespository extends JpaRepository<Movie, Long> {
    Movie save(Movie movie);

    Optional<Movie> findById(Long id);
}
