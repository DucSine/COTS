package cdio4.cots.foodoffer.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.database.RequestAPI;

public class LoginDialog extends AlertDialog {
    private Context context;
    private AlertDialog alertDialog;
    private EditText edt_username;
    private EditText edt_password;
    private Button btn_login;
    private SharedPreferences sharedPreferences;
    private String username;
    private String password;
    private Boolean status;
    private String token;
    private String errorMessage;

    public LoginDialog(Context context){
        super(context);
        this.context = context;
    }

    public void show() {
        alertDialog = new AlertDialog.Builder(context).create();
        View dialog_login = getLayoutInflater().inflate(R.layout.dialog_login, null);

        edt_username = dialog_login.findViewById(R.id.edt_dialog_username);
        edt_password = dialog_login.findViewById(R.id.edt_dialog_password);
        btn_login = dialog_login.findViewById(R.id.btn_dialog_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = edt_username.getText().toString();
                password = edt_password.getText().toString();
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
///
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
}