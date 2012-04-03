package com.classe.Team;

import java.util.ArrayList;
import java.util.List;

import com.classe.Player.*;

public class Team {
	private long id;
	private String teamName;
	private List<Player> listPlayer;
	
	public Team(String nom){
		listPlayer = new ArrayList<Player>();
		
		this.teamName = nom;
	}
	
	public Team(long _id, String nom){
		
		listPlayer = new ArrayList<Player>();
		this.id = _id;
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
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
}
