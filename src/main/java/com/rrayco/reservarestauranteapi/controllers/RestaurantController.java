package com.rrayco.reservarestauranteapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rrayco.reservarestauranteapi.exceptions.BookingException;
import com.rrayco.reservarestauranteapi.jsons.RestaurantRest;
import com.rrayco.reservarestauranteapi.responses.BookingResponse;
import com.rrayco.reservarestauranteapi.services.RestaurantService;

@RestController
@RequestMapping(path = "/booking-restaurant" + "v1")
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "restaurant" + "/{" + "restaurantId"
			+ "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<RestaurantRest> getRestaurantById(Long restaurantId) throws BookingException {
		return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
				restaurantService.getRestaurantById(restaurantId));
	}

}
