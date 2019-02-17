package com.example.akshay.teproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper
{

    private static final String DATABASE_NAME = "Collage";
    private static final String TABLE_NAME = "Student";
    private static final String ENQUIRY_TABLE = "Enquiry";
    private static final String COLUMN_1 = "FirstName";
    private static final String COLUMN_2 = "MiddleName";
    private static final String COLUMN_3 = "LastName";
    private static final String COLUMN_4 = "EmailID";
    private static final String COLUMN_5 = "MobileNo";
    private static final String COLUMN_6 = "Branch";
    private static final String COLUMN_7 = "DOB";
    private static final String COLUMN_8 = "TodaysDate";

    private static final String CONTACT_COLUMN_1 = "Fname";
    private static final String CONTACT_COLUMN_2 = "Lname";
    private static final String CONTACT_COLUMN_3 = "Mobile";
    private static final String CONTACT_COLUMN_4 = "Email";
    private static final String CONTACT_COLUMN_5 = "TDate";
    private static final String CONTACT_COLUMN_6 = "UsersComment";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+TABLE_NAME+" ("+COLUMN_1+" TEXT ,"+COLUMN_2+" TEXT,"+COLUMN_3+" TEXT,"+COLUMN_4+" TEXT,"+COLUMN_5+" LONG PRIMARY KEY,"+COLUMN_6+" TEXT,"+COLUMN_7+" TEXT,"+COLUMN_8+" TEXT)");
        db.execSQL("create table "+ENQUIRY_TABLE+" ("+CONTACT_COLUMN_1+" TEXT ,"+CONTACT_COLUMN_2+" TEXT,"+CONTACT_COLUMN_3+" LONG PRIMARY KEY,"+CONTACT_COLUMN_4+" TEXT,"+CONTACT_COLUMN_5+" TEXT,"+CONTACT_COLUMN_6+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        db.execSQL("drop table if exists "+ENQUIRY_TABLE);
    }


    public boolean insertData(String fname,String mname,String lname,String email,String mobile,String branch,String birthDay,String today)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_1,fname);
        cv.put(COLUMN_2,mname);
        cv.put(COLUMN_3,lname);
        cv.put(COLUMN_4,email);
        cv.put(COLUMN_5,mobile);
        cv.put(COLUMN_6,branch);
        cv.put(COLUMN_7,birthDay);
        cv.put(COLUMN_8,today);

        Long result = db.insert(TABLE_NAME,null,cv);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertEnquiry(String fname,String lname,String mobile,String email,String today,String Comment)   //comment remove
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CONTACT_COLUMN_1,fname);
        cv.put(CONTACT_COLUMN_2,lname);
        cv.put(CONTACT_COLUMN_3,mobile);
        cv.put(CONTACT_COLUMN_4,email);
        cv.put(CONTACT_COLUMN_5,today);
        cv.put(CONTACT_COLUMN_6,Comment);

        Long result = db.insert(ENQUIRY_TABLE,null,cv);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllEnquiryData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from "+ENQUIRY_TABLE,null);
        return c;
    }



    public Cursor getAllDatabaseData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from "+TABLE_NAME,null);
        return c;
    }
    public Cursor getSpecificData(Long Mobile)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from "+TABLE_NAME+" where "+COLUMN_5+" = "+Mobile,null);
        return c;
    }


    public boolean updateAllData(String fname,String mname,String lname,String  email, String mobileno,String branch,String BirthDay,String Today)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_1,fname);
        cv.put(COLUMN_2,mname);
        cv.put(COLUMN_3,lname);
        cv.put(COLUMN_4,email);
        cv.put(COLUMN_5,mobileno);
        cv.put(COLUMN_6,branch);
        cv.put(COLUMN_7,BirthDay);
        cv.put(COLUMN_8,Today);

        db.update(TABLE_NAME,cv,"MobileNo = ?",new String[] { mobileno });
        return true;
    }



    public int deleteData(String mobi)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"MobileNo = ?",new String[] {mobi});
    }
}
