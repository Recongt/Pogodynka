package com.example.jarkos.weatherapp.dataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jarek on 2015-05-02.
 */
public class Country
{
    private String name;

    public void setListOfCities(ArrayList<String> listOfCities) {
        this.listOfCities = listOfCities;
    }

    private ArrayList<String> listOfCities;

    public Country(String name) {
        this.name = name;
        this.listOfCities = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getListOfCities() {
        return listOfCities;
    }
}
