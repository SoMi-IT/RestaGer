/*package com.somi.restager.work.orders.dialog;


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


public class OrderAddDialog extends Dialog implements Button.OnClickListener {


    private Activity activity;
    private ImageView iv_image;
    private EditText et_name, et_measurements, et_materials, et_extraMaterials;
    private Spinner s_sizes;
    private Button b_confirm, b_dismiss;


    public OrderAddDialog(Activity _activity) {


        super(_activity);
        activity = _activity;

        ColorDrawable back = new ColorDrawable(Color.TRANSPARENT);
        InsetDrawable inset = new InsetDrawable(back, 20);

        this.getWindow().setBackgroundDrawable(inset);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dialog_sew_add);

        Window window = this.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);

        iv_image = findViewById(R.id.iv_dialog_sew_add);

        et_name = findViewById(R.id.et_dialog_sew_add_name);
        et_measurements = findViewById(R.id.et_dialog_sew_add_measurements);
        et_materials = findViewById(R.id.et_dialog_sew_add_material);
        et_extraMaterials = findViewById(R.id.et_dialog_sew_add_material_extra);

        s_sizes = findViewById(R.id.s_dialog_sew_add_size);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, R.layout.spinner_custom, Sew.SEW_SIZES);
        s_sizes.setAdapter(adapter);

        fb_image = findViewById(R.id.fb_sews_add);
        fb_image.setOnClickListener(this);
        b_confirm = findViewById(R.id.b_dialog_sew_add_confirm);
        b_confirm.setOnClickListener(this);
        b_dismiss = findViewById(R.id.b_dialog_sew_add_dismiss);
        b_dismiss.setOnClickListener(this);


    }//CheckPasswordDialog



    public void onClick(View view) {

        if(view == b_dismiss) {

            dismiss();

        }else if(view == b_confirm) {

            dismiss();

        } else if(view == fb_image) {

            Intent i = new Intent();
            i.setType("image/*");
            i.setAction(Intent.ACTION_GET_CONTENT);

            // pass the constant to compare it
            // with the returned requestCode
            activity.startActivityForResult(Intent.createChooser(i, "Select Picture"), 200);

        }

    }//onClick

}//InfoDialog*/