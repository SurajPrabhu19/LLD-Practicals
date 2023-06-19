package com.scaler.bookmyshow.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaler.bookmyshow.exceptions.AuditoriumNotFoundException;
import com.scaler.bookmyshow.exceptions.MovieNotFoundException;
import com.scaler.bookmyshow.models.Auditorium;
import com.scaler.bookmyshow.models.MainShow;
import com.scaler.bookmyshow.models.Movie;
import com.scaler.bookmyshow.models.MovieFeature;
import com.scaler.bookmyshow.models.Seat;
import com.scaler.bookmyshow.models.ShowSeat;
import com.scaler.bookmyshow.repositories.AuditoriumRepository;
import com.scaler.bookmyshow.repositories.MovieRespository;
import com.scaler.bookmyshow.repositories.ShowRepository;
import com.scaler.bookmyshow.repositories.ShowSeatRepository;

@Service
public class ShowService {
    private ShowRepository ShowRepository;
    private MovieRespository movieRespository;
    private AuditoriumRepository auditoriumRepository;
    private ShowSeatRepository showSeatRepository;

    @Autowired
    public ShowService(ShowRepository showRepository, MovieRespository movieRespository,
            AuditoriumRepository auditoriumRepository, ShowSeatRepository showSeatRepository) {
        super();
        this.ShowRepository = showRepository;
        this.movieRespository = movieRespository;
        this.auditoriumRepository = auditoriumRepository;
        this.showSeatRepository = showSeatRepository;
    }

    public MainShow createShow(Date startTime, Date endTime, Long movieId, Long auditoriumId,
            List<MovieFeature> movieFeatures,
            Double price) throws MovieNotFoundException, AuditoriumNotFoundException {
        // find movie by movie id:
        Optional<Movie> optionalMovie = movieRespository.findById(movieId);
        if (optionalMovie.isEmpty()) {
            throw new MovieNotFoundException();
        }
        Movie movie = optionalMovie.get();

        // find auditorium by Id:
        Optional<Auditorium> optionalAuditorium = auditoriumRepository.findById(auditoriumId);
        if (optionalAuditorium.isEmpty()) {
            throw new AuditoriumNotFoundException();
        }
        Auditorium auditorium = optionalAuditorium.get();

        // Create Show + init:
        MainShow newShow = new MainShow();
        newShow.setStartTime(startTime);
        newShow.setEndTime(endTime);
        newShow.setFeatures(movieFeatures);
        newShow.setMovie(movie);
        newShow.setAuditorium(auditorium);
        newShow.setPrice(100);

        // Save mainshow to Db:
        MainShow savedShow = ShowRepository.save(newShow);

        // Work on creating Show_Seats:
        List<ShowSeat> showSeats = new ArrayList<>();
        for (Seat seat : auditorium.getSeats()) {
            ShowSeat newShowSeat = new ShowSeat();
            newShowSeat.setSeat(seat);
            newShowSeat.setMainShow(savedShow);
            showSeats.add(showSeatRepository.save(newShowSeat)); // save in db + save to List<ShowSeats>
        }

        // Save showseats to Db:
        savedShow.setShowSeats(showSeats);

        // return:
        return savedShow;
    }
}
