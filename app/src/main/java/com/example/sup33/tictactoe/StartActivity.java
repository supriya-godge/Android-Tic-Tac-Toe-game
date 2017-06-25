package com.example.sup33.tictactoe;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class StartActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        /*MediaPlayer mMediaPlayer = new MediaPlayer();
        mMediaPlayer = MediaPlayer.create(this,R.raw.tune2 );
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();*/

        Button two = (Button)this.findViewById(R.id.button3);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.tune2);
        two.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {

                // If the music is playing
                if(mp2.isPlaying())
                    // Pause the music player
                    mp2.pause();
                    // If it's not playing
                else
                    // Resume the music player
                    mp2.start();
            }
        });
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        Button IV =  (Button) findViewById(v.getId());
        //IV.setImageResource(R.drawable.plain);
        int t= new TicTacToe().getTern();
        String pre_id = v.getResources().getResourceName(v.getId());
        String[] pre = pre_id.split("/");
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_MESSAGE, pre[1]);
        startActivity(intent);
    }
}
