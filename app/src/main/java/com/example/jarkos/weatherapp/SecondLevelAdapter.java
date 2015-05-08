package com.example.jarkos.weatherapp;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

import com.example.jarkos.weatherapp.dataModel.Country;

import java.util.ArrayList;

/**
 * Created by Jarek on 2015-05-01.
 */
public class SecondLevelAdapter  extends BaseExpandableListAdapter
{
    private Context _context;
    private ArrayList<Country> _countryList;

    public SecondLevelAdapter(Context context, ArrayList<Country> continent)
    {
        this._context = context;
        this._countryList = continent;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition)
    {
        return childPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, final View convertView, ViewGroup parent)
    {
        Integer cityID = (Integer) getChild(groupPosition, childPosition);
        TextView tv = new TextView(_context);//TO CHECK!
//        System.out.println("Group: " + groupPosition + " child: " + cityID );
        final String cityName = _countryList.get(groupPosition).getListOfCities().get(cityID);
        tv.setText(cityName);

        tv.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(_context instanceof MainActivity){
                    ((MainActivity)_context).onCitySelected(cityName);
                }
                return false;
            }
        });

        tv.setPadding(35, 5, 5, 5);
        tv.setTypeface(null, Typeface.BOLD);
        tv.setLayoutParams(new ListView.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        return tv;
    }

    @Override
    public int getChildrenCount(int groupPosition)
    {
        return _countryList.get(groupPosition).getListOfCities().size();
    }

    @Override
    public Object getGroup(int groupPosition)
    {
        return groupPosition;
    }

    @Override
    public int getGroupCount()
    {
        //System.out.println(_countryList.size());
        return _countryList.size();
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
        Integer countryID = (Integer) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }
//        System.out.println("Pozycja isExpand: " +isExpanded);
        TextView continentsList = (TextView) convertView.findViewById(R.id.lblListItem);
        continentsList.setText(_countryList.get(countryID).getName());
        continentsList.setTypeface(null, Typeface.BOLD);
        continentsList.setPadding(25, 7, 400, 7);

        return continentsList;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return true;
    }

}
