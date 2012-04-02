package com.classe.Team;

import java.util.List;

import com.classe.Player.*;

public class Team {
	private String teamName;
	private List<Player> listPlayer;
	
	private Team(String nom){
		this.teamName = nom;
	}
	
	public List<Player> getListPlayer() {
		return listPlayer;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setListPlayer(List<Player> listPlayer) {
		this.listPlayer = listPlayer;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}
