package com.scaler.bookmyshow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.scaler.bookmyshow.models.Ticket;
import com.scaler.bookmyshow.repositories.ShowSeatRepository;
import com.scaler.bookmyshow.repositories.TicketRepository;

public class TicketService {
    private TicketRepository ticketRepository;
    private ShowSeatRepository showSeatRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, ShowSeatRepository showSeatRepository) {
        this.ticketRepository = ticketRepository;
        this.showSeatRepository = showSeatRepository;
    }

    public Ticket bookTicket(List<Long> seatIds, Long showId, Long userId) {
        // List<ShowSeat> showSeats = showSeatRepository.findAllByIdIn(seatIds);
        // 1. Fetch ShowSeats by SeatIDs from the DB
        // 2. Check status of those show seats
        // 3. if any of them are NOT AVAILABLE -> throw exception else move forward
        // 4. Take a lock
        // 5. Check if the Seats are in AVAILABLE or NOT
        // 6. If AVAILABLE, create a new Object of ticket and Store it into the Database
        return null-;
    }

}
