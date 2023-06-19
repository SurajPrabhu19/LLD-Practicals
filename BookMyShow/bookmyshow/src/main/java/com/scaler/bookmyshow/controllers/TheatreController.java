package com.scaler.bookmyshow.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.scaler.bookmyshow.exceptions.AuditoriumNotFoundException;
import com.scaler.bookmyshow.exceptions.CityNotFoundException;
import com.scaler.bookmyshow.exceptions.TheatreNotFoundException;
import com.scaler.bookmyshow.models.SeatType;
import com.scaler.bookmyshow.models.Theatre;
import com.scaler.bookmyshow.services.TheatreService;

@Controller
public class TheatreController {

    private TheatreService theatreService;

    @Autowired
    public TheatreController(TheatreService theatreService) {
        super();
        this.theatreService = theatreService;
    }

    // this is not having a DTO ..... always use DTO to transfer the data
    public Theatre createTheatre(String name, String address, Long cityId) throws CityNotFoundException {
        Theatre newTheatre = theatreService.createTheatre(name, address, cityId);
        return newTheatre;
    }

    // this is not having a DTO ..... always use DTO to transfer the data
    public Theatre addAuditorium(Long theatreId, String name, int capacity) throws TheatreNotFoundException {
        Theatre newTheatre = theatreService.addAuditorium(theatreId, name, capacity);
        return newTheatre;
    }

    // this is not having a DTO ..... always use DTO to transfer the data
    public void addSeats(Long auditoriumId, Map<SeatType, Integer> map)
            throws TheatreNotFoundException, AuditoriumNotFoundException {
        theatreService.addSeats(auditoriumId, map);
    }

}
