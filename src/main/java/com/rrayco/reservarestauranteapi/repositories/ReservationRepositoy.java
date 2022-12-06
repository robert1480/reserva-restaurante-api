package com.rrayco.reservarestauranteapi.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.rrayco.reservarestauranteapi.entities.Reservation; 
@Repository
public interface ReservationRepositoy extends JpaRepository<Reservation, Long> {
	Optional<Reservation> findById(Long id);
	Optional<Reservation> findByLocator(String locator);
	@Modifying
	@Transactional
	Optional<Reservation> deleteByLocator(String locator);
	Optional<Reservation> findByTurnAndRestaurantId(String turn, Long restaurantId);
}
