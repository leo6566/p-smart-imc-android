package br.com.gilber.SmartIMC;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Controle extends DataBase {
    public Controle(Context context) {
        super(context);
    }

    public boolean create(DataBase dataBase) {
        ContentValues values = new ContentValues();

        values.put("nome", dataBase.getDatabaseName());
        values.put("imc", dataBase.getDatabaseName());

        SQLiteDatabase db = this.getWritableDatabase();
        boolean isCreate = db.insert("imc", null, values) > 0;
        db.close();
        return isCreate;
    }
}

