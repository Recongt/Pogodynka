package com.example.adam.weatherapp;

import android.content.Context;
import android.widget.ExpandableListView;

/**
 * Created by Adam on 2015-05-02.
 */
public class SecondLevelExpandableList extends ExpandableListView
{
        public SecondLevelExpandableList(Context context) {
            super(context);
        }

        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
        {
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(960, MeasureSpec.AT_MOST);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(600, MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
}

