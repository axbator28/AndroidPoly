package com.example.axbat.tp_17_09.Activities;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.axbat.tp_17_09.Adapters.CommentAdapter;
import com.example.axbat.tp_17_09.R;
import com.example.axbat.tp_17_09.model.Commentaire;

import java.util.List;

public class MainActivity extends Activity {

    private Button likeButton;
    private Boolean likeClicked;
    private ImageButton cross;
    private Button backButton;
    private EditText editComment;
    private Button btnComment;
    private ImageButton textbtn;
    private Button catbtn;

    private RecyclerView mRecyclerView;
    private List<Commentaire> mComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TP1
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        this.likeButton=findViewById(R.id.likebtn);
        likeClicked=false;
        this.likeButton.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(!likeClicked){
                    likeButton.setBackgroundResource(R.drawable.btn_white);
                    likeButton.setTextColor(Color.YELLOW);
                    likeButton.setCompoundDrawableTintList(ColorStateList.valueOf(Color.YELLOW));
                    likeClicked=true;
                }else{
                    likeButton.setBackgroundResource(R.drawable.btn_yellow);
                    likeButton.setTextColor(Color.WHITE);
                    likeButton.setCompoundDrawableTintList(ColorStateList.valueOf(Color.WHITE));
                    likeClicked=false;
                }
            }
        });
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

        this.editComment=findViewById(R.id.edit_comment);
        this.btnComment=findViewById(R.id.combtn);
        this.textbtn=findViewById(R.id.btnsend);

        this.btnComment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                editComment.setEnabled(true);
                editComment.requestFocus();
            }
        });
        this.textbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if(!editComment.getText().toString().matches("")){
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setMessage(editComment.getText());
                    alert.show();
                }
            }
        });
        this.catbtn=findViewById(R.id.catbtn);

        this.catbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });

        //TP2
        this.mRecyclerView=findViewById(R.id.recycler_com);
        mComments.add(new Commentaire("pika1", R.drawable.tp_pika1, "Oulala, ce film il est pô bien"));
        mComments.add(new Commentaire("Panoramix", R.drawable.tp_pika2, "C'est une bonne situation, ça, scribe ?"));
        mComments.add(new Commentaire("Otis", R.drawable.tp_pika3, "Mais, vous savez, moi je ne crois pas qu'il y ait de bonne ou de mauvaise situation. " +
                "Moi, si je devais résumer ma vie aujourd'hui avec vous, je dirais que c'est d'abord des rencontres, Des gens qui m'ont tendu la main, peut-être à un moment où " +
                "je ne pouvais pas, où j'étais seul chez moi."));
        CommentAdapter cAdapter = new CommentAdapter();
        cAdapter.setmComments(mComments);
        this.mRecyclerView.setAdapter(new CommentAdapter());
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));



    }


}
