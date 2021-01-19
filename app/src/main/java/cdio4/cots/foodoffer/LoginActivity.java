package cdio4.cots.foodoffer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import cdio4.cots.foodoffer.database.RequestAPI;
import cdio4.cots.foodoffer.regx.RegularExpression;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InitLayout();

        edt_username.addTextChangedListener(edt_userName_event);
        edt_password.addTextChangedListener(edt_password_event);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "{" +
                        "\"username\":" + "\"" + username + "\"," +
                        "\"password\":" + "\"" + password + "\"" +
                        "}";
                PostLogin(message);
            }
        });

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(LoginActivity.this, MainAccountActivity.class);
                intent.putExtra(getResources().getString(R.string.fragmentID),2);
                startActivity(intent);
            }
        });
    }

    private void InitLayout(){
        edt_usernameLayout = findViewById(R.id.ip_layout_activity_login_username);
        edt_passwordLayout = findViewById(R.id.ip_layout_activity_login_password);
        edt_username =  findViewById(R.id.ip_edt_activity_login_username);
        edt_password =  findViewById(R.id.ip_edt_activity_login_password);
        btn_login = findViewById(R.id.btn_activity_login_login);
        btn_signin = findViewById(R.id.btn_activity_login_sign_in);
    }

    private void PostLogin(String message){
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... urlRequest) {
                return new RequestAPI(message, null).PostRequest(urlRequest);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                try {
                    JSONObject loginObject = new JSONObject(s);
                    if(loginObject.getString("status").equals("success")){
                        status = true;
                        token = loginObject.getJSONObject("data").getString("token");
                        errorMessage = null;
                    }
                    else {
                        status = false;
                        token = "";
                        errorMessage = loginObject.getJSONObject("error").getString("message");
                    }

                    Toast.makeText(getApplicationContext(),loginObject.getString("status"),Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                SharedPreferencesSaveData(getResources().getString(R.string.shared_preferences_login));

                if(status) {
                    intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    //check and reload avatar
                }
            }
        }.execute(getResources().getString(R.string.url_Login));
    }

    protected void SharedPreferencesSaveData(String fileName){
        sharedPreferences= getSharedPreferences(getResources().getString(R.string.shared_preferences_login), MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.putBoolean("status",status);
        editor.putString("token",token);
        editor.putString("message",errorMessage);

        editor.commit();
    }

    private SharedPreferences sharedPreferences;
    private RegularExpression regx = new RegularExpression();
    private Intent intent;

    private TextInputLayout edt_usernameLayout;
    private TextInputLayout edt_passwordLayout;
    private TextInputEditText edt_username;
    private TextInputEditText edt_password;
    private Button btn_login;
    private Button btn_signin;

    private String username;
    private String password;
    private Boolean status;
    private String token;
    private String errorMessage;

    private TextWatcher edt_userName_event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            regx.checkNull(edt_usernameLayout,charSequence,"Vui lòng nhập tài khoản");
        }

        @Override
        public void afterTextChanged(Editable editable) {
            username = edt_username.getText().toString();
        }
    };
    private TextWatcher edt_password_event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            regx.checkNull(edt_passwordLayout,charSequence,"Vui lòng nhập mật khẩu");
        }

        @Override
        public void afterTextChanged(Editable editable) {
            password = edt_password.getText().toString();
        }
    };
}

   /* protected void SharedPreferencesGetData(String fileName){
        sharedPreferences.getBoolean("status",false); // false is default value
    }
    Lỗi: đóng app nếu k bật internet
    Lỗi: đóng app nếu k translate đc json

    */