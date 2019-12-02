package com.example.android.soccerscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.SystemClock;
import android.widget.Chronometer;


public class MainActivity extends AppCompatActivity {
    /**
     * Declare global variable score for Teams A and B.
     */
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int shotsTeamA = 0;
    int yellowTeamA = 0;
    int redTeamA = 0;
    int shotsTeamB = 0;
    int yellowTeamB = 0;
    int redTeamB = 0;


    private Chronometer chronometer;
    private boolean isStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometerChanged) {
                chronometer = chronometerChanged;
            }
        });
    }

    public void startStopChronometer(View view){
        if(isStart){
            chronometer.stop();
            isStart = false;
        }else{
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            isStart = true;
        }
    }

    /**
     * Change half1
     */
    public void firstHalf (View view) {
        String half1 = "1st Half";
        displayHalf1(half1);
    }

    /**
     * Change half2
     */
    public void secondHalf (View view) {
        String half2 = "2nd Half";
        displayHalf2(half2);
    }

    /**
     * Increase the score for Team FC by 1 point.
     */
    public void incrementGoalsTeamFC (View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the shots for Team FC by 1.
     */
    public void incrementShotsTeamFC (View view) {
        shotsTeamA = shotsTeamA + 1;
        displayShotsForTeamA(shotsTeamA);
    }

    /**
     * Increase the yellow cards for Team FC by 1.
     */
    public void incrementYellowTeamFC (View view) {
        yellowTeamA = yellowTeamA + 1;
        displayYellowForTeamA(yellowTeamA);
    }

    /**
     * Increase the red cards for Team FC by 1.
     */
    public void incrementRedTeamFC (View view) {
        redTeamA = redTeamA + 1;
        displayRedForTeamA(redTeamA);
    }

    /**
     * Increase the score for opponent by 1 point.
     */
    public void incrementGoalsOpponent (View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the shots for opponent by 1.
     */
    public void incrementShotsOpponent (View view) {
        shotsTeamB = shotsTeamB + 1;
        displayShotsForTeamB(shotsTeamB);
    }

    /**
     * Increase the yellow cards for opponent by 1.
     */
    public void incrementYellowOpponent (View view) {
        yellowTeamB = yellowTeamB + 1;
        displayYellowForTeamB(yellowTeamB);
    }

    /**
     * Increase the red cards for opponent by 1.
     */
    public void incrementRedOpponent (View view) {
        redTeamB = redTeamB + 1;
        displayRedForTeamB(redTeamB);
    }

    /**
     * Display the given score for Team A.
     */
    public void displayForTeamA (int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Display shots for Team FC.
     */
    public void displayShotsForTeamA (int score) {
        TextView scoreView = (TextView) findViewById(R.id.fc_shots);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Display yellow cards for Team FC.
     */
    public void displayYellowForTeamA (int score) {
        TextView scoreView = (TextView) findViewById(R.id.fc_yellow_cards);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Display red cards for Team FC.
     */
    public void displayRedForTeamA (int score) {
        TextView scoreView = (TextView) findViewById(R.id.fc_red_cards);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Display the given score for Team B.
     */
    public void displayForTeamB (int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Display shots for opponent.
     */
    public void displayShotsForTeamB (int score) {
        TextView scoreView = (TextView) findViewById(R.id.opponent_shots);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Display yellow cards for opponent.
     */
    public void displayYellowForTeamB (int score) {
        TextView scoreView = (TextView) findViewById(R.id.opponent_yellow_cards);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Display red cards for opponent.
     */
    public void displayRedForTeamB (int score) {
        TextView scoreView = (TextView) findViewById(R.id.opponent_red_cards);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Display first half
     */
    public void displayHalf1 (String half) {
        TextView scoreView = (TextView) findViewById(R.id.half);
        scoreView.setText(String.valueOf(half));
    }

    /**
     * Display second half
     */
    public void displayHalf2 (String half) {
        TextView scoreView = (TextView) findViewById(R.id.half);
        scoreView.setText(String.valueOf(half));
    }

    /**
     * Reset score and all metrics to 0 for Teams A and B
     */
    public void resetScore (View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        shotsTeamA = 0;
        yellowTeamA = 0;
        redTeamA = 0;
        shotsTeamB = 0;
        yellowTeamB = 0;
        redTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayShotsForTeamA(shotsTeamA);
        displayYellowForTeamA(yellowTeamA);
        displayRedForTeamA(redTeamA);
        displayForTeamB(scoreTeamB);
        displayShotsForTeamB(shotsTeamB);
        displayYellowForTeamB(yellowTeamB);
        displayRedForTeamB(redTeamB);
    }
}