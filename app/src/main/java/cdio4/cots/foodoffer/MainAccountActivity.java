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

import cdio4.cots.foodoffer.ui.account.ChangePasswordFragment.ChangePasswordFragment;
import cdio4.cots.foodoffer.ui.account.SiginFragment.SigninFragment;
import cdio4.cots.foodoffer.ui.account.UserInfomationFragment.UserInfomationFragment;

public class MainAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_account);
        intent = getIntent();
        int Fr = intent.getIntExtra(getResources().getString(R.string.fragmentID), getResources().getInteger(R.integer.USERINFORMATION_FRAGMENT));
        switch (Fr){
            case USERINFORMATION_FRAGMENT:
                replaceFragment(new UserInfomationFragment());
                break;
            case SIGNIN_FRAGMENT:
                replaceFragment(new SigninFragment());
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
        if (item.getItemId() == R.id.toolbar_confirm)
            Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_account_layout, fragment);
        transaction.commit();
    }
    private Intent intent;
    private static final int  USERINFORMATION_FRAGMENT = 1;
    private static final int SIGNIN_FRAGMENT = 2;
    private static final int CHANGEPASSWORD_FRAGMENT = 3;

    private Fragment us_infomation_fragment;
    private Fragment signIn_fragment;
    private Fragment changePassword_fragment;
}