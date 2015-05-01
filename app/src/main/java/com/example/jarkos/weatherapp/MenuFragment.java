package com.example.jarkos.weatherapp;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MenuFragment extends Fragment {

    private IFragmentContainer fragmentContainer;
    private Fragment frag;
    private FragmentTransaction fragTransaction;

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

      // Button btnSimple = (Button) view.findViewById(R.id.btnSimple);

        /*btnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag = new SimpleCalculatorFragment();
                fragmentContainer.replaceFragment(frag);

//                fragTransaction = getFragmentManager().beginTransaction().replace(R.id.container, frag).addToBackStack("simple");
//                fragTransaction.commit();
            }
        });*/

        return view;
    }

}
