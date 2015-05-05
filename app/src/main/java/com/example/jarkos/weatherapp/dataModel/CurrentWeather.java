package com.example.jarkos.weatherapp.dataModel;

/**
 * Created by Jarek on 2015-05-05.
 */
public class CurrentWeather
{
    public Long dt;
    public Long id;
    public String name;
    public Integer cod;

    public Coordinates coord;
    public Main main;
    public System sys;
    public Wind wind;
    public Clouds clouds;
    public Weather[] weather;

}
