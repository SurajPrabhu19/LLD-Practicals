package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.models.Ticket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDto {
    private ResponseStatusDto status;
    private Ticket ticket;
}
