package com.example.rainlovepear;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeartActivity extends AppCompatActivity {

    private GridView mGridView;
    private HeartAdapter mHeartAdapter;
    private ImageView imageView,image;
    private LinearLayout linearLayout;
    private Dialog dialog;
    private int j=1,n=50;
    private List<Map> record;
    private List<Integer> heartList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart);
        imageView = (ImageView) findViewById(R.id.image_show);
        initView();
    }

    private void initView(){
        mGridView = (GridView) findViewById(R.id.Grid_view);
        heartList = new ArrayList<>();
                    heartList.add(R.drawable.background);//position = 0
                    heartList.add(R.drawable.p1);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.p2);        //position = 5
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.p3);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.p4);
                    heartList.add(R.drawable.background);//position = 10
                    heartList.add(R.drawable.p5);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.p13);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.background);//position = 15
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.p6);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.background);//position = 20
                    heartList.add(R.drawable.p7);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.background);//position = 25
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.p8);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.p9);
                    heartList.add(R.drawable.background);//position = 30
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.p10);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.background);//position = 35
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.p11);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.p12);
                    heartList.add(R.drawable.background);//position = 40
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.p14);       //position = 45
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.background);
                    heartList.add(R.drawable.background);
        mHeartAdapter = new HeartAdapter(this, heartList);
        mGridView.setAdapter(mHeartAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                LinearLayout linearLayout = (LinearLayout) mGridView.getAdapter().getView(i, view, null);
                ImageView imageView = (ImageView) linearLayout.getChildAt(0);
                if (i==n){
                    j++;
                }

                switch (j) {
                    case 1:
                        imageView.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        initDialog(i);
                        dialog.show();
                        break;
                    case 3:
                        imageView.setVisibility(View.INVISIBLE);
                        j=0;
                        break;
                          }
                    n=i;
            }
        });
    }

    private void initDialog(int n){
        dialog = new Dialog(HeartActivity.this,R.style.FullActivity);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setAttributes(attributes);

        image = getImageView(n);
        dialog.setContentView(image);

        //大图的点击事件（点击让他消失）
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    private ImageView getImageView(int m) {
        int src;
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        src = heartList.get(m);
        @SuppressLint("ResourceType") InputStream is = getResources().openRawResource(src);
        Drawable drawable = BitmapDrawable.createFromStream(is, null);
        imageView.setImageDrawable(drawable);
        return imageView;
    }
}
