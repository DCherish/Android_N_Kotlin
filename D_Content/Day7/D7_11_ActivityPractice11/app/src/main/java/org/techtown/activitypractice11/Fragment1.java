package org.techtown.activitypractice11;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Fragment1 extends Fragment {

    ViewPager pager;
    int index;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        pager = rootView.findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);

        MyPagerAdapter adapter = new MyPagerAdapter(getFragmentManager());

        PageFragment1 pageFragment1 = new PageFragment1();
        adapter.addItem(pageFragment1);

        PageFragment2 pageFragment2 = new PageFragment2();
        adapter.addItem(pageFragment2);

        PageFragment3 pageFragment3 = new PageFragment3();
        adapter.addItem(pageFragment3);

        pager.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        MyPagerAdapter adapter = new MyPagerAdapter(getFragmentManager());

        PageFragment1 pageFragment1 = new PageFragment1();
        adapter.addItem(pageFragment1);

        PageFragment2 pageFragment2 = new PageFragment2();
        adapter.addItem(pageFragment2);

        PageFragment3 pageFragment3 = new PageFragment3();
        adapter.addItem(pageFragment3);

        pager.setAdapter(adapter);
    }

    class MyPagerAdapter extends FragmentStatePagerAdapter
    {
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public MyPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        public void addItem(Fragment item)
        {
            items.add(item);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return "페이지 " + (position + 1);
        }
    }
}