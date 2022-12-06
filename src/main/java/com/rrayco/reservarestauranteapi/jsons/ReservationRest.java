package com.rrayco.reservarestauranteapi.jsons;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationRest {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("locator")
	private String locator;

//	@JsonProperty("turn")
//	private String turn;
	
	@JsonProperty("turnId")
	private Long turnId;
	
	@JsonProperty("restaurantId")
	private Long restaurantId;
	
	@JsonProperty("person")
	private String person;

	@JsonProperty("date")
	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

//	public String getTurn() {
//		return turn;
//	}
//
//	public void setTurn(String turn) {
//		this.turn = turn;
//	}
	 
	public String getPerson() {
		return person;
	}

	public Long getTurnId() {
		return turnId;
	}

	public void setTurnId(Long turnId) {
		this.turnId = turnId;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
