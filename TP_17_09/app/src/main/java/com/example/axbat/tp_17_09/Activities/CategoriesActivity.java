package com.example.axbat.tp_17_09.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.axbat.tp_17_09.Adapters.CategoryAdapter;
import com.example.axbat.tp_17_09.R;
import com.example.axbat.tp_17_09.model.Category;


public class CategoriesActivity extends Activity {

    private RecyclerView mRecyclerView;
    private ImageButton cross;
    private Button backButton;
    private Category[] mCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        mCategories=Category.values();

        this.mRecyclerView=findViewById(R.id.list_Cat);
        this.mRecyclerView.setAdapter(new CategoryAdapter());
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.cross=findViewById(R.id.widget_Cross);
        this.cross.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                finish();
            }
        });
        this.backButton=findViewById(R.id.widget_Button);
        this.backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                finish();
            }
        });

    }
}
