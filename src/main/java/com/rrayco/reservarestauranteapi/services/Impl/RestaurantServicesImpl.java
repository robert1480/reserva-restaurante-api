package com.rrayco.reservarestauranteapi.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.rrayco.reservarestauranteapi.entities.Restaurant;
import com.rrayco.reservarestauranteapi.exceptions.BookingException;
import com.rrayco.reservarestauranteapi.exceptions.NotFountException;
import com.rrayco.reservarestauranteapi.jsons.RestaurantRest;
import com.rrayco.reservarestauranteapi.repositories.RestaurantRepository;
import com.rrayco.reservarestauranteapi.services.RestaurantService;

@Service
public class RestaurantServicesImpl implements RestaurantService {
 
	@Autowired 
	RestaurantRepository restaurantRepository;

	public static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public RestaurantRest getRestaurantById(Long restaurantId) throws BookingException {
		return modelMapper.map(getRestaurantEntity(restaurantId), RestaurantRest.class);
	}

	@Override
	public List<RestaurantRest> getRestaurants() throws BookingException {
		final List<Restaurant> restaurantsEntity = restaurantRepository.findAll();
		return restaurantsEntity.stream().map(service -> modelMapper.map(service, RestaurantRest.class))
				.collect(Collectors.toList());
	}

	private Restaurant getRestaurantEntity(Long restaurantId) throws BookingException {
		return restaurantRepository.findById(restaurantId)
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "RESTAURANT_NOT_FOUND"));
	}

}
