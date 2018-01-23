package com.example.gaurk.xpd_office;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by gaurk on 12/20/2017.
 */

public class SessionManager {

    // Sharedpref file name
    private static final String PREF_NAME = "appPrefrences";

    // All Shared Preferences Keys
    // keys should be strings
    //data should be specific data type
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_USER_GENDER = "gender";
    public static final String KEY_USER_FIRST_NAME = "f_name";
    public static final String KEY_USER_LAST_NAME = "l_name";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_USER_PWD = "user_pwd";
    public static final String KEY_USER_TYPE = "user_typ";
    public static final String KEY_USER_DESIGNATION = "user_designation";

    SharedPreferences pref;
    // Editor for Shared preferences
    SharedPreferences.Editor editor;
    // Context
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Constructor
    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public Boolean createLoginSession(String usr_id, String pass_wd, String frst_name, String lst_name, String usr_typ) {
        Log.d("INTO shapref CREAT SESS", "INTO shapref CREAT SESS");
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
        // Storing name in pref
        editor.putString(KEY_USER_ID, usr_id);
        editor.putString(KEY_USER_PWD, pass_wd);
        editor.putString(KEY_USER_FIRST_NAME, frst_name);
        editor.putString(KEY_USER_LAST_NAME, lst_name);
        editor.putString(KEY_USER_TYPE, usr_typ);

        // commit changes
        editor.commit();

        return true;
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     */
    public void checkLogin() {
        // Check login status
        if (!this.isLoggedIn()) {
            Log.d("data null", "data null");

            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, LoginActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        } else {
            Log.d("data present", "data present");

        }
    }

    /**
     * Get stored session data
     */

//    public HashMap<String, String> getBabyDetails() {
//        HashMap<String, String> baby = new HashMap<String, String>();
//
//
//        baby.put(KEY_BABY_NAME, pref.getString(KEY_BABY_NAME, null));
//        baby.put(KEY_BABY_GENDER, pref.getString(KEY_BABY_GENDER, null));
//        baby.put(KEY_BABY_DOB, pref.getString(KEY_BABY_DOB, null));
//
//        baby.put(KEY_BABY_WEIGHT, String.valueOf(pref.getFloat(KEY_BABY_WEIGHT, 0.0f)));
//        baby.put(KEY_BABY_HEIGHT, String.valueOf(pref.getFloat(KEY_BABY_HEIGHT, 0.0f)));
//
//
////         return user
//        return baby;
//    }

    public String get_Specific_Detail(String dataKEY) {

        return pref.getString(dataKEY, null);
    }

    //Inserts single STRING value into shared pref
    public void set_Specific_Detail(String dataKEY, String dataValue) {
        editor.putString(dataKEY, dataValue);
        editor.commit();
    }

    //Inserts single FLOAT value into shared pref
    public void set_Specific_Detail(String dataKEY, Float dataValue) {
        editor.putFloat(dataKEY, dataValue);
        editor.commit();
    }

    /**
     * Clear session details
     */
    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     **/
    // Get Login State
    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }
}