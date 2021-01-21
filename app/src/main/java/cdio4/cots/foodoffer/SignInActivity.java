package cdio4.cots.foodoffer;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import cdio4.cots.foodoffer.tools.RegularExpression;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        InitLayout();

        edt_userName.addTextChangedListener(edt_userName_Event);
        edt_password.addTextChangedListener(edt_password_Event);
        edt_passwordConfirm.addTextChangedListener(edt_passswordConfirm_Event);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.next_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.toolbar_next && statusFlag()) {
            intent = new Intent(SignInActivity.this,MainAccountActivity.class);

            intent.putExtra(getResources().getString(R.string.fragmentID),getResources().getInteger(R.integer.USERINFORMATION_FRAGMENT));
            intent.putExtra(getResources().getString(R.string.signIn_status), true);
            intent.putExtra(getResources().getString(R.string.signIn_userName), userName);
            intent.putExtra(getResources().getString(R.string.signIn_password), password);

            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private void InitLayout(){
        edt_userNameLayout = findViewById(R.id.ip_layout_activity_singin_username);
        edt_passwordLayout = findViewById(R.id.ip_layout_activity_signin_password);
        edt_passwordConfirmLayout = findViewById(R.id.ip_layout_activity_signin_password_confirm);
        edt_userName = findViewById(R.id.ip_edt_activity_signin_username);
        edt_password = findViewById(R.id.ip_edt_activity_signin_password);
        edt_passwordConfirm = findViewById(R.id.ip_edt_activity_signin_password_confirm);
    }

    private Boolean statusFlag(){
        if(userName != null && userName != "" &&
                password != null && password != "" && password.equals(password))
            return true;
        else
            return false;
    }

    private RegularExpression regularExpression = new RegularExpression();
    private Intent intent;

    private TextInputLayout edt_userNameLayout;
    private TextInputLayout edt_passwordLayout;
    private TextInputLayout edt_passwordConfirmLayout;
    private TextInputEditText edt_userName;
    private TextInputEditText edt_password;
    private TextInputEditText edt_passwordConfirm;

    private String userName;
    private String password;
    private String passwordConfirm;

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
            regularExpression.checkNull(edt_passwordLayout,charSequence,"Vui lòng nhập mật khẩu");
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
            regularExpression.checkNull(edt_passwordConfirmLayout,charSequence,"Vui lòng nhập lại mật khẩu");
        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (edt_passwordConfirm.getText().toString().equals(password))
                passwordConfirm = edt_passwordConfirm.getText().toString();
            else
                edt_passwordConfirmLayout.setError("Không khớp");
        }
    };

}