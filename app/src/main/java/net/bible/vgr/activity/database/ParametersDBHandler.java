package net.bible.vgr.activity.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ParametersDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "parameters.db";
    private static final String TABLE_PARAMETERS = "PARAMETERS";
    //columns names
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_PARAMETER_NAME = "PARAMETER_NAME";
    private static final String COLUMN_PARAMETER_VALUE = "VALUE";

    public ParametersDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query;
        query = "CREATE TABLE " + TABLE_PARAMETERS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PARAMETER_NAME + " TEXT, " +
                COLUMN_PARAMETER_VALUE + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARAMETERS);
        onCreate(db);
    }

    //Add new parameter to the database
    public void addParameter(String parameterName, String parameterValue){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PARAMETER_NAME, parameterName);
        values.put(COLUMN_PARAMETER_VALUE, parameterValue);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PARAMETERS,null, values);
        db.close();
    }

    //Delete parameter from database
    public void deleteParameter(String parameterName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PARAMETERS + " WHERE " + COLUMN_PARAMETER_NAME + " = \"" + parameterName + "\";");
        db.close();
    }

    //Update  parameter from database
    public void updateParameter(String parameterName, String parameterValue) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_PARAMETERS + " SET " + COLUMN_PARAMETER_VALUE + " = \"" + parameterValue + "\" WHERE COLUMN_PARAMETER_NAME = \"" + parameterName + "\";");
        db.close();
    }

    //Check if parameter already exists
    public boolean isParameterPresent(String parameterName) {
        SQLiteDatabase db = getWritableDatabase();
        String[] columns = {COLUMN_PARAMETER_VALUE};
        Cursor c = null;

        try {
            c = db.query(true,TABLE_PARAMETERS,columns,COLUMN_PARAMETER_VALUE + " =\"" + parameterName + "\"",null,null,null,null,null);

            if (c==null) {
                return false;
            }
            else {
                return true;
            }

        } finally {
            if(c != null) { c.close(); }
            db.close();
        }

    }

    //Get value of a specific parameter
    public String getParameterValue(String parameterName) {
        SQLiteDatabase db = getWritableDatabase();
        String[] columns = {COLUMN_PARAMETER_VALUE};
        Cursor c = null;

        try {
            c = db.query(true,TABLE_PARAMETERS,columns,COLUMN_PARAMETER_VALUE + " =\"" + parameterName + "\"",null,null,null,null,null);

            //if parameter doesn't exists return empty string
            if (c==null) {
                return "";
            }
            else {
                return c.getString(0);
            }

        } finally {
            if(c != null) { c.close(); }
            db.close();
        }

    }
}
