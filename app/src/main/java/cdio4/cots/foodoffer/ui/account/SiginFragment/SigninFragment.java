package cdio4.cots.foodoffer.ui.account.SiginFragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import cdio4.cots.foodoffer.R;
import cdio4.cots.foodoffer.ViewModel.AccountViewModel;
import cdio4.cots.foodoffer.tools.RegularExpression;

public class SigninFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.signin_fragment, container, false);
        InitFragment();

        edt_userName.addTextChangedListener(edt_userName_Event);
        edt_password.addTextChangedListener(edt_password_Event);
        edt_passwordConfirm.addTextChangedListener(edt_passswordConfirm_Event);

       // btn_next.setEnabled(false);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accountViewModel.setSignIn_userName(userName);
               // accountViewModel.setSignIn_password(password);
                
                //removeFragment(newInstance());
               //remove k hoạt động

            }
        });
        return root;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        signinViewModel = new ViewModelProvider(this).get(SigninViewModel.class);
        // TODO: Use the ViewModel
    };

    private void InitFragment(){
        edt_userNameLayout = root.findViewById(R.id.ip_layout_activity_singin_username);
        edt_passwordLayout = root.findViewById(R.id.ip_layout_activity_signin_password);
        edt_passwordConfirmLayout = root.findViewById(R.id.ip_layout_activity_signin_password_confirm);
        edt_userName = root.findViewById(R.id.ip_edt_activity_signin_username);
        edt_password = root.findViewById(R.id.ip_edt_activity_signin_password);
        edt_passwordConfirm = root.findViewById(R.id.ip_edt_activity_signin_password_confirm);
        btn_next = root.findViewById(R.id.btn_next);

       // accountViewModel = ViewModelProviders.of(getActivity()).get(AccountViewModel.class);
    }

    private void removeFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }

    private SigninViewModel signinViewModel;
    private AccountViewModel accountViewModel;
    private View root;
    private Context context;
    private RegularExpression regularExpression = new RegularExpression();

    private TextInputLayout edt_userNameLayout;
    private TextInputLayout edt_passwordLayout;
    private TextInputLayout edt_passwordConfirmLayout;
    private TextInputEditText edt_userName;
    private TextInputEditText edt_password;
    private TextInputEditText edt_passwordConfirm;
    private Button btn_next;

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
            passwordConfirm = edt_passwordConfirm.getText().toString();
        }
    };

    public static SigninFragment newInstance() {
        return new SigninFragment();
    }
}