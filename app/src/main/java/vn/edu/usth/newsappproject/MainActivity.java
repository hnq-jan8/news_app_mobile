package vn.edu.usth.newsappproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem thome, ttechnology, tsports, tbusiness, tentertainment, thealth, tscience;
    PagerAdapter pagerAdapter;
    Toolbar ttoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ttoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(ttoolbar);
        thome = findViewById(R.id.home);
        ttechnology = findViewById(R.id.technology);
        tsports = findViewById(R.id.sports);
        tbusiness = findViewById(R.id.business);
        tentertainment = findViewById(R.id.entertainment);
        thealth = findViewById(R.id.health);
        tscience = findViewById(R.id.science);
        ViewPager viewPager = findViewById(R.id.fragment_container);
        tabLayout = findViewById(R.id.tabcontrol);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 7);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0 ||
                        tab.getPosition() == 1 ||
                            tab.getPosition() == 2 ||
                                tab.getPosition() == 3 ||
                                    tab.getPosition() == 4 ||
                                        tab.getPosition() == 5 ||
                                            tab.getPosition() == 6 )
                {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.exit:
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
        }
        return super.onOptionsItemSelected(item);
    }
}