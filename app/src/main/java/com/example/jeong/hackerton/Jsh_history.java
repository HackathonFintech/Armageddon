package com.example.jeong.hackerton;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.edge.weather.armageddon.R;

/**
 * Created by Jeong on 2018-03-22.
 */

public class Jsh_history extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    int MAX_PAGE=3;
    Fragment cur_fragment=new Fragment();
    @Override
protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selector);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new adapter(getSupportFragmentManager()));

        tabLayout =(TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }
    private  class adapter extends FragmentPagerAdapter{
        private String fragments[] ={"종합","입금","출금"};
        public adapter(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int position){
            if (position<0 || MAX_PAGE<=position)
                return null;
            switch (position){
                case 0:
                    cur_fragment=new page_1();
                    break;
                case 1:
                    cur_fragment=new page_2();
                    break;
                case 2:
                    cur_fragment=new page_3();
                    break;
            }
            return cur_fragment;
        }
        @Override
        public int getCount() {
            return MAX_PAGE;
        }

        @Override
        public CharSequence getPageTitle(int position){
            return fragments[position];
        }
    }
}



