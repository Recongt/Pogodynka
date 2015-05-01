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
import java.util.List;

public class MenuFragment extends Fragment {

    private IFragmentContainer fragmentContainer;
    private Fragment frag;
    private FragmentTransaction fragTransaction;

//    private ExpandableListAdapter listAdapter;
    private ParentLevelExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    private List<String> continentListDataHeader;
    private List<String> countryListDataHeader;
   // private HashMap<String, List<String>> hashContinentListDataChild;
    private HashMap<String, List<ArrayList<String>>> hashContinentListDataChild2;

    private HashMap<String, List<String>> PolskaListDataChild;
    private HashMap<String, List<String>> hashListDataChild2;

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
        expListView = (ExpandableListView) view.findViewById(R.id.expanadableListView);

        loadListData();

//        listAdapter = new ExpandableListAdapter(view.getContext(), continentListDataHeader, hashContinentListDataChild2, hashListDataChild2);
        listAdapter = new ParentLevelExpandableListAdapter(view.getContext());

        expListView.setAdapter(listAdapter);

        // Listview group clickListener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return false;
            }
        });

        return view;
    }

    private void loadListData() {
        continentListDataHeader = new ArrayList<String>();
        hashContinentListDataChild2 = new HashMap<String, List<ArrayList<String>>>();

        // Adding child data
        continentListDataHeader.add("DupaKonta");
//        continentListDataHeader.add("Afryka");
//        continentListDataHeader.add("Ameryka Płn.");
//        continentListDataHeader.add("Azja");
//        continentListDataHeader.add("Europa");

        // Adding child data
        List<ArrayList<String>> dupaKontynent = new ArrayList<ArrayList<String>>();
        //countryListDataHeader.add("Afryka");
        ArrayList<String> poland = new ArrayList<String>();
        poland.add("Warszaw");
        poland.add("Kraków");
        poland.add("Łódź");
        dupaKontynent.add(poland);

        ArrayList<String> germany = new ArrayList<String>();
        germany.add("Berlin");
        germany.add("Munchen");
        germany.add("Hamburg");
        dupaKontynent.add(germany);

        List<String> africa = new ArrayList<String>();
        //countryListDataHeader.add("Afryka");
        africa.add("C1");
        africa.add("C2");
        africa.add("C3");
        africa.add("C4");

        List<String> northAmerica = new ArrayList<String>();
        northAmerica.add("C1");
        northAmerica.add("C2");
        northAmerica.add("C3");
        northAmerica.add("C4");

        List<String> asia = new ArrayList<String>();
        asia.add("C1");
        asia.add("C4");
        asia.add("C2");
        asia.add("C3");

        List<String> europa = new ArrayList<String>();
        europa.add("C1");
        europa.add("C4");
        europa.add("C2");
        europa.add("C3");

        hashContinentListDataChild2.put(continentListDataHeader.get(0), dupaKontynent); // Header, Child data
//        hashContinentListDataChild.put(continentListDataHeader.get(1), africa);
//        hashContinentListDataChild.put(continentListDataHeader.get(2), northAmerica);
//        hashContinentListDataChild.put(continentListDataHeader.get(3), asia);
//        hashContinentListDataChild.put(continentListDataHeader.get(4), europa);
    }

}
