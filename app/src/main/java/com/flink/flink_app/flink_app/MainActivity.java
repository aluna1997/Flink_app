package com.flink.flink_app.flink_app;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewpage;

    private int[] tabIcons = {  R.drawable.ic_home_white_24px,
                                R.drawable.ic_credit_card_white_24px,
                                R.drawable.ic_moneybox_white_24px};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        viewpage = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewpage);

        tablayout = (TabLayout) findViewById(R.id.tabs);
        tablayout.setupWithViewPager(viewpage);
        setupTabIcons();

    }

    private void setupViewPager(ViewPager viewpage) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new CreditFragment(), "Credit");
        adapter.addFragment(new SaveFragment(), "Saving");
        viewpage.setAdapter(adapter);


    }

    private void setupTabIcons() {
        tablayout.getTabAt(0).setIcon(tabIcons[0]);
        tablayout.getTabAt(1).setIcon(tabIcons[1]);
        tablayout.getTabAt(2).setIcon(tabIcons[2]);

    }


}
