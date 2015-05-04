package com.example.jarkos.weatherapp;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

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

        _expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                Toast.makeText(view.getContext(),
                "Group Clicked " + _continentList.get(groupPosition).getName(),
                Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        _expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                System.out.print("Clicked!!");
                Toast.makeText(
                        view.getContext(),
                        _continentList.get(groupPosition).getName()
                                + " : "
                               , Toast.LENGTH_SHORT)
                        .show();
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
        chinaCities.add("Beijing");
        chinaCities.add("Hongkong");
        chinaCities.add("Shanghai");
        china.setListOfCities(chinaCities);
        asia.listOfCountries.add(china);

        Country japan = new Country("Japan");
        ArrayList<String> japanCities = new ArrayList<String>();
        japanCities.add("Tokio");
        japanCities.add("Nagoya");
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
        germanCities.add("Munchen");
        germanCities.add("Hamburg");
        germany.setListOfCities(germanCities);

        Country france = new Country("Francja");
        ArrayList<String> frenchCities = new ArrayList<String>();
        frenchCities.add("Paris");
        frenchCities.add("Lyon");
        frenchCities.add("Marseille");
        france.setListOfCities(frenchCities);

        Country poland = new Country("Poland");
        ArrayList<String> polishCities = new ArrayList<String>();
        polishCities.add("Warsaw");
        polishCities.add("Krakow");
        polishCities.add("Lodz");
        poland.setListOfCities(polishCities);

        europa.listOfCountries.add(germany);
        europa.listOfCountries.add(poland);
        europa.listOfCountries.add(france);
        _continentList.add(europa);

    }

}
