package com.somi.restager.work.menu;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.somi.restager.R;
import com.somi.restager.work.WorkActivity;

public class MenuFragment extends Fragment {


    private WorkActivity activity;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        activity = (WorkActivity) getActivity();

        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        return rootView;

    }//onCreateView


}//OrdersFragment
