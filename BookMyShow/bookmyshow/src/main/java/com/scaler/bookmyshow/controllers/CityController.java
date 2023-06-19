package com.scaler.bookmyshow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.scaler.bookmyshow.models.City;
import com.scaler.bookmyshow.services.UserService;

@Controller
public class CityController {
    private com.scaler.bookmyshow.services.CityService cityService;

    @Autowired
    public CityController(UserService cityService) {
        super();
        this.cityService = cityService;
    }

    public City createCity(String name) {
        City city = cityService.createCity(name);
        return city;
    }
}
