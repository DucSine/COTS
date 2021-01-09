package cdio4.cots.foodoffer.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.database.RequestAPI;

public class LoginDialog extends AlertDialog {
    private EditText edt_username;
    private EditText edt_password;
    private Button btn_login;

    public LoginDialog(Context context) {
        super(context);
    }

    public void show(Context context) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        View dialog_login = getLayoutInflater().inflate(R.layout.dialog_login, null);

        edt_username = dialog_login.findViewById(R.id.edt_dialog_username);
        edt_password = dialog_login.findViewById(R.id.edt_dialog_password);

        btn_login = dialog_login.findViewById(R.id.btn_dialog_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edt_username.getText().toString();
                String password = edt_password.getText().toString();
                String message = "{" +
                        "\"email\":" + "\"" + username + "\"," +
                        "\"password\":" + "\"" + password + "\"" +
                        "}";
                new AsyncTask<String, Void, String>() {
                    @Override
                    protected String doInBackground(String... strings) {
                        return new RequestAPI(message, null).PostRequest(strings);
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
                    }
                }.execute("https://doan5.herokuapp.com/api/user/auth/login");
            }
        });
        alertDialog.setView(dialog_login);
        alertDialog.show();

    }

}