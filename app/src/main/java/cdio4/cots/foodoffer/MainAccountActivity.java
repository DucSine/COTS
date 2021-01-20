package cdio4.cots.foodoffer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import cdio4.cots.foodoffer.ViewModel.AccountViewModel;
import cdio4.cots.foodoffer.model.Account;
import cdio4.cots.foodoffer.ui.account.ChangePasswordFragment.ChangePasswordFragment;
import cdio4.cots.foodoffer.ui.account.UserInfomationFragment.UserInfomationFragment;

public class MainAccountActivity extends AppCompatActivity {
Boolean ss = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_account);

        accountViewModel = ViewModelProviders.of(this).get(AccountViewModel.class);
        accountViewModel.getGender().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                ss = aBoolean;
            }
        });
       /* try {
            accountViewModel.getmAccount().observe(this, new Observer<Account>() {
                @Override
                public void onChanged(Account account) {
                    accountm = account;

                }
            });

        }
        catch (Exception ex){
            ex.fillInStackTrace();
        }
*/
        intent = getIntent();
        int Fr = intent.getIntExtra(getResources().getString(R.string.fragmentID), getResources().getInteger(R.integer.USERINFORMATION_FRAGMENT));

        switch (Fr){
            case USERINFORMATION_FRAGMENT:
                replaceFragment(new UserInfomationFragment());
                break;
            case CHANGEPASSWORD_FRAGMENT:
                replaceFragment(new ChangePasswordFragment());
                break;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.confirm_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.toolbar_confirm){
            Boolean statrusFunction =  intent.getBooleanExtra(getResources().getString(R.string.signIn_status),false);
            String n = intent.getStringExtra(getResources().getString(R.string.signIn_userName));
            if(statrusFunction)
                Toast.makeText(getApplicationContext(),n+ss ,Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_account_layout, fragment);
        transaction.commit();
    }

    private void removeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }

    private Intent intent;
    private static final int  USERINFORMATION_FRAGMENT = 1;
    private static final int CHANGEPASSWORD_FRAGMENT = 3;
    private AccountViewModel accountViewModel;
    private Account accountm;

    private Fragment us_infomation_fragment;
    private Fragment changePassword_fragment;

}