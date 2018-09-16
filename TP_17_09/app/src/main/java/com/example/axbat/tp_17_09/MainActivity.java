package com.example.axbat.tp_17_09;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Button likeButton;
    private Boolean likeClicked;
    private ImageButton cross;
    private Button backButton;
    private EditText editComment;
    private TextView textComment;
    private ImageButton textbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        this.textComment=findViewById(R.id.textcomments);
        this.textbtn=findViewById(R.id.btnsend);

        this.textComment.setOnClickListener(new View.OnClickListener() {
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



    }


}
