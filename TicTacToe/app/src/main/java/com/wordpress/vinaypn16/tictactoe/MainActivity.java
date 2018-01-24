package com.wordpress.vinaypn16.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int playerState = 0;            // 0 for cross and 1 for circle. For giving turns to both the players alternatively.
    int gameState[] = {0,0,0,0,0,0,0,0,0}; /*just to make sure that once a place is pressed, another input from that
                                                position should not be taken - initial state*/

    public void tapped(View view){
        ImageView imgvar = (ImageView) view;    /*to get the image place on which user has tapped and is stored in the variable.
        (ImageView) is used to say that the view is an image.
        ImageView is a type and imgvar is a variable of type ImageView*/
        // Log.i("tag is: ","Image number tapped is "+ imgvar.getTag().toString());  //toString() to convert the type to string.
        /*Only needed for checking which button is pressed */

        int tappedImageTagNo = Integer.parseInt(imgvar.getTag().toString()); //toString() to convert the type to string.
        /* the tag number of the image position pressed is given to the variable 'tappedImageTagNo'. */

        /*tag numbers are assigned to each image positions. Once an image position is pressed the tag number of
           of the image is obtained via imgvar.getTag() function.*/

        if(gameState[tappedImageTagNo] == 0) {            /*if the state of tapped position is '0' ie., it's in initial state
                                                           the change takes place then only the input press is considered.
                                                           the tag number is used to check the state in the initial state array*/

            if (playerState == 0) {                                 //player1's turn.
                imgvar.setImageResource(R.drawable.cross);          //cross is displayed at that image place pressed.
                imgvar.animate().rotation(360).setDuration(1000);   //just some animation.
                playerState = 1;                                    //state is changed.
            } else {                                                //player2's turn.
                imgvar.setImageResource(R.drawable.circle);         //circle is displayed on that image place clicked.
                // imgvar.animate().rotation(360).setDuration(1000);  not required for circle
                playerState = 0;                                    //State is changed.
            }

            gameState[tappedImageTagNo] = 1;                    /*this means that this position is pressed once
                                                                     and so the value is changed in the array, which makes sure
                                                                     that this position isn't updated with any cross or circle
                                                                     again*/
        }
        else{
            Toast.makeText(getApplicationContext(),"Hey! E place already fill agidhyo gubalt!! " +
                            "Bere yav place kannsthilva ningey!? Bere kade kallchko!",
                    Toast.LENGTH_LONG).show();
        }   //else end
    }       //tapped end

    public void reset(View view) {
        for(int i=0;i<gameState.length;i++) {
            gameState[i] =0 ;               //1. Changing the game state to initial state using a for loop.
        }

        playerState = 0;                    //2. Changing the state of the player to initial.

        //3. Resetting the images back to ic_launcher
        LinearLayout imgReset1 =  findViewById(R.id.lineone);
        /*LinearLayout is the view type. imgReset1 is a variable of type LinearLayout.
          Here we are finding the first linear layout and assigning it to the variable imgReset1*/
        for(int i=0; i<imgReset1.getChildCount(); i++) {
        /* getChildCount is used to get the number of child views in the current linear layout which is represented by
          vatiable imgReset1*/
            ((ImageView) imgReset1.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        /* getChildAt is used to access a particular child view position in the current linear layout.
          ImageView here is used to say that, the child view that is being accessed is an image view
          At that accessed child image view the ic_launcher image is being set using the setImage function.
          So it's displayed as if the game has been reset to initial state
          The image resource can even be from drawable folder*/
        }

        LinearLayout imgReset2 =  findViewById(R.id.linetwo);
        for(int i=0; i<imgReset2.getChildCount(); i++) {
            ((ImageView) imgReset2.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }

        LinearLayout imgReset3 =  findViewById(R.id.linethree);
        for(int i=0; i<imgReset3.getChildCount(); i++) {
            ((ImageView) imgReset3.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }

    }  //reset end


}       //main activity end
