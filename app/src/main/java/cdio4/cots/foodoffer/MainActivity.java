package cdio4.cots.foodoffer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import cdio4.cots.foodoffer.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private NavigationView navigationView;
    private Intent intent;

    private static final int Home_Fragment = 1;
    private static final int Aboutus_Fragment = 2;
    private int curentFragment = Home_Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitLayout();
        replaceFragment(new HomeFragment());
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_userInfomation:
                        intent = new Intent(MainActivity.this, UserInfomationActivity.class);
                        break;
                    case R.id.nav_discountCode:
                        intent = new Intent(MainActivity.this, DiscountCodeActivity.class);
                        break;
                    case R.id.nav_userChangePass:
                        intent =new Intent(MainActivity.this, ChangePasswordActivity.class);
                        break;
                    case R.id.nav_aboutUs:
                        intent = new Intent(MainActivity.this, AboutUsActivity.class);
                        break;
                }
                startActivity(intent);
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.toolbar_search:
                AppBAr_Search();
                return true;
            case R.id.toolbar_avatar:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                //new LoginDialog(this).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void InitLayout(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
    }

    protected  void AppBAr_Search(){
        // post api
        //phân tích json
        //hiển thị
        // đề xuất: live data
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_layout, fragment);
        transaction.commit();
    }
}