package com.example.sup33.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Model aModel = new Model();
    private Boolean win = false;
    private int type;
    private ServerPlayer aServerPlayer;
    private  ImageView[] aImageView = new ImageView[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String message = intent.getStringExtra(StartActivity.EXTRA_MESSAGE);
        if (message.equals("one")){
            type =1;
            aServerPlayer = new ServerPlayer();
        }
        else{
            type =2;
        }
        for(int i=0;i<9;i++) {
            int id = getResources().getIdentifier("imageView" + i, "id", getPackageName());
            ImageView IV = (ImageView) findViewById(id);
            aImageView[i] = IV;
            IV.setImageResource(R.drawable.plain);
            IV.setOnClickListener(this);
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
        String pre_id = v.getResources().getResourceName(v.getId());
        String[] pre = pre_id.split("/");
        int id = Integer.parseInt(pre[1].replaceAll("[\\D]", ""));
        if (type == 2) {
            if (t % 2 == 0) {
                IV.setImageResource(R.drawable.cross);
                aModel.aTicTacToe.setBoard((int) id / 3, id % 3, 1);
            } else {
                IV.setImageResource(R.drawable.round);
                aModel.aTicTacToe.setBoard((int) id / 3, id % 3, 2);

            }
        }
        if(type == 1){
            IV.setImageResource(R.drawable.cross);
            aModel.aTicTacToe.setBoard((int) id / 3, id % 3, 1);
            PlayerMove aPlayerMove = new PlayerMove((int) id / 3, id % 3, 1);
            if ( (! aModel.isWin(new PlayerMove(0,0,1))) && aModel.aTicTacToe.isAnyThigFree()){
                aServerPlayer.lastMove(aPlayerMove);
                aPlayerMove = aServerPlayer.move();
                aModel.aTicTacToe.setBoard(aPlayerMove.getRow(),aPlayerMove.getColumn(),aPlayerMove.getId());
                int index = 3 * aPlayerMove.getRow() + aPlayerMove.getColumn();
                aImageView[index].setImageResource(R.drawable.round);
                aImageView[index].setClickable(false);
                aServerPlayer.lastMove(aPlayerMove);
            }
        }
        CharSequence text=null;
        if (aModel.isWin(new PlayerMove(0,0,1))){
            text = "Player with \"X\" won!";
            win = true;

        }
        if (aModel.isWin(new PlayerMove(0,0,2))){
             text = "Player with \"O\" won!";
            win = true;

        }
        if(aModel.isDraw()){
            text = "Match is draw !";
            win = true;
        }
        if(win){

            Context context = getApplicationContext();
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }


        aModel.aTicTacToe.incrementTern();
        IV.setClickable(false);

    }
}
