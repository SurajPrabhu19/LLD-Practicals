package com.scaler.bookmyshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.bookmyshow.models.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket save(Ticket ticket);
}
