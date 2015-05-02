package com.example.jarkos.weatherapp;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuFragment extends Fragment {

    private IFragmentContainer fragmentContainer;
    private Fragment frag;
    private FragmentTransaction fragTransaction;

    private ParentLevelExpandableListAdapter listAdapter;
    private ExpandableListView _expListView;
    private ArrayList<Continent> _continentList;
    private ArrayList<ArrayList<String>> europaCountryList;
    private HashMap<Integer, ArrayList<String>> hashContinentListData;


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
        View view = inflater.inflate(R.layout.fragment_menu,container,false);
        _expListView = (ExpandableListView) view.findViewById(R.id.expanadableListView);

        loadListData();

        listAdapter = new ParentLevelExpandableListAdapter(view.getContext(), _continentList);

        _expListView.setAdapter(listAdapter);

        // Listview group clickListener
        _expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return false;
            }
        });

        return view;
    }

    private void loadListData()
    {

        Continent asia = new Continent("Asia");

        Country china = new Country("China");
        ArrayList<String> chinaCities = new ArrayList<String>();
        chinaCities.add("Pekin");
        chinaCities.add("Honkong");
        chinaCities.add("Szanghaj");
        china.setListOfCities(chinaCities);
        asia.listOfCountries.add(china);

        Country japan = new Country("Japan");
        ArrayList<String> japanCities = new ArrayList<String>();
        japanCities.add("Tokio");
        japanCities.add("Jokohama");
        japanCities.add("Osaka");
        japan.setListOfCities(japanCities);
        asia.listOfCountries.add(japan);

        // Adding child data
        _continentList = new ArrayList<>();
        _continentList.add(asia);

        Continent europa = new Continent("Europa");

        Country germany = new Country("Germany");
        ArrayList<String> germanCities = new ArrayList<String>();
        germanCities.add("Berlin");
        germanCities.add("Monachium");
        germanCities.add("Hamburg");
        germany.setListOfCities(germanCities);

        Country france = new Country("Francja");
        ArrayList<String> frenchCities = new ArrayList<String>();
        frenchCities.add("Paryż");
        frenchCities.add("Lyon");
        frenchCities.add("Marsylia");
        france.setListOfCities(frenchCities);

        Country poland = new Country("Poland");
        ArrayList<String> polishCities = new ArrayList<String>();
        polishCities.add("Warszawa");
        polishCities.add("Kraków");
        polishCities.add("Łódź");
        poland.setListOfCities(polishCities);

        europa.listOfCountries.add(germany);
        europa.listOfCountries.add(poland);
        europa.listOfCountries.add(france);
        _continentList.add(europa);

        ArrayList<String> northAmerica = new ArrayList<String>();

    }

}
