package com.example.fyppharmacistregistration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = DBHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "consultant.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CONSULTATION = "patient_details";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PASSWORD = "password";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createPatientTableSql = "CREATE TABLE " + TABLE_CONSULTATION + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT," +  COLUMN_PASSWORD + " TEXT)";
        db.execSQL(createPatientTableSql);
        Log.i("info", "created tables for patients");
        Log.d("sql", createPatientTableSql);
    }
    public long insertPatientDetails(Consultant consultant) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, consultant.getName());
        values.put(COLUMN_PASSWORD, consultant.getPassword());
        long result = db.insert(TABLE_CONSULTATION, null, values);
        db.close();
        Log.d("SQL Insert","ID:"+ result); //id returned, shouldn’t be -1
        return result;
    }
    public ArrayList<Consultant> getAllPatients() {
        ArrayList<Consultant> consultants = new ArrayList<Consultant>();

        String selectQuery = "SELECT " + COLUMN_ID + ","
                + COLUMN_NAME + "," + COLUMN_PASSWORD  + " FROM " + TABLE_CONSULTATION;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String consultantName = cursor.getString(1);
                String consultantPassword = cursor.getString(2);
                Consultant consultant = new Consultant(consultantName, consultantPassword);
                consultant.setID(id);
                consultants.add(consultant);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return consultants;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONSULTATION);
        onCreate(db);
    }

}
