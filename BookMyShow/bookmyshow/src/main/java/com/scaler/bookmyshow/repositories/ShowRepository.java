package com.scaler.bookmyshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.bookmyshow.models.MainShow;

@Repository
public interface ShowRepository
        extends JpaRepository<MainShow, Long> {

    MainShow save(MainShow newShow);
}
