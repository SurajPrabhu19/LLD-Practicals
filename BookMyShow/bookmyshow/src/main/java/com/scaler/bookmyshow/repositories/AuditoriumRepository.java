package com.scaler.bookmyshow.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.bookmyshow.models.Auditorium;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
    Optional<Auditorium> findById(Long id);
}
