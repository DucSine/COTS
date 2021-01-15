package cdio4.cots.foodoffer.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.firebase.ui.auth.AuthMethodPickerLayout;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.database.RequestAPI;

public class LoginDialog extends AlertDialog {
    private Context context;
    private AlertDialog alertDialog;
    private View dialog_login;
    private TextInputLayout edt_usernameLayout;
    private TextInputLayout edt_passwordLayout;
    private TextInputEditText edt_username;
    private TextInputEditText edt_password;
    private Button btn_login;
    private SharedPreferences sharedPreferences;
    private String username;
    private String password;
    private Boolean status;
    private String token;
    private String errorMessage;

    protected LoginDialog(Context context) {
        super(context);
    }


    public void show() {
      //  InitDialogView();
       // btn_login.setEnabled(false);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "{" +
                        "\"username\":" + "\"" + username + "\"," +
                        "\"password\":" + "\"" + password + "\"" +
                        "}";

                PostAccount(message);
            }
        });

        alertDialog.setView(dialog_login);
        alertDialog.show();
    }

    protected void PostAccount(String message){
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

                    Toast.makeText(context,loginObject.getString("status"),Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                SharedPreferencesSaveData("duc");

                if(status) {
                    alertDialog.hide();
                    //check and reload avatar
                }
            }
        }.execute(context.getResources().getString(R.string.url_Login));
    }

    protected void SharedPreferencesSaveData(String fileName){
        sharedPreferences= context.getSharedPreferences(context.getResources().getString(R.string.shared_preferences_login), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.putBoolean("status",status);
        editor.putString("token",token);
        editor.putString("message",errorMessage);

        editor.commit();
    }

    protected void SharedPreferencesGetData(String fileName){
        sharedPreferences.getBoolean("status",false); // false is default value
    }

   /* private void InitDialogView(){
        alertDialog = new AlertDialog.Builder(context).create();
        dialog_login = getLayoutInflater().inflate(R.layout.dialog_login, null);
        edt_usernameLayout = dialog_login.findViewById(R.id.ip_layout_dialog_username);
        edt_passwordLayout = dialog_login.findViewById(R.id.ip_layout_dialog_password);
        edt_username =  dialog_login.findViewById(R.id.ip_edt_dialog_username);
        edt_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() ==0)
                    edt_usernameLayout.setError("Vui Lòng nhập tên đăng nhập");
                //if (edt_username.getText().toString())
                else
                    edt_passwordLayout.setError(null);

            }

            @Override
            public void afterTextChanged(Editable editable) {
                username = edt_username.getText().toString();
            }
        });
        edt_password =  dialog_login.findViewById(R.id.ip_edt_dialog_password);
        edt_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                password = edt_password.getText().toString();
            }
        });
        btn_login = dialog_login.findViewById(R.id.btn_dialog_login);
    }*/
}
//Lỗi: đóng app nếu k bật internet
//Lỗi: đóng app nếu k translate đc json





