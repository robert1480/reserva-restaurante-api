package com.rrayco.reservarestauranteapi.jsons;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
 
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantRest {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("adress")
	private String adress;
	
	@JsonProperty("image")
	private String image;
	
	@JsonProperty("turn")
	private List<TurnRest> turns;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<TurnRest> getTurns() {
		return turns;
	}

	public void setTurns(List<TurnRest> turns) {
		this.turns = turns;
	}
	
	
	

}
