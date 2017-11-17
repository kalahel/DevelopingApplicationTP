package com.example.mat.developingapplicationtp;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mathieu on 17/11/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // Database version
    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "eventManager";

    // Table name
    private static final String TABLE_EVENTS = "event";

    // Table columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_LAT = "latitude";
    private static final String KEY_LNG = "longitude";
    private static final String KEY_TYPE = "type";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create the table
    @Override
    public void onCreate(SQLiteDatabase db) {

        ////////////////////////////////////////////////////////////////////////////////////////////
        // TODO                                                                                   //
        ////////////////////////////////////////////////////////////////////////////////////////////

    }

    // Upgrade the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS);

        // Create tables again
        onCreate(db);
    }

    // Add a new row
    void addRow(UsageEvents.Event e) {

        ////////////////////////////////////////////////////////////////////////////////////////////
        // TODO                                                                                   //
        ////////////////////////////////////////////////////////////////////////////////////////////

    }

    // Get all rows
    public List<UsageEvents.Event> getAllRows() {
        List<UsageEvents.Event> l = new ArrayList<>();

        ////////////////////////////////////////////////////////////////////////////////////////////
        // TODO                                                                                   //
        // - Use the select all query                                                             //
        // - Loop through all the rows and add the to a list                                      //
        // - Return the list                                                                      //
        ////////////////////////////////////////////////////////////////////////////////////////////

        return l;
    }

    // Clear the table
    public void clear() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_EVENTS);
    }

}