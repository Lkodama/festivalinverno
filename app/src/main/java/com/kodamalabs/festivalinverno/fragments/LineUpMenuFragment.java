package com.kodamalabs.festivalinverno.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kodamalabs.festivalinverno.R;
import com.kodamalabs.festivalinverno.adapters.SectionsPageAdapter;

public class LineUpMenuFragment extends Fragment{

  private SectionsPageAdapter mSectionsPageAdapter;

  private ViewPager mViewPager;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_main_lineup, container, false);

    mSectionsPageAdapter = new SectionsPageAdapter(getActivity().getSupportFragmentManager());

    mViewPager = (ViewPager) view.findViewById(R.id.container);
    setupViewPager(mViewPager);

    TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(mViewPager);


    return view;
  }

  private void setupViewPager(ViewPager viewPager) {
    SectionsPageAdapter adapter = new SectionsPageAdapter(getActivity().getSupportFragmentManager());
    LineUpFragment friday = new LineUpFragment();
    LineUpFragment saturday = new LineUpFragment();
    LineUpFragment sunday = new LineUpFragment();

    Bundle bundlef = new Bundle();
    bundlef.putString("texto", "Friday" );
    Bundle bundleS = new Bundle();
    bundleS.putString("texto", "Saturday" );
    Bundle bundleD = new Bundle();
    bundleD.putString("texto", "Sunday" );

    friday.setArguments(bundlef);
    saturday.setArguments(bundleS);
    sunday.setArguments(bundleD);

    adapter.addFragment(friday, "24/08");
    adapter.addFragment(saturday, "25/08");
    adapter.addFragment(sunday, "26/08");

    viewPager.setAdapter(adapter);
  }
}
