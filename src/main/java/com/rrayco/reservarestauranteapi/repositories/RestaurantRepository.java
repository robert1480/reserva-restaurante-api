package com.rrayco.reservarestauranteapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rrayco.reservarestauranteapi.entities.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	
	Optional<Restaurant> findById(Long id);
	Optional<Restaurant> findByName(String nameRestaurant);
	
	//@Query("select rest from restaurant rest")
	//public List<Restaurant> findRestaurants();

}
