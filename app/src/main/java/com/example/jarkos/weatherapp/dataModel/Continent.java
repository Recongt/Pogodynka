package com.example.jarkos.weatherapp.dataModel;

import java.util.ArrayList;

/**
 * Created by Jarek on 2015-05-02.
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
