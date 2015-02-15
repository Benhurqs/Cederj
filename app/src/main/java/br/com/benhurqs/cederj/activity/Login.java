package br.com.benhurqs.cederj.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.com.benhurqs.cederj.R;


public class Login extends Activity {

    private EditText edtLogin, edtPwd;
    private TextView txtError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    public void init(){
        edtLogin = (EditText)this.findViewById(R.id.edt_login);
        edtPwd = (EditText)this.findViewById(R.id.edt_pwd);
        txtError = (TextView)this.findViewById(R.id.txt_error);

        txtError.setVisibility(View.GONE);
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
        if(!isValid()){
            return;
        }

        Intent home = new Intent(this, Home.class);
        startActivity(home);
        this.finish();


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
}
