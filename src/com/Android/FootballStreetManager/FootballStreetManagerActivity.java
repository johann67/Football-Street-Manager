package com.Android.FootballStreetManager;

import com.Android.FootballStreetManager.NewEquipe.*;
import com.classe.Joueur.Joueur;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FootballStreetManagerActivity extends Activity {
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //chris ne sait pas coder
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