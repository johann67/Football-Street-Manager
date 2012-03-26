package com.Android.FootballStreetManager;

import com.Android.FootballStreetManager.NewEquipe.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FootballStreetManagerActivity extends Activity {
	private Button ButtonNew;
	private Button ButtonLoad;
	
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

    }
}