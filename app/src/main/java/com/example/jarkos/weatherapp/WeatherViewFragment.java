package com.example.jarkos.weatherapp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jarkos.weatherapp.dataModel.CurrentWeather;
import com.example.jarkos.weatherapp.dataModel.Main;
import com.example.jarkos.weatherapp.dataModel.Weather;
import com.google.gson.Gson;
import java.util.List;

public class WeatherViewFragment extends Fragment {

    private IFragmentContainer fragmentContainer;
    private Context _context;

    public WeatherViewFragment()
    {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        fragmentContainer = (IFragmentContainer) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_view, container, false);
        _context = view.getContext();
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


            if(haveNetworkConnection())
            {
                String respond =  jsonParser.doInBackground(url);
                Gson gson = new Gson();
                CurrentWeather currentWeather = gson.fromJson(respond, CurrentWeather.class);
                System.out.println(respond);
                //weatherLabel.setText(respond);
                String weatherString="";

                if (currentWeather != null)
                {
                    System.out.println("City : " + cityName);
                    weatherString += cityName;
                    List<Weather> weathers = currentWeather.weather;
                    Weather weather = weathers.get(0);
                    weatherString += "\n" + weather.getDescription();
                    System.out.println("Condition : " + weather.getDescription());

                    Main main = currentWeather.main;
                    System.out.println("Temperature : " + (int) (main.getTemp() - 273.15) + "°C");
                    weatherString += "\nTemperature : " + (int) (main.getTemp() - 273.15) + "°C";

                    System.out.println("Pressure : " +  main.getPressure()  + " hPa");
                    weatherString += "\nPressure : " +  main.getPressure()  + " hPa";

                    System.out.println("Humidity : " +  main.getHumidity()  + "%");
                    weatherString += "\nHumidity : " +  main.getHumidity() + "%";

                    weatherLabel.setText(weatherString);
                }
            }
            else
            {
                weatherLabel.setText("Connection problem.");
                Toast.makeText(_context, "Connection problem.", Toast.LENGTH_SHORT).show();
            }


        }
    }

    private boolean haveNetworkConnection()
    {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
}
