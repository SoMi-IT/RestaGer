package com.somi.restager.work.orders.dialog;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.InsetDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.somi.restager.R;
import com.somi.restager.work.menu.data.Plate;
import com.somi.restager.work.orders.adapter.OrdersListAdapter;
import com.somi.restager.work.orders.adapter.PlatesListAdapter;
import com.somi.restager.work.orders.adapter.PlatesListAdapterListener;
import com.somi.restager.work.orders.data.Order;
import com.somi.restager.work.orders.manager.OrdersManager;
import com.somi.restager.work.tables.manager.TablesManager;

import java.util.ArrayList;


public class OrderEditDialog extends Dialog implements Button.OnClickListener, PlatesListAdapterListener {


    private Activity activity;
    private Spinner s_tables, s_status;
    private EditText et_notes;
    private Button b_confirm, b_dismiss;

    private ArrayList <String> tables = new ArrayList<>();
    private PlatesListAdapter platesListAdapter;
    private Order currentOrder;
    private ArrayList<Plate> newPlates;


    public OrderEditDialog(Activity _activity, Order _order) {


        super(_activity);
        activity = _activity;
        currentOrder = _order;

        ColorDrawable back = new ColorDrawable(Color.TRANSPARENT);
        InsetDrawable inset = new InsetDrawable(back, 20);

        this.getWindow().setBackgroundDrawable(inset);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dialog_order_edit);

        Window window = this.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);

        TextView tv_id = findViewById(R.id.tv_dialog_order_edit_id);
        tv_id.setText(currentOrder.getId()+"");


        for (int i = 0; i < TablesManager.getFakeData().size(); i++) tables.add(TablesManager.getFakeData().get(i).getRoom() + " - " + TablesManager.getFakeData().get(i).getNumber());

        s_tables = findViewById(R.id.s_dialog_order_edit_tables);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, R.layout.spinner_custom, tables);
        s_tables.setAdapter(adapter);

        s_status = findViewById(R.id.s_dialog_order_edit_status);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(activity, R.layout.spinner_custom, Order.ORDER_STATUS_STATUS);
        s_status.setAdapter(adapter2);

        et_notes = findViewById(R.id.et_dialog_order_edit_notes);
        et_notes.setText(currentOrder.getNotes());

        b_confirm = findViewById(R.id.b_dialog_order_edit_confirm);
        b_confirm.setOnClickListener(this);
        b_dismiss = findViewById(R.id.b_dialog_order_edit_dismiss);
        b_dismiss.setOnClickListener(this);

        RecyclerView rv_orders = findViewById(R.id.rv_dialog_order_edit_plates);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity);
        rv_orders.setLayoutManager(layoutManager);

        platesListAdapter = new PlatesListAdapter(activity, currentOrder.getOrderedPlates());
        platesListAdapter.setListener(this);
        rv_orders.setAdapter(platesListAdapter);

    }//CheckPasswordDialog



    public void onClick(View view) {

        if(view == b_dismiss) {

            dismiss();

        }else if(view == b_confirm) {

            currentOrder.setOrderedPlates(newPlates);
            dismiss();

        }

    }//onClick


    public void onItemDeleted(ArrayList<Plate> plates) {

        newPlates = plates;

    }//onItemDeleted

}//InfoDialog