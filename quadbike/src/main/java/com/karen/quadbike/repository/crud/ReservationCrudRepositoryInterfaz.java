package com.karen.quadbike.repository.crud;

import org.springframework.data.repository.CrudRepository;

import com.karen.quadbike.model.Reservation;

public interface ReservationCrudRepositoryInterfaz extends CrudRepository<Reservation, Integer> {
    
}
