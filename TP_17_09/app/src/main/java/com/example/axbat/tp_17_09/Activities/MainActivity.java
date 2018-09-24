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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.axbat.tp_17_09.Adapters.CommentAdapter;
import com.example.axbat.tp_17_09.R;
import com.example.axbat.tp_17_09.model.Commentaire;

import java.util.ArrayList;
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
    private Button listbtn;

    private ImageView image;
    private TextView titre;
    private TextView desc;
    private TextView orititre;

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

        this.catbtn=findViewById(R.id.catbtn);

        this.catbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });

        this.listbtn=findViewById(R.id.listbtn);
        this.listbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListeActivity.class);
                startActivity(intent);
            }
        });

        //TP2
        this.mRecyclerView=findViewById(R.id.recycler_com);
        mComments = new ArrayList<Commentaire>();
        mComments.add(new Commentaire("pika1", R.drawable.tp_pika1, "Oulala, ce film il est pô bien"));
        mComments.add(new Commentaire("Panoramix", R.drawable.tp_pika2, "C'est une bonne situation, ça, scribe ?"));
        mComments.add(new Commentaire("Otis", R.drawable.tp_pika3, "Mais, vous savez, moi je ne crois pas qu'il y ait de bonne ou de mauvaise situation. " +
                "Moi, si je devais résumer ma vie aujourd'hui avec vous, je dirais que c'est d'abord des rencontres, Des gens qui m'ont tendu la main, peut-être à un moment où " +
                "je ne pouvais pas, où j'étais seul chez moi."));
        mComments.add(new Commentaire("Otis", R.drawable.tp_pika3, "J'en profite pour rajouter un commentaire de taille, lui aussi, plutôt imposante, pour tester la disparition" +
                "du double scroll, car tout de même, nous sommes champions du monde de football et nous ne pouvons, à ce titre, pas tolérer la présence d'un double scroll," +
                "NAN MAIS OH"));
        CommentAdapter cAdapter = new CommentAdapter();
        cAdapter.setmComments(mComments);
        this.mRecyclerView.setAdapter(cAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.textbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if(!editComment.getText().toString().matches("")){
                    Commentaire comi = new Commentaire("Toi le user", R.drawable.tp_pika1, editComment.getText().toString());
                    mComments.add(comi);
                    CommentAdapter adapt = (CommentAdapter) mRecyclerView.getAdapter();
                    adapt.notifyDataSetChanged();
                    editComment.setText("");
                    likeButton.requestFocus();
                }
            }
        });

        //TP3

        this.image=findViewById(R.id.movie_image);
        this.titre=findViewById(R.id.movie_title);
        this.desc=findViewById(R.id.movie_desc);
        this.orititre=findViewById(R.id.movie_orititle);

        if(getIntent()!=null && getIntent().getExtras()!=null){
            Bundle bundle = getIntent().getExtras();
            if(!bundle.getString("TITRE").equals(null)){
                this.titre.setText(bundle.getString("TITRE"));
                this.orititre.setText(bundle.getString("TITRE"));
            }
            if(!bundle.getString("DESC").equals(null)){
                this.desc.setText(bundle.getString("DESC"));
            }
            if(!bundle.get("IMAGE").equals(null)){
                this.image.setImageResource(bundle.getInt("IMAGE"));
            }
        }


    }


}
