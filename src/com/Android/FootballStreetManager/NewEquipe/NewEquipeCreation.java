package com.Android.FootballStreetManager.NewEquipe;

import com.Android.FootballStreetManager.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.classe.Player.*;
import com.classe.Player.Data.PlayerDAO;
import com.classe.Team.*;
import com.classe.Team.Data.TeamDAO;
import com.classe.Profil.*;
import com.classe.Profil.Data.ProfilDAO;


public class NewEquipeCreation extends Activity{
	private Team Team;
	private Player Player;
	private Profil Profil;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_game_creation);
				
		TeamDAO TeamDAO = new TeamDAO(this);
		TeamDAO.open();
		
		PlayerDAO PlayerDAO = new PlayerDAO(this);
		PlayerDAO.open();
		
		ProfilDAO ProfilDAO = new ProfilDAO(this);
		ProfilDAO.open();
		
		Intent thisIntent = getIntent();	
		
		Team = new Team(thisIntent.getExtras().getString("teamName"));		
		Team.setId(TeamDAO.ajouterTeam(Team));
		
		Profil = new Profil(thisIntent.getExtras().getString("trainerName"), thisIntent.getExtras().getString("country"),Team);
		Profil.setId(ProfilDAO.ajouterProfil(Profil));
				
		for (int i=0; i<5; i++) {
			Player = new Player();
			Player.setId(PlayerDAO.ajouterPlayer(Player, Team.getId()));
			
			Profil.getTeam().getListPlayer().add(Player);
		}
		
		System.out.println(ProfilDAO.getProfilWithId(Profil.getId()).getTrainerName());
		System.out.println(TeamDAO.getTeamWithId(Profil.getTeam().getId()).getTeamName());
		
		for (Player p : PlayerDAO.getPlayerWithTeam(Profil.getTeam().getId())){
			System.out.println(p.getName());
		}
		
	}
}
