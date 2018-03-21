package com.edge.weather.armageddon;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TabHost;

public class LookupGroupActivity extends AppCompatActivity {

    private MainTabsAdapter mainTabsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookup_group);
        mainTabsAdapter = new MainTabsAdapter(LookupGroupActivity.this, (TabHost) findViewById(android.R.id.tabhost), (ViewPager) findViewById(R.id.pager));
        mainTabsAdapter.selectTab(MainTabsConfig.TABINDEX.FIRST);

    }

}
