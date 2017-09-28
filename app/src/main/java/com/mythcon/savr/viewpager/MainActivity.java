package com.mythcon.savr.viewpager;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import layout.FragmentDua;
import layout.FragmentSatu;
import layout.FragmentTiga;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout wrapindicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        wrapindicator = (LinearLayout) findViewById(R.id.wrapIndicator);

        BoardingAdapter adapter = new BoardingAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        //indicator
        BoardingIndicator indicator = new BoardingIndicator(this,
                wrapindicator, viewPager, R.drawable.indicator_circle);
        indicator.setPageCount(3);
        indicator.show();

    }

    public static class FragmentHome extends Fragment{
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            TextView view = new TextView(getContext());
            view.setText("Home");
            return view;
        }
    }

    public static class FragmentYogyakarta extends Fragment{
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            TextView view = new TextView(getContext());
            view.setText("Yogyakarta");
            return view;
        }
    }

    public static class FragmentBali extends Fragment{
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            TextView view = new TextView(getContext());
            view.setText("Bali");
            return view;
        }
    }

    public class BoardingAdapter extends FragmentPagerAdapter{

        public BoardingAdapter(FragmentManager fm) {    //mengatur/memanajemen fragment
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

        Fragment fragment=null;

            if(position==0){
                fragment=new FragmentSatu();
            }else if(position==1){
                fragment=new FragmentDua();
            }if(position==2){
                fragment=new FragmentTiga();
            }
            Bundle b= new Bundle();
            b.putInt("position",position);
            return fragment;

        }

        @Override
        public int getCount() { //menghandle jumlah page
            return 3;
        }
    }
}
