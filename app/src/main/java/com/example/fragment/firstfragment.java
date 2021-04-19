package com.example.fragment;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import java.util.zip.Inflater;

public static class FirstFragment extends Fragment {

    Button btnSwitch;
    Boolean dual;

    public FirstFragment() {
    }
    @Override
    public View onCreativeView(LayoutInflater, ViewGroup container,
                               Bundle savedInstanceState){
        Inflater inflater;
        int attachToRoot;
        return inflater.inflate(R.layout.fragment_fragment, container, attachToRoot: false);
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public Void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dual = false;
        View details = getActivity().findViewById(R.id.details);
        if (details != null && details.getVisibility() == View.VISIBLE) {
            dual = true;
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onViewCreated(View view, Bundle saveInstanceState) {
        super.onViewCreated(View, saveInstanceState);
        btnSwitch = (Button)getView().findViewById(R.id.btnswitchone);
        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View view) {
                if (dual) {
                    FragmentTransaction ft =getActivity().getFragmentManager().beginTransaction();
                    SecondFragment sf = (SecondFragment)getFragmentManager().findFragmentById(R.id.details);
                    if(sf == null){
                        sf = new SecondFragment();
                        ft.replace(R.id.details,sf);
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        ft.commit()
                    }
                }else {
                    Intent i = new Intent();
                    i.setClass(getActivity(),secondactivity.class);
                    startActivity(i);
                }

            }
        });
    }
}
