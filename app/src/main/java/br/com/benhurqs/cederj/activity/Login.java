package br.com.benhurqs.cederj.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import br.com.benhurqs.cederj.R;
import br.com.benhurqs.cederj.preferences.PreferenceManager;


public class Login extends Activity {

    private EditText edtLogin, edtPwd;
    private TextView txtError;
    private CheckBox cbRemember;
    private PreferenceManager prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    public void init(){
        prefs = new PreferenceManager(this);

        cbRemember = (CheckBox)this.findViewById(R.id.check_login);
        edtLogin = (EditText)this.findViewById(R.id.edt_login);
        edtPwd = (EditText)this.findViewById(R.id.edt_pwd);
        txtError = (TextView)this.findViewById(R.id.txt_error);

        edtPwd.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event){
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)){
                           edtPwd.clearFocus();
                           callLoginService();
                           return true;
                }
                return false;
            }
        });

        txtError.setVisibility(View.GONE);
        loadPreferences();
    }

    public boolean isValid(){
        txtError.setVisibility(View.GONE);
        if (TextUtils.isEmpty(edtLogin.getText()) || TextUtils.isEmpty(edtPwd.getText())){
            txtError.setText(getString(R.string.login_error));
            txtError.setVisibility(View.VISIBLE);
            return false;
        }

        return true;
    }

    public void onClickLogin(View view){
        callLoginService();
    }

    public void callLoginService(){
        hideKeyboard();
        if(!isValid()){
            return;
        }

        prefs.saveRememberLogin(cbRemember.isChecked());
        if(cbRemember.isChecked()){
            prefs.saveLoginData(edtLogin.getText().toString().trim(), edtPwd.getText().toString().trim());
        }

        Intent home = new Intent(this, Home.class);
        startActivity(home);
        this.finish();
    }

    public void loadPreferences(){
        cbRemember.setChecked(prefs.getRememberLogin());
        if(cbRemember.isChecked()) {
            edtLogin.setText(prefs.getLogin());
            edtPwd.setText(prefs.getLogin());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void hideKeyboard() {
        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
