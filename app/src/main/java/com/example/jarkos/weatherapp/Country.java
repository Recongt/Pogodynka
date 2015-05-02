package com.example.jarkos.weatherapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jarek on 2015-05-02.
 */
public class Country
{
    public String getName() {
        return name;
    }

    private String name;
    private ArrayList<String> listOfCities;

    public Country(String name) {
        this.name = name;
        this.listOfCities = new ArrayList<String>();
    }
}
