package com.scaler.bookmyshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.bookmyshow.models.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

}
