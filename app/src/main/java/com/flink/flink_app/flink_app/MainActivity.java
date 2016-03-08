package com.flink.flink_app.flink_app;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.flink.flink_app.flink_app.util.Sample;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewpage;
    private TextView saveToSpend;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        saveToSpend = (TextView) toolbar.findViewById(R.id.save_to_spend);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        viewpage = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewpage);

        tablayout = (TabLayout) findViewById(R.id.tabs);
        tablayout.setupWithViewPager(viewpage);
        setupTabIcons();
        TabLayout.Tab tab = tablayout.getTabAt(2);
        tab.select();



    }

    private void setupViewPager(ViewPager viewpage) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TransferFragment(), "Transefer");
        adapter.addFragment(new RootFragment(), "Save");
        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new CreditFragment(), "Credit");
        adapter.addFragment(new SpendFragment(), "Spend");
        viewpage.setAdapter(adapter);


    }

    private void setupTabIcons() {
        tablayout.getTabAt(0).setIcon(R.drawable.transfer_selector_icon);
        tablayout.getTabAt(1).setIcon(R.drawable.goal_selector_icon);
        tablayout.getTabAt(2).setIcon(R.drawable.home_selector_icon);
        tablayout.getTabAt(3).setIcon(R.drawable.credit_selector_icon);
        tablayout.getTabAt(4).setIcon(R.drawable.spend_selector_icon);






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_option_flink, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
