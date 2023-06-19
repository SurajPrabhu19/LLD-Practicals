package com.scaler.bookmyshow.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.bookmyshow.models.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City save(City city);

    Optional<City> findById(Long id);

}
