package com.example.gaurk.xpd_office.navigation_classes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gaurk.xpd_office.R;

/**
 * Created by gaurk on 12/21/2017.
 */

public class Proj_Approve_Leave extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.proj_leave_approve_xml,
                container, false);

        return rootView;

    }
}
