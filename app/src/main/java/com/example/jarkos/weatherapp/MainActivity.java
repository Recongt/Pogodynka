package com.example.jarkos.weatherapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements IFragmentContainer
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.containerFragment) != null) {

            if (savedInstanceState != null) {
                return;
            }

//            MenuFragment firstFragment = new MenuFragment();
//            firstFragment.setArguments(getIntent().getExtras());
//            getSupportFragmentManager().beginTransaction().add(R.id.containerFragment, firstFragment).commit();
            replaceFragment(new MenuFragment());
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

    @Override
    public void onBackPressed(){
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 1) {
            fragmentManager.popBackStack();
        } else {
            finish();
        }
    }

    public void onCitySelected(String cityName)
    {
        // The user selected the headline of an article from the HeadlinesFragment
        // Capture the article fragment from the activity layout

        WeatherViewFragment weatherFragment = (WeatherViewFragment) getFragmentManager().findFragmentById(R.id.containerWeather);

        if (weatherFragment != null) {
            // If article frag is available, we're in two-pane layout...
            // Call a method in the ArticleFragment to update its content
            weatherFragment.updateFragmentView(cityName);

        }
        else
        {
            // If the frag is not available, we're in the one-pane layout and must swap frags...
            WeatherViewFragment newWeatherFragment = new WeatherViewFragment();
            replaceFragment(newWeatherFragment);
            newWeatherFragment.updateFragmentView(cityName);
         }
    }
}