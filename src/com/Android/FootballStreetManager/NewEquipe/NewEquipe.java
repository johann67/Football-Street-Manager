package com.Android.FootballStreetManager.NewEquipe;

import com.Android.FootballStreetManager.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.classe.Country.Data.*;

public class NewEquipe extends Activity {
	private CountryDAO CountryDAO;
	
	private Spinner country;
	private TextView trainerName;
	private TextView teamName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_game);
		
		CountryDAO = new CountryDAO(this);
		CountryDAO.open();
		
		CountryDAO.ajouterCountry();
		
		country = (Spinner) findViewById(R.id.spinner1);
		
		ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		for (String s : CountryDAO.getCountry()) {
			adapter.add(s);
		}
				
		country.setAdapter(adapter);
		
		CountryDAO.close();
	}
	
	public void onClickCreation(View v) {
		trainerName = (TextView) findViewById(R.id.textViewNom);
		teamName = (TextView) findViewById(R.id.textViewNomEquipe);
		
		if (!(trainerName.equals("") || teamName.equals(""))) {
			Intent intentNew = new Intent(this, NewEquipe.class);
			
			intentNew.putExtra("trainerName", trainerName.getText());
			intentNew.putExtra("teamName", teamName.getText());
			intentNew.putExtra("country", country.getSelectedItem().toString());
			
			startActivity(intentNew);
		} else {
			Toast.makeText(getBaseContext(),
					"Vous n'avez pas remplit tous les champs",
					Toast.LENGTH_SHORT).show();
		}
	}
}
