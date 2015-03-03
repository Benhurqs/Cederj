package br.com.benhurqs.cederj.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Benhur on 03/03/15.
 */
public class PreferenceManager {

    public static final String PREFS_NAME = "Cederj_Preferences";
    public static final String PREFS_REMEMBER_LOGIN = "Cederj_remenber";
    public static final String PREFS_LOGIN = "Cederj_login";
    public static final String PREFS_PASSWORD = "Cederj_password";


    private Context context;
    private SharedPreferences pref;

    public  PreferenceManager(Context context){
       pref = context.getSharedPreferences(PREFS_NAME, 0);

    }

    public void saveRememberLogin(boolean value){
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(PREFS_REMEMBER_LOGIN, value);
        editor.commit();
    }

    public boolean getRememberLogin(){
        return pref.getBoolean(PREFS_REMEMBER_LOGIN, false);
    }

    public void saveLoginData(String login, String pwd){
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(PREFS_LOGIN, login);
        editor.putString(PREFS_PASSWORD, pwd);
        editor.commit();
    }

    public String getLogin(){
        return pref.getString(PREFS_LOGIN, "");
    }

    public String getPassword(){
        return pref.getString(PREFS_PASSWORD, "");
    }

}
