package com.scaler.bookmyshow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaler.bookmyshow.exceptions.AuditoriumNotFoundException;
import com.scaler.bookmyshow.exceptions.CityNotFoundException;
import com.scaler.bookmyshow.exceptions.TheatreNotFoundException;
import com.scaler.bookmyshow.models.Auditorium;
import com.scaler.bookmyshow.models.City;
import com.scaler.bookmyshow.models.Seat;
import com.scaler.bookmyshow.models.SeatType;
import com.scaler.bookmyshow.models.Theatre;
import com.scaler.bookmyshow.repositories.AuditoriumRepository;
import com.scaler.bookmyshow.repositories.CityRepository;
import com.scaler.bookmyshow.repositories.SeatRepository;
import com.scaler.bookmyshow.repositories.TheatreRepository;

@Service
public class TheatreService {
    private TheatreRepository theatreRepository;
    private CityRepository cityRepository;
    private AuditoriumRepository auditoriumRepository;
    private SeatRepository seatRepository;

    @Autowired
    public TheatreService(TheatreRepository theatreRepository, CityRepository cityRepository,
            AuditoriumRepository auditoriumRepository, SeatRepository seatRepository) {
        this.theatreRepository = theatreRepository;
        this.cityRepository = cityRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.seatRepository = seatRepository;
    }

    public Theatre createTheatre(String name, String address, Long cityId) throws CityNotFoundException {
        // check existence of City:
        Optional<City> optionalCity = cityRepository.findById(cityId);

        if (optionalCity.isEmpty()) {
            throw new CityNotFoundException();
        }

        City city = optionalCity.get();

        // create + initialize:
        Theatre newTheatre = new Theatre();
        newTheatre.setName(name);
        newTheatre.setAddress(address);
        newTheatre.setCity(city);

        // save this to database:
        Theatre savedTheatre = theatreRepository.save(newTheatre);

        // add this theatre to List<Theatre> in City:
        if (city.getTheatres() == null) {
            city.setTheatres(new ArrayList<Theatre>());
        }
        city.getTheatres().add(savedTheatre);

        // update the db:
        cityRepository.save(city);

        // return
        return savedTheatre;
    }

    public Theatre addAuditorium(Long theatreId, String name, int capacity) throws TheatreNotFoundException {
        // find the theatre:
        Optional<Theatre> optionalTheatre = theatreRepository.findById(theatreId);

        if (optionalTheatre.isEmpty()) {
            throw new TheatreNotFoundException();
        }

        Theatre theatre = optionalTheatre.get();

        // create audit + init:
        Auditorium newAuditorium = new Auditorium();
        newAuditorium.setCapacity(capacity);
        newAuditorium.setName(name);
        newAuditorium.setTheatre(theatre);

        // add/set auditorium in existing Theatre:
        if (theatre.getAuditoriums() == null)
            theatre.setAuditoriums(new ArrayList<Auditorium>());
        theatre.getAuditoriums().add(newAuditorium);

        // save the theatre to Db:
        theatre = theatreRepository.save(theatre);

        // return:
        return theatre;
    }

    // SILVER: 10
    // GOLD: 30
    // VIP: 50
    public void addSeats(Long auditoriumId, Map<SeatType, Integer> seatCount) throws AuditoriumNotFoundException {
        // Find Auditorium:
        Optional<Auditorium> optionalAuditorium = auditoriumRepository.findById(auditoriumId);

        if (optionalAuditorium.isEmpty()) {
            throw new AuditoriumNotFoundException();
        }

        Auditorium auditorium = optionalAuditorium.get();

        // Create new Seats based on count for each type in Map<>:
        List<Seat> seats = new ArrayList<Seat>();
        for (Map.Entry<SeatType, Integer> entry : seatCount.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                Seat seat = new Seat();
                // VIP1 VIP2 VIP3
                // GOLD1 GOLD2 GOLD3
                seat.setSeatName(entry.getKey() + "" + Integer.toString(i + 1));
                seat.setType(entry.getKey());
            }
        }
        // Save Seats to Db:
        List<Seat> savedSeats = seatRepository.saveAll(seats);

        // Save Auditorium to Db:
        auditorium.setSeats(savedSeats);
        Auditorium savedAuditorium = auditoriumRepository.save(auditorium);

    }
}
