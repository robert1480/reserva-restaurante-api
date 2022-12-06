package com.rrayco.reservarestauranteapi.services;

import com.rrayco.reservarestauranteapi.exceptions.BookingException;

public interface CancelReservationService {

	public String deleteReservations(String locator) throws BookingException;
	
}
