package com.scaler.bookmyshow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.scaler.bookmyshow.dtos.BookTicketRequestDto;
import com.scaler.bookmyshow.dtos.BookTicketResponseDto;
import com.scaler.bookmyshow.dtos.ResponseDto;
import com.scaler.bookmyshow.dtos.ResponseStatusDto;
import com.scaler.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.scaler.bookmyshow.exceptions.UserNotRegisteredException;
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
        Ticket ticket = null;
        try {
            ticket = ticketService.bookTicket(request.getSeatIds(), request.getShowId(), request.getUserId());
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("Data Successfully Fetched");
            responseDto.setResponseStatusDto(ResponseStatusDto.SUCCESS);

            BookTicketResponseDto bookTicketResponseDto = new BookTicketResponseDto();
            bookTicketResponseDto.setStatus(responseDto);
            bookTicketResponseDto.setTicket(ticket);
            return bookTicketResponseDto;

        } catch (ShowSeatNotAvailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UserNotRegisteredException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
