package com.scaler.bookmyshow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.scaler.bookmyshow.dtos.BookTicketRequestDto;
import com.scaler.bookmyshow.dtos.BookTicketResponseDto;
import com.scaler.bookmyshow.models.Ticket;
import com.scaler.bookmyshow.services.TicketService;

@Controller
public class TicketController {
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto request) {
        Ticket ticket = ticketService.bookTicket(request.getSeatIds(), request.getShowId(), request.getUserId());
        return null-;
    }
}
