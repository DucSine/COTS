package cdio4.cots.foodoffer.ui.account.UserInfomationFragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import cdio4.cots.foodoffer.R;

public class UserInfomationFragment extends Fragment {
    //bất sự kiện giống signin

    public static UserInfomationFragment newInstance() {
        return new UserInfomationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root =  inflater.inflate(R.layout.user_infomation_fragment, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        userInfomationViewModel = new ViewModelProvider(this).get(UserInfomationViewModel.class);
        // TODO: Use the ViewModel
    }
    private UserInfomationViewModel userInfomationViewModel;
    private View root;

    private ImageView imgv_avatar;
    private TextInputLayout edt_fullNameLayout;
    private TextInputLayout edt_bDateLayout;
    private TextInputLayout edt_userIDLayout;
    private TextInputLayout edt_phoneLayout;
    private TextInputLayout edt_emailLayout;
    private TextInputLayout edt_adressLayout;
    private TextInputEditText edt_fullName;
    private TextInputEditText edt_bDate;
    private TextInputEditText edt_userID;
    private TextInputEditText edt_phone;
    private TextInputEditText edt_email;
    private TextInputEditText edt_adress;
    private RadioGroup rbtGroupGender;
    private RadioButton rbt_male;
    private RadioButton rbt_female;

    private String fullName ="";
    private Boolean gender = true;
    private String bdate = "";
    private String id = "";
    private String phone = "";
    private String email = "";
    private String address = "";

    private TextWatcher edt_fullName_Event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private TextWatcher edt_bDate_Event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private TextWatcher edt_userID_Event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private TextWatcher edt_phone_Event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private TextWatcher edt_email_Event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private TextWatcher edt_adress_Event = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}