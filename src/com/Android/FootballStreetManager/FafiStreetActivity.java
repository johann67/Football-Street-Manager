package com.Android.FootballStreetManager;

import com.Android.FootballStreetManager.NewEquipe.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FafiStreetActivity extends Activity implements View.OnClickListener {
	private Button ButtonNew;
	private Button ButtonLoad;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ButtonNew = (Button)findViewById(R.id.nouvelle_partie);
        ButtonLoad = (Button)findViewById(R.id.charger_partie);
        
        ButtonNew.setOnClickListener(this);
        ButtonLoad.setOnClickListener(this);
    }
    
    public void onClick(View v) {
    	if (v == ButtonNew) {
    		Intent intentNew = new Intent(this, NewEquipe.class);
    		startActivity(intentNew);
    	}
    }
}