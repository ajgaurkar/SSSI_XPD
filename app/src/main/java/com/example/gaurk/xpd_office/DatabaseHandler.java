package com.example.gaurk.xpd_office;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by gaurk on 12/24/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "XPDGlobalDatabase";
    private static final String TABLE_EMPLOYEE = "employee_table";

    //VACCINE TABLE COLUMNS
    private static final String KEY_EMP_ID = "id";
    private static final String KEY_EMP_F_NAME = "empF_Name";
    private static final String KEY_EMP_L_NAME = "empL_Name";
    private static final String KEY_EMP_M_NAME = "empM_Name";
    private static final String KEY_EMP_HIRE_DT = "empHireDt";
    private static final String KEY_EMP_REL_DT = "empRelDt";
    private static final String KEY_EMP_RETR_DT = "empRetrDt";
    private static final String KEY_EMP_POSITION = "empPosition";
    private static final String KEY_EMP_DEPT = "empDept";
    private static final String KEY_EMP_OFF_EMAIL = "empOffEmail";
    private static final String KEY_EMP_REP_MGR = "empRepMgr";


    SQLiteDatabase db;
    Cursor cursor;

    public DatabaseHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String CREATE_TABLE_CHECK_LIST = "CREATE TABLE IF NOT EXISTS " + TABLE_EMPLOYEE + "("
                + KEY_EMP_ID + " TEXT , " + KEY_EMP_F_NAME + " TEXT, " + KEY_EMP_M_NAME + " TEXT, " + KEY_EMP_L_NAME + " TEXT ,"
                + KEY_EMP_HIRE_DT + " TEXT, " + KEY_EMP_REL_DT + " TEXT ," + KEY_EMP_RETR_DT
                + " TEXT , " + KEY_EMP_POSITION + " TEXT, " + KEY_EMP_DEPT + " TEXT ,"
                + KEY_EMP_OFF_EMAIL + " TEXT ," + KEY_EMP_REP_MGR + " TEXT " + ")";

//        String CREATE_TABLE_CHECK_LIST = "CREATE TABLE IF NOT EXISTS " + TABLE_EMPLOYEE + "("
//                + KEY_ITEM_ID + "INTEGER AUTO INCREMENT PRIMARY KEY, " + KEY_ITEM_NAME + " TEXT, " + KEY_MARKED_STATUS_CHECK + " INTEGER, "
//                + KEY_DEPARTURE_TYPE + "TEXT," + KEY_ITEM_CATEGORY + " TEXT, " + KEY_CUSTOM_ENTRY + " INTEGER, "
//                + KEY_DELETED_STATUS + " INTEGER " + ")";


        System.out.println("CREATE_TABLE_CHECK_LIST : " + CREATE_TABLE_CHECK_LIST);

        db.execSQL(CREATE_TABLE_CHECK_LIST);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding item
    public void addEmpItem(EmpItemListData itemListData) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EMP_ID, itemListData.getEmpId());
        values.put(KEY_EMP_F_NAME, itemListData.getEmpFName());
        values.put(KEY_EMP_M_NAME, itemListData.getEmpMName());
        values.put(KEY_EMP_L_NAME, itemListData.getEmpLName());
        values.put(KEY_EMP_DEPT, itemListData.getEmpDept());
        values.put(KEY_EMP_HIRE_DT, itemListData.getEmpHireDt());
        values.put(KEY_EMP_REL_DT, itemListData.getEmpRelDt());
        values.put(KEY_EMP_RETR_DT, itemListData.getEmpRetrDt());
        values.put(KEY_EMP_REP_MGR, itemListData.getEmpRepMgr());
        values.put(KEY_EMP_POSITION, itemListData.getEmpPos());
        values.put(KEY_EMP_OFF_EMAIL, itemListData.getEmpOffEmail());

        System.out.println("INSIDE addEmpItem getItemId" + itemListData.getEmpId());
        System.out.println("INSIDE addEmpItem getItemName" + itemListData.getEmpFName());
        System.out.println("INSIDE addEmpItem getItemDetail" + itemListData.getEmpLName());
        System.out.println("INSIDE addEmpItem getPriority" + itemListData.getEmpMName());
        System.out.println("INSIDE addEmpItem getCategory" + itemListData.getEmpDept());
        System.out.println("INSIDE addEmpItem getMarkStatus" + itemListData.getEmpHireDt());
        System.out.println("INSIDE addEmpItem getCustomEntry" + itemListData.getEmpRelDt());
        System.out.println("INSIDE addEmpItem getDepartureType" + itemListData.getEmpRetrDt());
        System.out.println("INSIDE addEmpItem getDeletedStatus" + itemListData.getEmpRepMgr());
        System.out.println("INSIDE addEmpItem getReminderFlag" + itemListData.getEmpPos());
        System.out.println("INSIDE addEmpItem getReminderTime" + itemListData.getEmpOffEmail());

        // Inserting Row
        long insertResult = db.insert(TABLE_EMPLOYEE, null, values);
        System.out.println("insertResult : " + insertResult);
        db.close(); // Closing database connection
    }

    public Cursor getAllEmpDataByCursor() {
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_EMPLOYEE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        return cursor;
    }

    public ArrayList<EmpItemListData> getEmpItemList() {
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_EMPLOYEE;

        System.out.println("selectQuery : " + selectQuery);

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        System.out.println("cursor.getCount() : " + cursor.getCount());
        System.out.println("cursor.getColumnCount() : " + cursor.getColumnCount());

        ArrayList<EmpItemListData> itemList = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                itemList.add(new EmpItemListData(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9),
                        cursor.getString(10)));

                System.out.println("LOOOP ITEM LIST : " + itemList);


            } while (cursor.moveToNext());
        }
        System.out.println("FINAAAAAL ITEM LIST : " + itemList);

        cursor.close();

        return itemList;
    }


    // Updating Vaccine Tables
    public int updateItem(EmpItemListData itemListData) {
        db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EMP_ID, itemListData.getEmpId());
        values.put(KEY_EMP_F_NAME, itemListData.getEmpFName());
        values.put(KEY_EMP_M_NAME, itemListData.getEmpMName());
        values.put(KEY_EMP_L_NAME, itemListData.getEmpLName());
        values.put(KEY_EMP_DEPT, itemListData.getEmpDept());
        values.put(KEY_EMP_HIRE_DT, itemListData.getEmpHireDt());
        values.put(KEY_EMP_REL_DT, itemListData.getEmpRelDt());
        values.put(KEY_EMP_RETR_DT, itemListData.getEmpRetrDt());
        values.put(KEY_EMP_REP_MGR, itemListData.getEmpRepMgr());
        values.put(KEY_EMP_POSITION, itemListData.getEmpPos());
        values.put(KEY_EMP_OFF_EMAIL, itemListData.getEmpOffEmail());



        System.out.println("");
        System.out.println("KEY_ITEM_ID " + itemListData.getEmpId());

        // updating row
        return db.update(TABLE_EMPLOYEE, values, KEY_EMP_ID + " = ?",
                new String[]{String.valueOf(itemListData.getEmpId())});
    }

    //    public int deleteCalendarRecord(CalendarEntryListData calendarEntryListData) {
    public int deleteItemEntry(String itemId) {
        db = this.getWritableDatabase();

        System.out.println("DatabaseHandler itemId : " + itemId);
        // deleting record
        return db.delete(TABLE_EMPLOYEE, KEY_EMP_ID + "= ?", new String[]{itemId});

    }

    //This method is used in MainActivtiy  Class to  delete all table from database at time of sign out .
    public void deleteDatabaseTables() {
        System.out.println("INSIDE DROP QUERY");

        SQLiteDatabase deleteObj = this.getReadableDatabase();
        deleteObj.delete(TABLE_EMPLOYEE, null, null);
        deleteObj.close();

    }

}

