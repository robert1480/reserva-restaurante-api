package com.rrayco.reservarestauranteapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rrayco.reservarestauranteapi.exceptions.BookingException;
import com.rrayco.reservarestauranteapi.jsons.RestaurantRest;


@Service
public interface RestaurantService {

	RestaurantRest getRestaurantById(Long restaurantId) throws BookingException;
	
	public List<RestaurantRest> getRestaurants() throws BookingException;
}
