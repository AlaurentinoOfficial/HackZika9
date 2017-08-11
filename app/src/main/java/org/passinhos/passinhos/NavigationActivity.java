package org.passinhos.passinhos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity {

    FragmentTransaction fragmentTransaction = null;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_baby:
                    fragment = new BabyFragment();
                    break;
                case R.id.navigation_map:
                    fragment = new BabyFragment();
                    break;
                case R.id.navigation_income:
                    fragment = new BabyFragment();
                    break;
                case R.id.navigation_account:
                    fragment = new BabyFragment();
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

        fragmentTransaction = getSupportFragmentManager().beginTransaction();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        pushFragment(new BabyFragment());
    }

    void pushFragment(Fragment fragment) {
        fragmentTransaction.replace(R.id.navigation_toolbar, fragment);
        fragmentTransaction.commit();
    }

}
