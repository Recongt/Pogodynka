package com.example.adam.weatherapp.modelDanych;

import java.util.ArrayList;

/**
 * Created by Adam on 2015-05-02.
 */
public class Continent
{
    private String name;
    public ArrayList<Country> listOfCountries;

    public Continent(String name)
    {
        this.name = name;
        this.listOfCountries = new ArrayList<>();
    }

    public int getNmbOfCountries() {
        return listOfCountries.size();
    }

    public String getName() {
        return name;
    }
}
