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
                edt_username.setText(new ApiRequest(context).GetRequest("https://chat-app-server-1.herokuapp.com/api/rooms/search?q=phong", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjVmYjQ4Mzk1Yzc4NTk3MDAxN2EwYzdjZiIsImlhdCI6MTYwOTQzNTc1NH0.AWMSMarnNwmH2_W3iDB0lnxsHIv-pXyjIP6nge2fPx8").toString());


            }
        });

        alertDialog.setView(dialog_login);
        alertDialog.show();
    }
}
