package com.rrayco.reservarestauranteapi.services;

import com.rrayco.reservarestauranteapi.exceptions.BookingException;
import com.rrayco.reservarestauranteapi.jsons.CreateReservationRest;
import com.rrayco.reservarestauranteapi.jsons.ReservationRest;

public interface ReservationService {

	
	ReservationRest getReservation(Long reservationId) throws BookingException;
	
	String createReservation(CreateReservationRest createReservationRest) throws BookingException;
	
	
}
