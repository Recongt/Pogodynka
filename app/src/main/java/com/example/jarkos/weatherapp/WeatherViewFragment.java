package com.example.jarkos.weatherapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

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

        if(WeatherViewFragment.this.isVisible())
        {
            TextView weatherLabel = (TextView) getActivity().findViewById(R.id.labelWet);
            weatherLabel.setText(cityName);

            String url = "http://api.openweathermap.org/data/2.5/weather?q="+cityName;

            JSONParser jsonParser = new JSONParser();
            if (android.os.Build.VERSION.SDK_INT > 9)
            {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            String respond =  jsonParser.doInBackground(url);
            System.out.println(respond);
            weatherLabel.setText(respond);
        }

        System.out.print("Zaktualizowano!");
    }



}
