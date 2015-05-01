package com.example.jarkos.weatherapp;

import android.content.Context;
import android.widget.ExpandableListView;

/**
 * Created by Jarek on 2015-05-01.
 */
public class CustomExpandableListview extends ExpandableListView
{
    public CustomExpandableListview(Context context) {
        super(context);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(960, MeasureSpec.AT_MOST);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(600, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
