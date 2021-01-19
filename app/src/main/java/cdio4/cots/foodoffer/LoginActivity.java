package cdio4.cots.foodoffer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import cdio4.cots.foodoffer.regx.RegularExpression;

public class LoginActivity extends AppCompatActivity {
    Button btnSignUp;
    private RegularExpression regularExpression = new RegularExpression();

    private TextInputLayout edt_userNameLayout;
    private TextInputLayout edt_passwordLayout;
    private TextInputLayout edt_passwordConfirmLayout;
    private TextInputEditText edt_userName;
    private TextInputEditText edt_password;
    private TextInputEditText edt_passwordConfirm;

    private String userName = "";
    private String password = "";
    private String passwordConfirm = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        edt_userName.addTextChangedListener(edt_userName_Event);
        edt_password.addTextChangedListener(edt_password_Event);
        edt_passwordConfirm.addTextChangedListener(edt_passswordConfirm_Event);

    }

    private void init() {
        edt_userNameLayout = findViewById(R.id.ip_layout_activity_singin_username);
        edt_passwordLayout = findViewById(R.id.ip_layout_activity_signin_password);
        edt_passwordConfirmLayout = findViewById(R.id.ip_layout_activity_signin_password_confirm);

        edt_userName = findViewById(R.id.ip_edt_activity_signin_username);
        edt_password = findViewById(R.id.ip_edt_activity_signin_password);
        edt_passwordConfirm = findViewById(R.id.ip_edt_activity_signin_password_confirm);
        btnSignUp = findViewById(R.id.btn_activity_login_sign_up);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
    }
    private TextWatcher edt_userName_Event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2){
            regularExpression.checkNull(edt_userNameLayout,charSequence,"Vui lòng nhập tài khoản");
        }

        @Override
        public void afterTextChanged(Editable editable) {
            userName = edt_userName.getText().toString();
        }
    };
    private TextWatcher edt_password_Event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            regularExpression.checkNull(edt_userNameLayout,charSequence,"Vui lòng nhập mật khẩu");
        }

        @Override
        public void afterTextChanged(Editable editable) {
            password = edt_password.getText().toString();
        }
    };
    private TextWatcher edt_passswordConfirm_Event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            regularExpression.checkNull(edt_userNameLayout,charSequence,"Vui lòng nhập lại mật khẩu");
        }

        @Override
        public void afterTextChanged(Editable editable) {
            passwordConfirm = edt_passwordConfirm.getText().toString();
        }
    };


}