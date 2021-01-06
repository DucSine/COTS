package cdio4.cots.foodoffer;

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

import com.google.android.material.navigation.NavigationView;

import cdio4.cots.foodoffer.dialog.LoginDialog;

public class MainActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_userinfo:
                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_discountcode:
                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_aboutus:
                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                        break;
                }

                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.toolbar_search:
                //tìm kiếm
                return true;
            case R.id.toolbar_avatar:
                new LoginDialog(this).show(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}