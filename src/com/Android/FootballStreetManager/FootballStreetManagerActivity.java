package com.Android.FootballStreetManager;

import com.Android.FootballStreetManager.NewEquipe.*;
import android.database.sqlite.SQLiteDatabase;
import com.Android.FootballStreetManager.Database.DataBaseHelper;
import com.Android.FootballStreetManager.Database.PlayerDAO;

import com.classe.Player.Player;

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
        
        PlayerDAO pDao = new PlayerDAO(this);
        pDao.open();
        Player player = new Player(0,"Chris",1,2,3,4,5,6,"Team");
        pDao.ajouterPlayer(player);
        
        tv = (TextView) findViewById(R.id.textView2);
        Player player2 = pDao.getPlayerWithName("Chris");
        if (player2 == null){
        tv.setText("Pas d'entrée");
        }
        else {
        tv.setText(player2.getName());
        }
        

        
        //Chris il est pdpdpdpdpdpd
    }
    
    public void onClickNouvellePartie(View v) {
    	Intent intentNew = new Intent(this, NewEquipe.class);
		startActivity(intentNew);
    }
    
    public void onClickChargerPartie(View v) {
    	/*	Pour tester la génération de nom aléatoire
    	 * Joueur joueur = new Joueur();
    	 * Toast.makeText(this, joueur.getRandomNom(), 10).show();
    	 */
    }
}