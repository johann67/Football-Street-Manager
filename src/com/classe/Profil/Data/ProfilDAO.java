package com.classe.Profil.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.Android.FootballStreetManager.Database.DataBaseHelper;
import com.classe.Profil.Profil;
import com.classe.Team.Team;

public class ProfilDAO {
	private SQLiteDatabase bdd;
	private DataBaseHelper maBaseSQLite;
	private static final String NAME_BDD = "football_bdd";
	private static final int VERSION_BDD = 1;
	private static final String TABLE_PROFIL = "profils";
	
	private static final String COL_ID = "_id";
	private static final int NUM_COL_ID = 0;
	private static final String COL_NAME = "name_profil";
	private static final int NUM_COL_NAME = 1;
	private static final String COL_NATIONALITY = "nationality_profil";
	private static final int NUM_COL_NATIONALITY = 2;
	private static final String COL_TEAM = "team_profil";
	private static final int NUM_COL_TEAM = 3;
	
	public ProfilDAO(Context context){
		maBaseSQLite = new DataBaseHelper(context, NAME_BDD, null, VERSION_BDD);
	}
	
	public void open(){
		bdd = maBaseSQLite.getWritableDatabase();
	}
 
	public void close(){
		bdd.close();
	}
 
	public SQLiteDatabase getBDD(){
		return bdd;
	}
	
	public long ajouterProfil(Profil Profil){
		ContentValues values = new ContentValues();
		
		values.put(COL_NAME, Profil.getTrainerName());
		values.put(COL_NATIONALITY, Profil.getCountry());
		values.put(COL_TEAM, Profil.getTeam().getId());
		
		return bdd.insert(TABLE_PROFIL, null, values);
	}
	
	public Profil getProfilWithId(long idProfil){
		Cursor c = bdd.query(TABLE_PROFIL, new String[] {COL_ID, COL_NAME, COL_NATIONALITY, COL_TEAM}, COL_ID + " LIKE \"" + idProfil +"\"", null, null, null, null);
		
		if (c.getCount() == 0)
			return null;
	
		c.moveToFirst();
		Profil Profil = new Profil(c.getInt(NUM_COL_ID), c.getString(NUM_COL_NAME), c.getString(NUM_COL_NATIONALITY), c.getLong(NUM_COL_TEAM));
		c.close();
		
		return Profil;
	}
}
