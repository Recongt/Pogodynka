package com.example.jarkos.weatherapp;

import android.content.Context;
import android.view.View;
import android.widget.ExpandableListView;

/**
 * Created by Jarek on 2015-05-02.
 */
public class SecondLevelExpandableList extends ExpandableListView
{
        public SecondLevelExpandableList(Context context) {
            super(context);
        }

        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
        {
            widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(960, View.MeasureSpec.AT_MOST);
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(600, View.MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
}

