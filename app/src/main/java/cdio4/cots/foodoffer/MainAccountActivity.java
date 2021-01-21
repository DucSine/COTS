package cdio4.cots.foodoffer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import cdio4.cots.foodoffer.ViewModel.AccountViewModel;
import cdio4.cots.foodoffer.ui.account.ChangePasswordFragment.ChangePasswordFragment;
import cdio4.cots.foodoffer.ui.account.UserInfomationFragment.UserInfomationFragment;

public class MainAccountActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_account);
        intent = getIntent();
        int fragmentLoad = getIntent().getIntExtra(getResources().getString(R.string.fragmentID), getResources().getInteger(R.integer.USERINFORMATION_FRAGMENT));

        switch (fragmentLoad){
            case USERINFORMATION_FRAGMENT:
                replaceFragment(new UserInfomationFragment());
                break;
            case CHANGEPASSWORD_FRAGMENT:
                replaceFragment(new ChangePasswordFragment());
                break;
        }

        accountViewModel = ViewModelProviders.of(this).get(AccountViewModel.class);
        accountViewModel.getFullname().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                fullName = s;
            }
        });
        accountViewModel.getGender().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                gender= aBoolean;
            }
        });
        accountViewModel.getbDate().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                bDate = s;
            }
        });
        accountViewModel.getUsID().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                usID = s;
            }
        });
        accountViewModel.getPhone().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                phone= s;
            }
        });
        accountViewModel.getEmail().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                email = s;
            }
        });
        accountViewModel.getAdress().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                adress = s;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.confirm_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.toolbar_confirm && statusFlag()){
            Boolean statrusFunction =  intent.getBooleanExtra(getResources().getString(R.string.signIn_status),false);

            if(statrusFunction){
                String username = intent.getStringExtra(getResources().getString(R.string.signIn_userName));
                String password = intent.getStringExtra(getResources().getString(R.string.signIn_userName));
                //SignIn(username, password);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_account_layout, fragment);
        transaction.commit();
    }

    /*  private void removeFragment(Fragment fragment) {
      FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
      transaction.remove(fragment);
      transaction.commit();
  }*/

    private Boolean statusFlag(){
        if (fullName !=null && fullName != "" &&
                bDate !=null && bDate != "" &&
                usID !=null && usID != "" &&
                phone !=null && phone != "" &&
                email !=null && email != "" &&
                adress !=null && adress != "" )
            return true;
        else
            return false;
    }

    private Intent intent;
    private static final int  USERINFORMATION_FRAGMENT = 1;
    private static final int CHANGEPASSWORD_FRAGMENT = 3;
    private AccountViewModel accountViewModel;

    private Fragment us_infomation_fragment;
    private Fragment changePassword_fragment;

    private String fullName;
    private Boolean gender;
    private String bDate;
    private String usID;
    private String phone;
    private String email;
    private String adress;

}