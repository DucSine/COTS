package cdio4.cots.foodoffer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class UserInfomationActivity extends AppCompatActivity {
    //trang thông tin cá nhân
    // thuộc navgationview
    private ImageView imgv_avatar;
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
    private String fullName;
    private Boolean gender;
    private String bdate;
    private String id;
    private String phone;
    private String email;
    private String address;
    Pattern pattern = Pattern.compile("\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}");
    //Matcher matcher = pattern.matcher(text1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_infomation);
        //khởi tạo layout
        InitLayout();
        //bắt lỗi nhập dữ liệu, gán dẽ liệu
        edt_usFullname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // reglarvalidation exeptions viết ở đây
                //get valuedation exprresssion

                if (charSequence.length() ==0)
                    edt_usFullnameLayout.setError("Vui lòng nhập họ tên");
                else
                    edt_usFullnameLayout.setError(null);

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //gán dữ liệu
                fullName = edt_usFullname.getText().toString();
               /* if (fullName == null)
                    edt_usFullnameLayout.setError("Vui lòng nhập họ tên");
                else
                    edt_usFullnameLayout.setError(null);*/
            }
        });
        // bdate tạo DateTimePicker
        edt_usBdate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edt_usID.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edt_usPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edt_usEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edt_usAdress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        //viết sự kiện rbtGroup và gán dữ liệu cho biến gender, male = true; female = false
    }

    private void InitLayout(){
        imgv_avatar = findViewById(R.id.imgv_us_info_avatar);

        edt_usFullnameLayout = findViewById(R.id.ip_layout_us_info_fullname);
        edt_usFullname = findViewById(R.id.ip_edt_us_info_fullname);

        edt_usBdateLayout = findViewById(R.id.ip_layout_us_info_bdate);
        edt_usBdate = findViewById(R.id.ip_edt_us_info_bdate);

        edt_usIDLayout = findViewById(R.id.ip_layout_us_info_id);
        edt_usID = findViewById(R.id.ip_edt_us_info_id);

        edt_usPhoneLayout = findViewById(R.id.ip_layout_us_info_phone);
        edt_usPhone = findViewById(R.id.ip_edt_us_info_phone);

        edt_usEmailLayout = findViewById(R.id.ip_layout_us_info_email);
        edt_usEmail = findViewById(R.id.ip_edt_us_info_email);

        edt_usAdressLayout = findViewById(R.id.ip_layout_us_info_adress);
        edt_usAdress = findViewById(R.id.ip_edt_us_info_adress);

        rbtGroupGender = findViewById(R.id.rbt_group_us_info_gender);
        rbt_usMale = rbtGroupGender.findViewById(R.id.rbt_us_info_male);
        rbt_usFemale = rbtGroupGender.findViewById(R.id.rbt_us_info_female);
    }

   // protected
}