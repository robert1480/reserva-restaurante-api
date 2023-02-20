package com.rrayco.reservarestauranteapi.services.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrayco.reservarestauranteapi.entities.Reservation;
import com.rrayco.reservarestauranteapi.entities.Restaurant;
import com.rrayco.reservarestauranteapi.entities.Turn;
import com.rrayco.reservarestauranteapi.exceptions.BookingException;
import com.rrayco.reservarestauranteapi.exceptions.InternalServerErrorException;
import com.rrayco.reservarestauranteapi.exceptions.NotFountException;
import com.rrayco.reservarestauranteapi.jsons.CreateReservationRest;
import com.rrayco.reservarestauranteapi.jsons.ReservationRest;
import com.rrayco.reservarestauranteapi.repositories.ReservationRepository; 
import com.rrayco.reservarestauranteapi.repositories.RestaurantRepository;
import com.rrayco.reservarestauranteapi.repositories.TurnRepository;
import com.rrayco.reservarestauranteapi.services.ReservationService;

 
@Service
public class ReservationServiceImpl implements ReservationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private TurnRepository turnRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public ReservationRest getReservation(Long reservationId) throws BookingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createReservation(CreateReservationRest createReservationRest) throws BookingException {

		final Restaurant restaurantId = restaurantRepository.findById(createReservationRest.getRestaurantId())
				.orElseThrow(() -> new NotFountException("RESTAURANT_NOT_FOUND", "RESTAURANT_NOT_FOUND"));

		final Turn turn = turnRepository.findById(createReservationRest.getTurnId())
				.orElseThrow(() -> new NotFountException("TURN_NOT_FOUND", "TURN_NOT_FOUND"));

		String locator = generateLocator(restaurantId, createReservationRest);

		final Reservation reservation = new Reservation();
		reservation.setLocator(locator);
		reservation.setPerson(createReservationRest.getPerson());
		reservation.setDate(createReservationRest.getDate());
		reservation.setRestaurant(restaurantId);
		reservation.setTurn(turn.getName());
		try {
			reservationRepository.save(reservation);

		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		
		return locator;
	}

	private String generateLocator(Restaurant restaurantId, CreateReservationRest createReservationRest)
			throws BookingException {
		return restaurantId.getName() + createReservationRest.getTurnId();
	}

}
