package br.com.gilber.SmartIMC;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "WEBSERVICE";
            public DataBase(Context context){
                super(context, DATABASE_NAME,null,DATABASE_VERSION);

            }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = " CREATE TABLE nome  ( id_nome INTEGER PRIMARY KEY AUTOINCREMENT,nome TEXT )";
        db.execSQL(sql);

        switch (sql = " CREATE TABLE imc  ( id_imc INTEGER PRIMARY KEY AUTOINCREMENT,peso double,altura double,imc double, CONSTRAINT fk_nome FOREIGN KEY (id_nome) REFERENCES nome(id_nome))") {

        }
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String sql = "DROP TABLE IF EXISTS nome";
        switch (sql = "DROP TABLE IF EXISTS imc") {
        }
            db.execSQL(sql);
            onCreate(db);
    }
}
