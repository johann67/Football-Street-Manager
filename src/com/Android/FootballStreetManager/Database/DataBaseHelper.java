package com.Android.FootballStreetManager.Database;
import com.classe.Country.Data.CountryDAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
   
	public static final String DATABASE_NAME = "football_bdd";
        
    	public DataBaseHelper(Context context, String name, CursorFactory factory, int version) {
    		super(context, name, factory, version);
    	}

        // onCreate s'execute SEULEMENT lors de l'installation de l'appli (créé donc la BDD)
        @Override
        public void onCreate(SQLiteDatabase db) {
                
                String sqlPlayer = "CREATE TABLE IF NOT EXISTS players (" +
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name_player TEXT, " +
                        "exp_player INTEGER, " +
                        "offensive_player INTEGER, " +
                        "def_player INTEGER, " +
                        "skill_player INTEGER, " +
                        "vitality_player INTEGER, " +
                        "age_player INTEGER, " +
                        "team_player INTEGER)";
        		db.execSQL(sqlPlayer);
        		
                String sqlProfil = "CREATE TABLE IF NOT EXISTS profils (" +
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name_profil TEXT, " +
                        "nationality_profil TEXT" +
                        "team_profil INTEGER)";
        		db.execSQL(sqlProfil);
        		
        		String sqlCountry = "CREATE TABLE IF NOT EXISTS country (" +
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name_country TEXT)";
        		db.execSQL(sqlCountry);
        		
        		String sqlTeam = "CREATE TABLE IF NOT EXISTS team (" +
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name_team TEXT)";
        		db.execSQL(sqlTeam);
                
        }

        // Quand on veut changer la db (pas les valeurs mais la structure)
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL("DROP TABLE IF EXISTS profil");
                onCreate(db);
        }
        
}
