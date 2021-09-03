package com.somi.restager.work.topbar;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.somi.restager.R;
import com.somi.restager.work.tab.TabFragmentListener;


public class TopBarFragment extends Fragment implements ImageView.OnClickListener{



    private TabFragmentListener listener;

    private TextView tv_user;
    private ImageView iv_user;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_top_bar, container, false);

        tv_user = rootView.findViewById(R.id.tv_top_bar_user);

        iv_user = rootView.findViewById(R.id.iv_top_bar_user);
        iv_user.setOnClickListener(this);


        return rootView;

    }//onCreateView


    public void onClick(View v) {


    }//onClick


}//TopBarFragment
