package com.example.sup33.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ImageView IV00 =  (ImageView)findViewById(R.id.imageView00);
        //IV00.setOnClickListener(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        //ImageView[] imageViews = new ImageView[9];
        for(int i=0;i<9;i++) {
            int id = getResources().getIdentifier("imageView" + i, "id", getPackageName());
            ImageView IV = (ImageView) findViewById(id);
            //ImageView IV = new ImageView(this);
            //IV.setId(i);
            IV.setImageResource(R.drawable.plain);
            IV.setOnClickListener(this);
            //IV.getLayoutParams().height=height/3;
            //IV.getLayoutParams().width=width/3;
        }
    }

    public void ImagePress(View aView){

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        ImageView IV =  (ImageView)findViewById(v.getId());
        //IV.setImageResource(R.drawable.plain);
        int t= new TicTacToe().getTern();
        if (t%2==0){
            IV.setImageResource(R.drawable.cross);
        }else{
            IV.setImageResource(R.drawable.round);
        }
        new TicTacToe().incrementTern();
        IV.setClickable(false);

    }
}
