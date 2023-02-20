package com.rrayco.reservarestauranteapi.services.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rrayco.reservarestauranteapi.exceptions.BookingException;
import com.rrayco.reservarestauranteapi.exceptions.InternalServerErrorException;
import com.rrayco.reservarestauranteapi.exceptions.NotFountException;
import com.rrayco.reservarestauranteapi.repositories.ReservationRepository; 
import com.rrayco.reservarestauranteapi.services.CancelReservationService;

 

public class CancelReservationServiceImpl implements CancelReservationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CancelReservationServiceImpl.class);
	
	@Autowired
	private ReservationRepository reservationRepository;

	public String deleteReservations(String locator) throws BookingException {

		reservationRepository.findByLocator(locator)
				.orElseThrow(() -> new NotFountException("LOCATOR_NOT_FOUND", "LOCATOR_NOT_FOUND"));

		try {
			reservationRepository.deleteByLocator(locator);
		} catch (Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR"); 
		}

		return "LOCATOR_DELETED";
	}

}
