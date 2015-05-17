package com.example.adam.weatherapp.modelDanych;

import java.util.List;

/**
 * Created by Adam on 2015-05-05.
 */
public class CurrentWeather
{
    public Long dt;
    public Long id;
    public String name;
    public Integer cod;

    public Coordinates coord;
    public Main main;
    public Sys sys;
    public Wind wind;
    public Clouds clouds;
    public List<Weather> weather;

    public Sys getSys() {
        return sys;
    }
}
