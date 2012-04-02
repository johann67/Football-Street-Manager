package com.classe.Profil;

public class Profil {
	private String trainerName;
	private String country;
	private int team;
	
	public String getCountry() {
		return country;
	}
	
	public int getTeam() {
		return team;
	}
	
	public String getTrainerName() {
		return trainerName;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public void setTeam(int team) {
		this.team = team;
	}
	
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
}
