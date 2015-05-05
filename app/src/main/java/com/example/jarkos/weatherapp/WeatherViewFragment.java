package com.example.jarkos.weatherapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jarkos.weatherapp.dataModel.CurrentWeather;
import com.example.jarkos.weatherapp.dataModel.Main;
import com.example.jarkos.weatherapp.dataModel.Sys;
import com.example.jarkos.weatherapp.dataModel.Weather;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class WeatherViewFragment extends Fragment {

    private IFragmentContainer fragmentContainer;
    public static final Calendar c = Calendar.getInstance();
    public static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("HH:mm");

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
            Gson gson = new Gson();
            CurrentWeather currentWeather = gson.fromJson(respond, CurrentWeather.class);
            System.out.println("GŁOWNE: " + currentWeather.main.getHumidity());
            System.out.println(respond);
            //weatherLabel.setText(respond);
            String weatherString="";

            if (currentWeather != null)
            {
                System.out.println("City : " + cityName);
                List<Weather> weathers = currentWeather.weather;
                Weather weather = weathers.get(0);
                weatherString += "\n" + weather.getDescription();
                System.out.println("Condition : " + weather.getDescription());

                Main main = currentWeather.main;
                System.out.println("Temperature : " + (int) (main.getTemp() - 273.15) + "°C");
                weatherString += "\nTemperature : " + (int) (main.getTemp() - 273.15) + "°C";

                com.example.jarkos.weatherapp.dataModel.Sys sys = currentWeather.sys;
                c.setTimeInMillis(sys.getSunrise() * 1000);
                System.out.println("Sunrise : " + DATE_FORMATTER.format(c.getTime()));
                c.setTimeInMillis(sys.getSunset() * 1000);
                weatherString += "\nSunrise : " + DATE_FORMATTER.format(c.getTime());
                System.out.println("Sunset : " + DATE_FORMATTER.format(c.getTime()));
                weatherString += "\nSunset : " + DATE_FORMATTER.format(c.getTime());
                weatherLabel.setText(weatherString);
            }
        }

        System.out.print("Zaktualizowano!");
    }



}
