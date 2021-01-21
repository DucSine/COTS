package cdio4.cots.foodoffer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import cdio4.cots.foodoffer.model.AccountMethod;
import cdio4.cots.foodoffer.tools.RegularExpression;

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
                new AccountMethod(getApplicationContext(), username, password).Login.execute(getResources().getString(R.string.url_Login));
                Boolean status =  sharedPreferences.getBoolean("loginstatus",false);
                if(status)
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignInActivity.class));
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

        sharedPreferences= getSharedPreferences(getResources().getString(R.string.shared_preferences_login), MODE_PRIVATE);
    }

    private SharedPreferences sharedPreferences;
    private RegularExpression regx = new RegularExpression();

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