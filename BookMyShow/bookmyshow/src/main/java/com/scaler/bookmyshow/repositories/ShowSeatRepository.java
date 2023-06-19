package com.scaler.bookmyshow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.scaler.bookmyshow.models.ShowSeat;

import jakarta.persistence.LockModeType;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    // FOR UPDATE is to inform that -> row needs to be locked in a database -> table
    // this will keep the other transactions keep going for other rows that are not
    // locked due to FOR UPDATE
    @Lock(LockModeType.PESSIMISTIC_WRITE) // SELECT * from Show_Seats where Id in {..List of ids..} FOR UPDATE
    List<ShowSeat> findAllByIdIn(List<Long> showSeatIds);

    ShowSeat save(ShowSeat showSeat);
    // save() can be used to create as well as to update
    // if the ID in the parameter is null -> create
    // else: update is called

    // @Query("select show_id from show_seat where show_seat.id in (?)")
    // List<ShowSeat> findAllByIdInForUpdate(List<Long> showSeatIds);
    // select * from show_seats where id in {} for update

}
