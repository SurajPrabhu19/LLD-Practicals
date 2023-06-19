package com.scaler.bookmyshow.dtos;

import org.springframework.beans.factory.annotation.Autowired;

import com.scaler.bookmyshow.models.Ticket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDto {
    @Autowired
    public BookTicketResponseDto() {
        super();
    }

    private ResponseDto status;
    private Ticket ticket;
}
