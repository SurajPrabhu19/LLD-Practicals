package com.scaler.bookmyshow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.scaler.bookmyshow.models.City;
import com.scaler.bookmyshow.services.CityService;

@Controller
public class CityController {
    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        super();
        this.cityService = cityService;
    }

    public City createCity(String name) {
        City city = cityService.createCity(name);
        return city;
    }
}
