package com.example.adam.weatherapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.adam.weatherapp.modelDanych.Continent;
import com.example.adam.weatherapp.modelDanych.Country;

import java.util.ArrayList;

public class MenuFragment extends Fragment {

    private IFragmentContainer fragmentContainer;
    private Fragment frag;
    private FragmentTransaction fragTransaction;

    private ParentLevelExpandableListAdapter listAdapter;
    private ExpandableListView _expListView;
    private ArrayList<Continent> _continentList;
    private View view;

    public MenuFragment()
    {}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        fragmentContainer = (IFragmentContainer) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_menu,container,false);
        _expListView = (ExpandableListView) view.findViewById(R.id.expanadableListView);

        loadListData();

        listAdapter = new ParentLevelExpandableListAdapter(view.getContext(), _continentList);
        _expListView.setAdapter(listAdapter);




        return view;
    }

    private void loadListData()
    {
        _continentList = new ArrayList<>();

        Continent asia = new Continent("Azja");

        Country china = new Country("China");
        ArrayList<String> chinaCities = new ArrayList<String>();
        chinaCities.add("Beijing");
        chinaCities.add("Hongkong");
        chinaCities.add("Shanghai");
        china.setListOfCities(chinaCities);
        asia.listOfCountries.add(china);


        Country indie = new Country("Indie");
        ArrayList<String> indieCities = new ArrayList<String>();
        indieCities.add("Delhi");
        indieCities.add("Agra");
        indieCities.add("Amritsar");
        indie.setListOfCities(indieCities);
        asia.listOfCountries.add(indie);
        // Adding child data

        Country japan = new Country("Japonia");
        ArrayList<String> japanCities = new ArrayList<String>();
        japanCities.add("Tokio");
        japanCities.add("Nagoya");
        japanCities.add("Osaka");
        japan.setListOfCities(japanCities);
        asia.listOfCountries.add(japan);


        _continentList.add(asia);
/////////////////////////////////////////////////////
        Continent europa = new Continent("Europa");

        Country germany = new Country("Niemcy");
        ArrayList<String> germanCities = new ArrayList<String>();
        germanCities.add("Berlin");
        germanCities.add("Munchen");
        germanCities.add("Hamburg");
        germany.setListOfCities(germanCities);
        europa.listOfCountries.add(germany);

        Country france = new Country("France");
        ArrayList<String> frenchCities = new ArrayList<String>();
        frenchCities.add("Paris");
        frenchCities.add("Lyon");
        frenchCities.add("Marseille");
        france.setListOfCities(frenchCities);
        europa.listOfCountries.add(france);

        Country poland = new Country("Poland");
        ArrayList<String> polishCities = new ArrayList<String>();
        polishCities.add("Warsaw");
        polishCities.add("Krakow");
        polishCities.add("Lodz");
        poland.setListOfCities(polishCities);
        europa.listOfCountries.add(poland);

        _continentList.add(europa);


        Continent afryka = new Continent("Afryka");

        Country turkey = new Country("Turkey");
        ArrayList<String> turkeycites = new ArrayList<String>();
        turkeycites.add("Istanbul");
        turkeycites.add("Akara");
        turkeycites.add("Izmir");
        turkey.setListOfCities(turkeycites);
        afryka.listOfCountries.add(turkey);


        _continentList.add(afryka);


    }

}
