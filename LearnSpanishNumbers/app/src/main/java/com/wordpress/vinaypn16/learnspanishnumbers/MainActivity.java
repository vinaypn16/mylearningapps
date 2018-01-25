package com.wordpress.vinaypn16.learnspanishnumbers;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tapped(View view){

        int id = view.getId(); //unique ID of the button tapped.

        String nameID = view.getResources().getResourceEntryName(id); // Identifier of the button pressed to nameID

        int src = getResources().getIdentifier(nameID, "raw", "com.wordpress.vinaypn16.learnspanishnumbers");
        //that nameID identifier is used to point to the source of the audio using above line.


        MediaPlayer sound = MediaPlayer.create(this, src); //Playing the audio file.
        sound.start();

    }
}
