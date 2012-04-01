package com.classe.Player.Data;

import com.Android.FootballStreetManager.Database.DataBaseHelper;
import com.classe.Player.Player;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class PlayerDAO {
	private SQLiteDatabase bdd;
	private DataBaseHelper maBaseSQLite;
	private static final String NAME_BDD = "football_bdd";
	private static final int VERSION_BDD = 1;
	private static final String TABLE_PLAYERS = "players";
	private static final String COL_ID = "_id";
	private static final int NUM_COL_ID = 0;
	private static final String COL_NAME = "name_player";
	private static final int NUM_COL_NAME = 1;
	private static final String COL_EXP = "exp_player";
	private static final int NUM_COL_EXP = 2;
	private static final String COL_OFFENSIVE = "offensive_player";
	private static final int NUM_COL_OFFENSIVE = 3;
	private static final String COL_DEF = "def_player";
	private static final int NUM_COL_DEF = 4;
	private static final String COL_SKILL = "skill_player";
	private static final int NUM_COL_SKILL = 5;
	private static final String COL_VITALITY = "vitality_player";
	private static final int NUM_COL_VITALITY = 6;
	private static final String COL_AGE = "age_player";
	private static final int NUM_COL_AGE = 7;
	private static final String COL_TEAM = "team_player";
	private static final int NUM_COL_TEAM = 8;
	
	
	
	public PlayerDAO(Context context){
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
	
	public long ajouterPlayer(Player player){
		ContentValues values = new ContentValues();
		values.put(COL_NAME, player.getName());
		values.put(COL_EXP, player.getExp());
		values.put(COL_OFFENSIVE, player.getOffensive());
		values.put(COL_DEF, player.getDef());
		values.put(COL_SKILL, player.getSkill());
		values.put(COL_VITALITY, player.getVitality());
		values.put(COL_AGE, player.getAge());
		values.put(COL_TEAM, player.getTeam());

		return bdd.insert(TABLE_PLAYERS, null, values);
	}
	
	public Player getPlayerWithName(String name){
		Cursor c = bdd.query(TABLE_PLAYERS, new String[] {COL_ID, COL_NAME, COL_EXP, COL_OFFENSIVE, COL_DEF, COL_SKILL, COL_VITALITY, COL_AGE, COL_TEAM}, COL_NAME + " LIKE \"" + name +"\"", null, null, null, null);
		return cursorToPlayer(c);
	}
	
	private Player cursorToPlayer(Cursor c){
		if (c.getCount() == 0)
			return null;
 
		c.moveToFirst();
		Player player = new Player(c.getInt(NUM_COL_ID),c.getString(NUM_COL_NAME),c.getInt(NUM_COL_EXP),c.getInt(NUM_COL_OFFENSIVE),c.getInt(NUM_COL_DEF),c.getInt(NUM_COL_SKILL),c.getInt(NUM_COL_VITALITY),c.getInt(NUM_COL_AGE),c.getString(NUM_COL_TEAM));
		c.close();
		return player;
	}
	
	
}
