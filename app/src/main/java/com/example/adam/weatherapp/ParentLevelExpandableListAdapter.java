package com.example.adam.weatherapp;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.adam.weatherapp.modelDanych.Continent;

import java.util.ArrayList;

/**
 * Created by Adam on 2015-05-01.
 */
public class ParentLevelExpandableListAdapter extends BaseExpandableListAdapter
{
    private Context _context;
    private ArrayList<Continent> _continentsList;

    ParentLevelExpandableListAdapter(Context context, ArrayList<Continent> continentsList)
    {
        this._context = context;
        this._continentsList = continentsList;
    }

    @Override
    public Object getChild(int arg0, int arg1)
    {
        return arg1;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
    {
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        SecondLevelExpandableList SecondLevelExpandableList = new SecondLevelExpandableList(_context); //TO CHECK2
        SecondLevelExpandableList.setAdapter(new SecondLevelAdapter(_context,_continentsList.get(groupPosition).listOfCountries)); //wysyłąmy tylko jeden dany kontynent
        SecondLevelExpandableList.setGroupIndicator(null);
        return SecondLevelExpandableList;
    }

    @Override
    public int getChildrenCount(int groupPosition)
    {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition)
    {
        return groupPosition;
    }

    @Override
    public int getGroupCount()
    {
        return _continentsList.size();
    }

    @Override
    public long getGroupId(int groupPosition)
    {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent)
    {

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }
//        System.out.println("Pozycja isExpand: " +isExpanded);
        TextView continentsList = (TextView) convertView.findViewById(R.id.lblListHeader);
        continentsList.setText(_continentsList.get(groupPosition).getName());
        continentsList.setTypeface(null, Typeface.BOLD);
        continentsList.setPadding(10, 7, 7, 7);

        return convertView;
    }

    @Override
    public boolean hasStableIds()
    {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
