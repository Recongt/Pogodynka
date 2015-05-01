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

    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> hashListDataChild;

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
      // Button btnSimple = (Button) view.findViewById(R.id.btnSimple);

        loadListData();

        listAdapter = new ExpandableListAdapter(view.getContext(), listDataHeader, hashListDataChild);

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
        listDataHeader = new ArrayList<String>();
        hashListDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Afryka");
        listDataHeader.add("Ameryka Płn.");
        listDataHeader.add("Azja");
        listDataHeader.add("Europa");

        // Adding child data
        List<String> africa = new ArrayList<String>();
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

        hashListDataChild.put(listDataHeader.get(0), africa); // Header, Child data
        hashListDataChild.put(listDataHeader.get(1), northAmerica);
        hashListDataChild.put(listDataHeader.get(2), asia);
        hashListDataChild.put(listDataHeader.get(3), europa);
    }

}
