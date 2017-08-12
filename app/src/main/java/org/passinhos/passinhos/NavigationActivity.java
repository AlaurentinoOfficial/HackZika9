package org.passinhos.passinhos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class NavigationActivity extends AppCompatActivity {

    Toolbar toolbar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_baby:
                    fragment = new BabyFragment();
                    toolbar.setTitle(R.string.title_baby);
                    break;
                case R.id.navigation_map:
                    fragment = new MapsFragment();
                    toolbar.setTitle(R.string.title_map);
                    //toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    break;
                case R.id.navigation_income:
                    fragment = new IncomeFragment();
                    toolbar.setTitle(R.string.title_income);
                    break;
                case R.id.navigation_account:
                    fragment = new AccountFragment();
                    toolbar.setTitle(R.string.title_account);
                    break;
            }

            pushFragment(fragment);
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(toolbar);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        pushFragment(new BabyFragment());
    }

    void pushFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.navigation_toolbar, fragment);
        fragmentTransaction.commit();
    }

}
