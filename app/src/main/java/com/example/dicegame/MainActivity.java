package com.example.dicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView computerDice, playerDice;
    private Button buttonLower, buttonHigher;
    private TextView gameResult;
    Random random = new Random();
    private int computerRoll, playerRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        computerDice = findViewById(R.id.computer_dice);
        playerDice = findViewById(R.id.player_dice);

        buttonLower = findViewById(R.id.button_lower);
        buttonHigher = findViewById(R.id.button_higher);

        gameResult = findViewById(R.id.game_result);

        buttonLower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateRandom();
                if(computerRoll < playerRoll){
                    gameResult.setText("Computer Win!");
                }
                else if(computerRoll > playerRoll){
                    gameResult.setText("Player Win!");
                }
                else {
                    gameResult.setText("It's a Tie");
                }
            }
        });

        buttonHigher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateRandom();
                if(computerRoll > playerRoll){
                    gameResult.setText("Computer Win!");
                }
                else if(computerRoll < playerRoll){
                    gameResult.setText("Player Win!");
                }
                else {
                    gameResult.setText("It's a Tie");
                }
            }
        });

    }

    private void generateRandom() {
        computerRoll = random.nextInt(6) + 1;
        playerRoll = random.nextInt(6) + 1;
        rollDice(computerRoll, playerRoll);
    }

    private void rollDice(int cpuRandom, int playerRandom) {
        char dice1 = (char) (cpuRandom + '0');
        char dice2 = (char) (playerRandom + '0');
        switch(dice1){
            case '1' :
                computerDice.setImageResource(R.drawable.dice1);
                break;
            case '2' :
                computerDice.setImageResource(R.drawable.dice2);
                break;
            case '3' :
                computerDice.setImageResource(R.drawable.dice3);
                break;
            case '4' :
                computerDice.setImageResource(R.drawable.dice4);
                break;
            case '5' :
                computerDice.setImageResource(R.drawable.dice5);
                break;
            case '6' :
                computerDice.setImageResource(R.drawable.dice6);
                break;
            default:
        }
        switch(dice2){
            case '1' :
                playerDice.setImageResource(R.drawable.dice1);
                break;
            case '2' :
                playerDice.setImageResource(R.drawable.dice2);
                break;
            case '3' :
                playerDice.setImageResource(R.drawable.dice3);
                break;
            case '4' :
                playerDice.setImageResource(R.drawable.dice4);
                break;
            case '5' :
                playerDice.setImageResource(R.drawable.dice5);
                break;
            case '6' :
                playerDice.setImageResource(R.drawable.dice6);
                break;
            default:
        }
    }
}