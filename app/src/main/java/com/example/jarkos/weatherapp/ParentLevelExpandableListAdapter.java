package com.example.jarkos.weatherapp;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * Created by Jarek on 2015-05-01.
 */
public class ParentLevelExpandableListAdapter extends BaseExpandableListAdapter
{
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
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent)
    {
        //TO DO: add SubLevelList
        return View coś!!!!
    }

    @Override
    public int getChildrenCount(int groupPosition)
    {
        return 3;
    }

    @Override
    public Object getGroup(int groupPosition)
    {
        return groupPosition;
    }

    @Override
    public int getGroupCount()
    {
        return 4;
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
        TextView tv = new TextView(convertView.getContext()); // TO CHECK!!!
        tv.setText("->FirstLevel");
        tv.setBackgroundColor(Color.BLUE);
        tv.setPadding(10, 7, 7, 7);

        return tv;
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
