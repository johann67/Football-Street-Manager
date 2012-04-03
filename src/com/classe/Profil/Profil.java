package com.classe.Profil;

import com.classe.Team.*;

public class Profil {
	private long id;
	private String trainerName;
	private String country;
	private long idTeam;
	
	private Team Team;
	
	public Profil(String _trainerName, String _country, Team _team) {
		this.trainerName = _trainerName;
		this.country = _country;
		this.Team = _team;
	}
	
	public Profil(long _id, String _trainerName, String _country, long idTeam){
		this.id = _id;
		this.trainerName = _trainerName;
		this.country = _country;
		this.idTeam = idTeam;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getTrainerName() {
		return trainerName;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	
	public Team getTeam() {
		return Team;
	}
	
	public void setTeam(Team team) {
		Team = team;
	}
}
