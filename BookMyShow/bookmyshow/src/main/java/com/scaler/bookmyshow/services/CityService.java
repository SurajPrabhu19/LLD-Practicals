package com.scaler.bookmyshow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaler.bookmyshow.models.City;
import com.scaler.bookmyshow.repositories.CityRepository;

@Service
public class CityService {
    private CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        super();
        this.cityRepository = cityRepository;
    }

    public City createCity(String name) {
        // Create + intialize:
        City city = new City();
        city.setName(name);

        // Save to the database:
        city = cityRepository.save(city);

        // return the city object
        return city;
    }

}
