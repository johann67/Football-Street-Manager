package com.Android.FootballStreetManager;

import com.Android.FootballStreetManager.NewEquipe.*;
import android.database.sqlite.SQLiteDatabase;
import com.Android.FootballStreetManager.Database.DataBaseHelper;

import com.classe.Player.Player;
import com.classe.Player.Data.PlayerDAO;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FootballStreetManagerActivity extends Activity {
	private SQLiteDatabase db;
	private TextView tv;

	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void onClickNouvellePartie(View v) {
		startActivity(new Intent(this, NewEquipe.class));
    }
    
    public void onClickChargerPartie(View v) {
    	/*	Pour tester la génération de nom aléatoire
    	 * Joueur joueur = new Joueur();
    	 * Toast.makeText(this, joueur.getRandomNom(), 10).show();
    	 */
    }
}