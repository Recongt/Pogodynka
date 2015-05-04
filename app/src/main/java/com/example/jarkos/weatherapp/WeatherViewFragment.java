package com.example.jarkos.weatherapp;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class WeatherViewFragment extends Fragment {

    private IFragmentContainer fragmentContainer;

    public WeatherViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        fragmentContainer = (IFragmentContainer) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_view, container, false);

        return view;
    }

    public void updateFragmentView(String cityName)
    {
         //Ogar frgm create
//        TextView article = (TextView) getActivity().findViewById(R.id.article);
        if(WeatherViewFragment.this.isVisible())
        {
            TextView wetherLabel = (TextView) getActivity().findViewById(R.id.labelWet);
            wetherLabel.setText(cityName);
        }

        System.out.print("Zaktualizowano!");
    }

}
