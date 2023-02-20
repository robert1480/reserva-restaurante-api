package com.rrayco.reservarestauranteapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rrayco.reservarestauranteapi.exceptions.BookingException;
import com.rrayco.reservarestauranteapi.jsons.CreateReservationRest;
import com.rrayco.reservarestauranteapi.responses.BookingResponse;
import com.rrayco.reservarestauranteapi.services.ReservationService;

@RestController
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "reservation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<String> createReservation(@RequestBody CreateReservationRest createReservationRest)
			throws BookingException {
		return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
				reservationService.createReservation(createReservationRest));
	}
	
	
	//implementar "Buscar reserva por id"
	
	     

}
