package com.example.ws6_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_name";

    private static final String tb_pemain = "tb_pemain";

    private static final String tb_pemain_id = "id";
    private static final String tb_pemain_nama = "nama";
    private static final String tb_pemain_accesoris = "accesoris";

    private static final String CREATE_TABLE_PEMAIN = "CREATE TABLE " +
            tb_pemain + "("
            + tb_pemain_id + " INTEGER PRIMARY KEY ,"
            + tb_pemain_nama + " TEXT,"
            + tb_pemain_accesoris + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PEMAIN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void Pemain (Pemain data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_pemain_id, data.get_id());
        values.put(tb_pemain_nama, data.get_nama());
        values.put(tb_pemain_accesoris, data.get_accesoris());
        db.insert(tb_pemain, null, values);
        db.close();
    }

    public List<Pemain> ReadPemain() {
        List<Pemain> listMhs = new ArrayList<Pemain>();
        String selectQuery = "SELECT  * FROM " + tb_pemain;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Pemain data = new Pemain();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_accesoris(cursor.getString(2));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }

    public int UpdatePemain (Pemain data) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tb_pemain_nama, data.get_nama());
        values.put(tb_pemain_accesoris, data.get_accesoris());

        return db.update(tb_pemain, values, tb_pemain_id + " = ?",
                new String[] { String.valueOf(data.get_id())});
    }

    public void DeletePemain (Pemain data) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_pemain, tb_pemain_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }

    public void CreatePemain(Pemain pemain) {
    }
}
