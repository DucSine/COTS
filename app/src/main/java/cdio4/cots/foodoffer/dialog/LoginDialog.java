package cdio4.cots.foodoffer.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cdio4.cots.foodoffer.R;

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
            }
        });

        alertDialog.setView(dialog_login);
        alertDialog.show();
    }
}
