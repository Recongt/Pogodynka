package com.example.jarkos.weatherapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class MainActivity extends ActionBarActivity implements IFragmentContainer
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.containerFragment) != null)
        {
            setContentView(R.layout.activity_main);
            MenuFragment firstFragment = new MenuFragment();
            firstFragment.setArguments(getIntent().getExtras());
//            getSupportFragmentManager().beginTransaction().add(R.id.containerFragment, firstFragment).commit();
            replaceFragment(firstFragment);
        }
//        if (findViewById(R.id.containerWeather) != null && findViewById(R.id.containerMenu)!=null)
        if (findViewById(R.id.containerWeather) != null)
        {
            setContentView(R.layout.activity_main_land);
            MenuFragment mf = new MenuFragment();
            replaceFragment3(mf);
            WeatherViewFragment wvf = new WeatherViewFragment();
            replaceFragment2(wvf);

        }
    }

    @Override
     public void replaceFragment(android.app.Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction frt = fragmentManager.beginTransaction();
        frt.replace(R.id.containerFragment, fragment, null);
        frt.addToBackStack(null);
        frt.commit();
    }

    public void replaceFragment2(android.app.Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction frt = fragmentManager.beginTransaction();
        frt.replace(R.id.containerWeather, fragment, null);
        frt.addToBackStack(null);
        frt.commit();
    }
//
    public void replaceFragment3 (android.app.Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction frt = fragmentManager.beginTransaction();
        frt.replace(R.id.containerMenu, fragment, null);
        frt.addToBackStack(null);
        frt.commit();
    }

    @Override
    public void onBackPressed()
    {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 1 && getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT )
        {
            fragmentManager.popBackStack();
        }
        else
        {
            finish();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
//        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getFragmentManager();
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            {
                fragmentManager = getFragmentManager();
                fragmentManager.popBackStack();
                fragmentManager.popBackStack();
                System.out.println("PORT\n");
                setContentView(R.layout.activity_main);

                MenuFragment firstFragment = new MenuFragment();
                firstFragment.setArguments(getIntent().getExtras());
                replaceFragment(firstFragment);
            }
            else
            {
                System.out.println("LAND\n");
                fragmentManager.popBackStack();
                setContentView(R.layout.activity_main_land);

                MenuFragment mf = new MenuFragment();
                replaceFragment3(mf);
                WeatherViewFragment wvf = new WeatherViewFragment();
                replaceFragment2(wvf);

            }
    }

    public void onCitySelected(final String cityName)
    {
        WeatherViewFragment weatherFragment = (WeatherViewFragment) getFragmentManager().findFragmentById(R.id.containerWeather);

        if (weatherFragment == null)
        {
            System.out.println("1!\n");
            // If the frag is not available, we're in the one-pane layout and we  must swap frags...
            WeatherViewFragment wvf = new WeatherViewFragment(cityName);
            replaceFragment(wvf);
        }
        else
        {
            System.out.println("2!\n");
            weatherFragment.updateFragmentView(cityName);
        }
    }

}