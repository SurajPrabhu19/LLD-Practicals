package com.scaler.bookmyshow.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.scaler.bookmyshow.models.MainShow;
import com.scaler.bookmyshow.models.MovieFeature;
import com.scaler.bookmyshow.services.ShowService;

@Controller
public class ShowController {
    private ShowService showService;

    @Autowired
    public ShowController(ShowService showService) {
        super();
        this.showService = showService;
    }

    public MainShow createShow(Date startTime, Date endTime, Long movieId, Long auditoriumId,
            List<MovieFeature> features,
            Double price) {
        MainShow show = showService.createShow(startTime, endTime, movieId, auditoriumId, features, price);
        return show;
    }
}
