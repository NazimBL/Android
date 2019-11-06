package com.example.dell.apptest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DELL on 02/09/2016.
 */
public class MyDbHandler extends SQLiteOpenHelper {

 private  static final int DB_VERSION =1;
   private static final String DB_NAME="products.db";
    static final String DB_TAB="products";
    static final String ID_COLUMN= "_id";
    static final String NAME_COLUMN= "productname";


    public MyDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query= "CREATE TABLE " + DB_TAB + "(" +
                ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                NAME_COLUMN + " TEXT "+
                ");";
        String q="CREATE TABLE IF NOT EXISTS products(id INTEGER PRIMARY KEY AUTOINCREMENT productname TEXT);";


        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST "+DB_TAB);
        onCreate(db);

    }


    void addProduct(Products product){

        ContentValues values=new ContentValues();
        values.put(NAME_COLUMN, product.getProduct_name());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(DB_TAB, null, values);
        db.close();

    }

    void deleteProduct(String productname){

        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM " + DB_TAB + " WHERE " + NAME_COLUMN + " =\"" + productname + "\";");

    }



    String dbToString(){

      String dbString="";
      SQLiteDatabase db=getWritableDatabase();
      String query="SELECT * FROM " + DB_TAB + " WHERE 1";


        Cursor c=db.rawQuery(query,null);

        c.moveToFirst();
        while(!c.isAfterLast()){

            if(c.getString(c.getColumnIndex("productname"))!=null){
                dbString+=c.getString(c.getColumnIndex("productname"));
                dbString+="\n";
            }

            c.moveToNext();
        }


        db.close();


      return  dbString;
    }
}
