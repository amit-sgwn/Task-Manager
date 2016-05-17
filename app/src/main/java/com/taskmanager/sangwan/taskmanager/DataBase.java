package com.taskmanager.sangwan.taskmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 17-05-2016.
 */
public class DataBase {


    public static final String KEY_ROWID = "_id";
    public static final String KEY_DATA = "data";
    public static final String KEY_SUB ="subject";
    public static final String KEY_STARTDATE = "start_date";
    public static final String KEY_ENDDATE = "end_date";
    public static final String KEY_STATUS ="status";
    public static final String KEY_PRIO ="priority";

    private static final String DATABASE_NAME ="MYDB";
    private static final String DATABASE_TABLE = "TaskTable";
    private static final int DATABASE_VERSION =1;

    private DBHelper myHelper;
    private  final Context ourContext;
    private SQLiteDatabase MyDataBase;

    public DataBase(Context ourContext) {
        this.ourContext = ourContext;
    }

    public static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_DATA + " TEXT NOT NULL, " + KEY_SUB + " TEXT NOT NULL, " + KEY_STARTDATE + " TEXT NOT NULL, "
                    + KEY_ENDDATE + " TEXT NOT NULL, " + KEY_STATUS + " TEXT NOT NULL, " + KEY_PRIO + " TEXT NOT NULL);"


            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }
    public  DataBase open(){
        myHelper = new DBHelper(ourContext);
        MyDataBase = myHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        myHelper.close();
    }

    }

