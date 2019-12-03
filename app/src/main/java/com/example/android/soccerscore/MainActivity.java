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
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    private int shotsTeamA = 0;
    private int yellowTeamA = 0;
    private int redTeamA = 0;
    private int shotsTeamB = 0;
    private int yellowTeamB = 0;
    private int redTeamB = 0;

    private Chronometer mChronometer;
    private boolean isStart;
    private TextView mScoreTeamATextView;
    private TextView mScoreTeamBTextView;
    private TextView mShotsTeamATextView;
    private TextView mShotsTeamBTextView;
    private TextView mYellowCardsTeamATextView;
    private TextView mYellowCardsTeamBTextView;
    private TextView mRedCardsTeamATextView;
    private TextView mRedCardsTeamBTextView;
    private TextView mHalfTextView;

    private static final String SCORE_TEAM_A = "score-team-a";
    private static final String SCORE_TEAM_B = "score-team-b";
    private static final String SHOTS_TEAM_A = "shots-team-a";
    private static final String SHOTS_TEAM_B = "shots-team-b";
    private static final String YELLOW_CARDS_TEAM_A = "yellow-cards-team-a";
    private static final String YELLOW_CARDS_TEAM_B = "yellow-cards-team-b";
    private static final String RED_CARDS_TEAM_A = "red-cards-team-a";
    private static final String RED_CARDS_TEAM_B = "red-cards-team-b";
    private static final String HALF_TEXT = "half-text";
    private static final String CHRONO_TIME = "chronotime";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChronometer = (Chronometer) findViewById(R.id.chronometer);
        mScoreTeamATextView = (TextView) findViewById(R.id.team_a_score);
        mScoreTeamBTextView = (TextView) findViewById(R.id.team_b_score);
        mShotsTeamATextView = (TextView) findViewById(R.id.fc_shots);
        mShotsTeamBTextView = (TextView) findViewById(R.id.opponent_shots);
        mYellowCardsTeamATextView = (TextView) findViewById(R.id.fc_yellow_cards);
        mYellowCardsTeamBTextView = (TextView) findViewById(R.id.opponent_yellow_cards);
        mRedCardsTeamATextView = (TextView) findViewById(R.id.fc_red_cards);
        mRedCardsTeamBTextView = (TextView) findViewById(R.id.opponent_red_cards);
        mHalfTextView = (TextView) findViewById(R.id.half);

        mChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometerChanged) {
                mChronometer = chronometerChanged;
            }
        });

        //Persist values in display on device rotation
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(SCORE_TEAM_A)) {
                mScoreTeamATextView.setText(savedInstanceState.getString(SCORE_TEAM_A));
            }
            if (savedInstanceState.containsKey(SCORE_TEAM_B)) {
                mScoreTeamBTextView.setText(savedInstanceState.getString(SCORE_TEAM_B));
            }
            if (savedInstanceState.containsKey(SHOTS_TEAM_A)) {
                mShotsTeamATextView.setText(savedInstanceState.getString(SHOTS_TEAM_A));
            }
            if (savedInstanceState.containsKey(SHOTS_TEAM_B)) {
                mShotsTeamBTextView.setText(savedInstanceState.getString(SHOTS_TEAM_B));
            }
            if (savedInstanceState.containsKey(YELLOW_CARDS_TEAM_A)) {
                mYellowCardsTeamATextView.setText(savedInstanceState.getString(YELLOW_CARDS_TEAM_A));
            }
            if (savedInstanceState.containsKey(YELLOW_CARDS_TEAM_B)) {
                mYellowCardsTeamBTextView.setText(savedInstanceState.getString(YELLOW_CARDS_TEAM_B));
            }
            if (savedInstanceState.containsKey(RED_CARDS_TEAM_A)) {
                mYellowCardsTeamATextView.setText(savedInstanceState.getString(RED_CARDS_TEAM_A));
            }
            if (savedInstanceState.containsKey(RED_CARDS_TEAM_B)) {
                mYellowCardsTeamBTextView.setText(savedInstanceState.getString(RED_CARDS_TEAM_B));
            }
            if (savedInstanceState.containsKey(HALF_TEXT)) {
                mHalfTextView.setText(savedInstanceState.getString(HALF_TEXT));
            }
            if (savedInstanceState.containsKey(CHRONO_TIME)) {
                mChronometer.setBase(savedInstanceState.getLong(CHRONO_TIME));
                mChronometer.start();
            }
        }
    }

    public void startStopChronometer(View view){
        if(isStart){
            mChronometer.stop();
            isStart = false;
        }else{
            mChronometer.setBase(SystemClock.elapsedRealtime());
            mChronometer.start();
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
        mScoreTeamATextView.setText(String.valueOf(score));
    }

    /**
     * Display shots for Team FC.
     */
    public void displayShotsForTeamA (int score) {
        mShotsTeamATextView.setText(String.valueOf(score));
    }

    /**
     * Display yellow cards for Team FC.
     */
    public void displayYellowForTeamA (int score) {
        mYellowCardsTeamATextView.setText(String.valueOf(score));
    }

    /**
     * Display red cards for Team FC.
     */
    public void displayRedForTeamA (int score) {
        mRedCardsTeamATextView.setText(String.valueOf(score));
    }

    /**
     * Display the given score for Team B.
     */
    public void displayForTeamB (int score) {
        mScoreTeamBTextView.setText(String.valueOf(score));
    }

    /**
     * Display shots for opponent.
     */
    public void displayShotsForTeamB (int score) {
        mShotsTeamBTextView.setText(String.valueOf(score));
    }

    /**
     * Display yellow cards for opponent.
     */
    public void displayYellowForTeamB (int score) {
        mYellowCardsTeamBTextView.setText(String.valueOf(score));
    }

    /**
     * Display red cards for opponent.
     */
    public void displayRedForTeamB (int score) {
        mRedCardsTeamBTextView.setText(String.valueOf(score));
    }

    /**
     * Display first half
     */
    public void displayHalf1 (String half) {
        mHalfTextView.setText(String.valueOf(half));
    }

    /**
     * Display second half
     */
    public void displayHalf2 (String half) {
        mHalfTextView.setText(String.valueOf(half));
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SCORE_TEAM_A, mScoreTeamATextView.getText().toString());
        outState.putString(SCORE_TEAM_B, mScoreTeamBTextView.getText().toString());
        outState.putString(SHOTS_TEAM_A, mShotsTeamATextView.getText().toString());
        outState.putString(SHOTS_TEAM_B, mShotsTeamBTextView.getText().toString());
        outState.putString(YELLOW_CARDS_TEAM_A, mYellowCardsTeamATextView.getText().toString());
        outState.putString(YELLOW_CARDS_TEAM_B, mYellowCardsTeamBTextView.getText().toString());
        outState.putString(RED_CARDS_TEAM_A, mYellowCardsTeamATextView.getText().toString());
        outState.putString(RED_CARDS_TEAM_B, mYellowCardsTeamBTextView.getText().toString());
        outState.putString(HALF_TEXT, mHalfTextView.getText().toString());
        outState.putLong(CHRONO_TIME, mChronometer.getBase());
    }
}