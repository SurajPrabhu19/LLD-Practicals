package com.scaler.bookmyshow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
// import jakarta.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

import com.scaler.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.scaler.bookmyshow.exceptions.UserNotRegisteredException;
import com.scaler.bookmyshow.models.ShowSeat;
import com.scaler.bookmyshow.models.ShowSeatStatus;
import com.scaler.bookmyshow.models.Ticket;
import com.scaler.bookmyshow.models.TicketStatus;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.repositories.ShowSeatRepository;
import com.scaler.bookmyshow.repositories.TicketRepository;
import com.scaler.bookmyshow.repositories.UserRepository;

@Service
public class TicketService {
    private TicketRepository ticketRepository;
    private ShowSeatRepository showSeatRepository;
    private UserRepository userRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, ShowSeatRepository showSeatRepository,
            UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE) // Setting the Isolation level to serializable
    public Ticket bookTicket(List<Long> seatIds, Long showId, Long userId)
            throws ShowSeatNotAvailableException, UserNotRegisteredException {

        // 1. Fetch ShowSeats by SeatIDs from the DB
        List<ShowSeat> showSeats = showSeatRepository.findAllByIdIn(seatIds);

        // 2. Check status of those show seats
        for (ShowSeat showSeat : showSeats) {
            // 3. if any of them are NOT AVAILABLE -> throw exception else move forward
            if (!showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new ShowSeatNotAvailableException(showSeat.getId());
            }
        }
        // 4. Take a lock ->
        // took lock in the Repository Class

        // 5. Check if the Seats are in AVAILABLE or NOT by grabbing the list again -
        // Double check Lock
        showSeats = showSeatRepository.findAllByIdIn(seatIds);
        for (ShowSeat showSeat : showSeats) {
            if (!showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE))
                throw new ShowSeatNotAvailableException(showSeat.getId());
        }
        // 6. Set all the values to Locked instead of manually locking a transaction for
        // a long time
        for (ShowSeat showSeat : showSeats) {
            showSeat.setStatus(ShowSeatStatus.LOCKED);
            showSeatRepository.save(showSeat);
        }
        // 7. If AVAILABLE, create a new Object of ticket + Store it into the Database +
        // Return the object
        Ticket ticket = new Ticket();
        ticket.setMainShow(showSeats.get(0).getMainShow());

        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            // userOptional = new Optional<User>(new User());
            throw new UserNotRegisteredException();
        }

        // set few attribs of ticket:
        ticket.setUser(userOptional.get());
        ticket.setStatus(TicketStatus.PENDING);
        ticket.setShowSeats(showSeats);

        return ticketRepository.save(ticket); // save in db + return the object
    }

}
