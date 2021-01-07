package cdio4.cots.foodoffer.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cdio4.cots.foodoffer.R;

public class LoginDialog extends AlertDialog {
    private EditText edt_username;
    private EditText edt_password;
    private Button btn_login;
    String SHARED_PREFERENCES_NAME = "keydata";

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
                String message = "{"+
                        "\"email\":" + "\"" + username + "\","+
                        "\"password\":" + "\"" + password + "\""+
                        "}";
                Login(message, context);
                SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, context.MODE_PRIVATE);
                boolean st = sharedPreferences.getBoolean("IS_DATE",false);
                if(st)
                    alertDialog.hide();
            }
        });
        alertDialog.setView(dialog_login);
        alertDialog.show();

    }

    protected void Login(String message, Context context){
        String URL="https://doan5.herokuapp.com/api/user/auth/login";
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest loginRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject loginJSON = new JSONObject(response);
                    boolean status= loginJSON.getBoolean("status");
                    saveData(context,status);
                  //  Toast.makeText(context,String.valueOf(status),Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"duc",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return message == null ? null : message.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    return null;
                }
            }
        };
        requestQueue.add(loginRequest);
    }

    public void saveData(Context context, boolean status){
        SharedPreferences sharedPreferences =context.getSharedPreferences(SHARED_PREFERENCES_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("IS_DATE",status);
        editor.commit();
    }

    public void getData(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, context.MODE_PRIVATE);
        boolean isFirtsLauncher = sharedPreferences.getBoolean("IS_DATE",false);

    }


}
