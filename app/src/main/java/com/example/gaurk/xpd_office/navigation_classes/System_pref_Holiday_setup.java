package com.example.gaurk.xpd_office.navigation_classes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gaurk.xpd_office.R;

/**
 * Created by gaurk on 12/24/2017.
 */

class System_pref_Holiday_setup extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sys_pref_holiday_setup,
                container, false);

        return rootView;

    }

}
