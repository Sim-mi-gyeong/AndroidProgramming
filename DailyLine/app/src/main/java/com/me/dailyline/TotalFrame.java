package com.me.dailyline;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class TotalFrame extends AppCompatActivity {

    FragmentManager fragmentManager;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_activity);

        // 프래그먼트 정의
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.bottom_container, fragment1).commit();   // 가장 처음 띄워줄 뷰 세팅

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.tab1:
                        Toast.makeText(getApplicationContext(), "Calendar Tab", Toast.LENGTH_SHORT);
                        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_container, fragment1).commit();

                    case R.id.tab2:
                        Toast.makeText(getApplicationContext(), "Memo chart Tab", Toast.LENGTH_SHORT);
                        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_container, fragment2).commit();

                    case R.id.tab3:
                        Toast.makeText(getApplicationContext(), "Memo chart Tab", Toast.LENGTH_SHORT);
                        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_container, fragment3).commit();

                        return true;
                }
                return false;
            }
        });

    }

    public void onTabSelected(int position) {
        if (position == 0) {
            bottomNavigation.setSelectedItemId(R.id.tab1);
        } else if (position == 1) {
            bottomNavigation.setSelectedItemId(R.id.tab2);
        } else if (position == 2) {
            bottomNavigation.setSelectedItemId(R.id.tab3);
        }
    }
}
