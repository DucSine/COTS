package cdio4.cots.foodoffer;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class UserInfomation extends AppCompatActivity {
    private TextInputLayout edt_usFullnameLayout;
    private TextInputLayout edt_usBdateLayout;
    private TextInputLayout edt_usIDLayout;
    private TextInputLayout edt_usPhoneLayout;
    private TextInputLayout edt_usEmailLayout;
    private TextInputLayout edt_usAdressLayout;
    private TextInputEditText edt_usFullname;
    private TextInputEditText edt_usBdate;
    private TextInputEditText edt_usID;
    private TextInputEditText edt_usPhone;
    private TextInputEditText edt_usEmail;
    private TextInputEditText edt_usAdress;
    private RadioGroup rbtGroupGender;
    private RadioButton rbt_usMale;
    private RadioButton rbt_usFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_infomation);
        InitLayout();
    }

    private void InitLayout(){
        edt_usFullnameLayout = findViewById(R.id.ip_layout_us_info_fullname);
        edt_usBdateLayout = findViewById(R.id.ip_layout_us_info_bdate);
        edt_usIDLayout = findViewById(R.id.ip_layout_us_info_id);
        edt_usPhoneLayout = findViewById(R.id.ip_layout_us_info_phone);
    }
}