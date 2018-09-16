package com.example.axbat.tp_17_09;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HeaderView extends LinearLayout {

    private TextView widgetMain;
    private Button widgetBack;

    public HeaderView(Context context) {
        super(context);
        this.initialize(context, null);

    }

    public HeaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.initialize(context, attrs);
    }

    public HeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initialize(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.initialize(context, attrs);
    }

    private void initialize(Context context, AttributeSet attrs){
        inflate(context, R.layout.widget_header_view, this);

        this.widgetMain=findViewById(R.id.widget_Title);
        this.widgetBack=findViewById(R.id.widget_Button);

        if(attrs !=null){
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.HeaderView,0,0);

            String mainTitle = array.getString(R.styleable.HeaderView_mainTitle);
            if(this.widgetMain!=null){
                widgetMain.setText(mainTitle);
            }

            String buttonText = array.getString(R.styleable.HeaderView_backTitle);
            if(this.widgetBack!=null){
                widgetBack.setText(buttonText);
            }

            array.recycle();
        }

    }


}
