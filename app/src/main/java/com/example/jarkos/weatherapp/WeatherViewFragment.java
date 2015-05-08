package com.example.jarkos.weatherapp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jarkos.weatherapp.dataModel.CurrentWeather;
import com.example.jarkos.weatherapp.dataModel.Main;
import com.example.jarkos.weatherapp.dataModel.Weather;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WeatherViewFragment extends Fragment {

//    private IFragmentContainer fragmentContainer;
    private Context _context;
    FragmentActivity listener;
    TextView weatherLabel;
    String _cityName=null;
    View _view;
    ImageView imgView;
    private Bundle savedInstanceState;

    public WeatherViewFragment(String cityname)
    {
        this._cityName = cityname;
    }
    public WeatherViewFragment()
    {
        this._cityName=null;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener = (FragmentActivity) activity;
//        fragmentContainer = (IFragmentContainer) activity;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        _view = inflater.inflate(R.layout.fragment_weather_view, container, false);
        _context = _view.getContext();
        weatherLabel = (TextView) _view.findViewById(R.id.labelWet);
        ImageView imgView = (ImageView)_view.findViewById(R.id.icon);
        weatherLabel.setText("Wait...");
//        weatherLabel.setText("Wybierz miasto " + _cityName);
        if(_cityName==null)
        {
            weatherLabel.setText("Select city...");
        }
        else
        {
            updateFragmentView(_cityName);
        }
        return _view;
    }

    public void updateFragmentView(String cityName)
    {
            weatherLabel = (TextView) _view.findViewById(R.id.labelWet);
            ImageView imgView = (ImageView)_view.findViewById(R.id.icon);
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
                CurrentWeather currentWeather = null;
                try {
                    currentWeather = gson.fromJson(respond, CurrentWeather.class);
                }
                catch(java.lang.IllegalStateException ise)
                {
                    System.out.print("Błąd parsowania JSONA12");
                }
                catch(com.google.gson.JsonSyntaxException ise)
                {
                    System.out.print("Błąd parsowania JSONA\n");
                    weatherLabel.setText("Błąd parsowania JSONA. Spróbuj jeszcze raz!");
                    System.out.print(respond+"\n");
                }

                if (currentWeather != null)
                {
                    System.out.println(respond);
                    //weatherLabel.setText(respond);
                    String weatherString="";

                    List<Weather> weathers = currentWeather.weather;
                    Weather weather = weathers.get(0);
                    Picasso.with(_context).load("http://openweathermap.org/img/w/"+weather.getIcon()+".png").into(imgView);
                    System.out.println("City : " + cityName);
                    weatherString += cityName;

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