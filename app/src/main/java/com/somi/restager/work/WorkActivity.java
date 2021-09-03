package com.somi.restager.work;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.somi.restager.R;
import com.somi.restager.work.menu.MenuFragment;
import com.somi.restager.work.tab.TabFragment;
import com.somi.restager.work.tab.TabFragmentListener;
import com.somi.restager.work.orders.OrdersFragment;
import com.somi.restager.work.tables.TablesFragment;
import com.somi.restager.work.topbar.TopBarFragment;
import com.somi.restager.work.waiters.WaitersFragment;

import java.util.List;
import java.util.Vector;

public class WorkActivity extends AppCompatActivity implements TabFragmentListener, ViewPager.OnPageChangeListener {


    private FragmentManager mainFragmentManager;
    private WorkActivityListener menuListener;
    private List<Fragment> fragments = new Vector<Fragment>();
    private ViewPager vp_main;

    private TextView tv_user;
    private ImageView iv_user;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);


        vp_main = findViewById(R.id.vp_main_container);

        initMenuFragment(new TabFragment());
        initTopBar(new TopBarFragment());

        fragments.add(new OrdersFragment());
        fragments.add(new TablesFragment());
        fragments.add(new WaitersFragment());
        fragments.add(new MenuFragment());

        PagerAdapter pagerAdapter = new PagerAdapter(super.getSupportFragmentManager(), fragments);
        vp_main.setAdapter(pagerAdapter);
        vp_main.addOnPageChangeListener(this);

    }//onCreate

    public void initMenuFragment(TabFragment _fragment) {

        mainFragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = mainFragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fl_work_menu, _fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        fragmentTransaction.commit();
        _fragment.setListener(this);

    }//initMenuFragment


    public void initTopBar(TopBarFragment _fragment) {

        mainFragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = mainFragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fl_work_top_bar, _fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        fragmentTransaction.commit();

    }//initMenuFragment

    public void setMenuListener(WorkActivityListener _listener) {

        menuListener = _listener;

    }//setMenuListener

    //-------------------TabFragmentListener
    public void OnOrdersSelected() { vp_main.setCurrentItem(TabFragment.MENU_ORDERS); }

    public void OnTablesSelected() { vp_main.setCurrentItem(TabFragment.MENU_TABLES); }

    public void OnWaitersSelected() { vp_main.setCurrentItem(TabFragment.MENU_WAITERS); }

    public void OnMenuSelected() { vp_main.setCurrentItem(TabFragment.MENU_MENU); }



    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }//onPageScrolled


    public void onPageSelected(int position) {

        if (menuListener != null)menuListener.OnPageChanged(position);

    }//onPageScrolled


    public void onPageScrollStateChanged(int state) { }//onPageScrollStateChanged


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}//WorkActivity