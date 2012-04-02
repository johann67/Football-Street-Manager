package com.classe.Country.Data;

import java.util.ArrayList;
import java.util.List;

import com.Android.FootballStreetManager.Database.DataBaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class CountryDAO {
	private SQLiteDatabase bdd;
	private DataBaseHelper maBaseSQLite;
	private static final String NAME_BDD = "football_bdd";
	private static final int VERSION_BDD = 1;
	private static final String TABLE_COUNTRY = "country";
	private static final String COL_ID = "_id";
	private static final int NUM_COL_ID = 0;
	private static final String COL_COUNTRY = "name_country";
	private static final int NUM_COL_COUNTRY = 1;	
	
	public CountryDAO(Context context){
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
	
	public void ajouterCountry(){
		bdd.delete(TABLE_COUNTRY, null, null);
		
		String[] Country = {"France", "Serbie", "Kurdistant"};
		
		ContentValues values;
		
		for (String s : Country){
			values = new ContentValues();
			values.put(COL_COUNTRY, s);
			
			bdd.insert(TABLE_COUNTRY, null, values);
		}
	}
	
	public List<String> getCountry(){
		List<String> listCountry = new ArrayList<String>();
		
		Cursor c = bdd.query(TABLE_COUNTRY, new String[] {COL_ID, COL_COUNTRY}, null, null, null, null, null);
		
		if (c.getCount() == 0)
			return null;
		
		while(c.moveToNext()){
			listCountry.add(c.getString(NUM_COL_COUNTRY));
		}
		
		c.close();
		return listCountry;
	}
}