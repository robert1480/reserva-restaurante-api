package com.rrayco.reservarestauranteapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rrayco.reservarestauranteapi.exceptions.BookingException;
import com.rrayco.reservarestauranteapi.responses.BookingResponse;
import com.rrayco.reservarestauranteapi.services.CancelReservationService;


@RestController
@RequestMapping(path="/booking-restaurant" + "/v1")
public class CancelarReservationController {

	@Autowired
	CancelReservationService cancelReservationService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "reservation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<String> deleteReservation(@RequestParam String locator) throws BookingException{
		return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
				cancelReservationService.deleteReservations(locator));
	}
	
	
}

