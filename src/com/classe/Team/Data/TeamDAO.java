package com.classe.Team.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.Android.FootballStreetManager.Database.DataBaseHelper;
import com.classe.Player.Player;
import com.classe.Team.Team;

public class TeamDAO {
	private SQLiteDatabase bdd;
	private DataBaseHelper maBaseSQLite;
	private static final String NAME_BDD = "football_bdd";
	private static final int VERSION_BDD = 1;
	private static final String TABLE_TEAM = "team";
	private static final String COL_ID = "_id";
	private static final int NUM_COL_ID = 0;
	private static final String COL_NAME = "name_team";
	private static final int NUM_COL_NAME = 1;
	
	public TeamDAO(Context context){
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
	
	public long ajouterTeam(Team Team){
		ContentValues values = new ContentValues();
		values.put(COL_NAME, Team.getTeamName());
		
		return bdd.insert(TABLE_TEAM, null, values);
	}
	
	public Team getTeamWithId(long idTeam){
		Cursor c = bdd.query(TABLE_TEAM, new String[] {COL_ID, COL_NAME}, COL_ID + " LIKE \"" + idTeam +"\"", null, null, null, null);
		
		if (c.getCount() == 0)
			return null;
	
		c.moveToFirst();
		Team Team = new Team(c.getInt(NUM_COL_ID),c.getString(NUM_COL_NAME));
		c.close();
				
		return Team;
	}
}
