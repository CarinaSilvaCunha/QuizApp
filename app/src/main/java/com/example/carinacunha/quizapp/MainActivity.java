package com.example.carinacunha.quizapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity{
    //answers
    EditText answer01, answer02;
    // Total Score of the Quiz
    int totalScore;
    // Custom Toast message to be displayed after completing the quiz
    String finalScoreMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Binding Views with Variables
        answer01 = findViewById(R.id.answer01);
        answer02 = findViewById(R.id.answer02);
        // This creates a "ghost" view in order to clear focus of keyboard when we click anywhere in the layout
        View mainLayoutTouch = findViewById(R.id.ghostLayout);
        mainLayoutTouch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                clearFocusEditText(view.findFocus());
                return false;
            }
        });

        //this calls the first team name and clears the focus off the view when clicking somewhere else // hides keyboard
        EditText firstTeamName = findViewById(R.id.answer01);
        firstTeamName.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //Clear focus here from edittext
                    clearFocusEditText(v.findFocus());
                    return false;
                }
                return false;}
        });

        //this calls the first team name and clears the focus off the view when clicking somewhere else // hides keyboard
        EditText secondTeamName = findViewById(R.id.answer02);
        secondTeamName.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //Clear focus here from edittext
                    clearFocusEditText(v.findFocus());
                    return false;
                }
                return false;}
        });
    }


    // Method is called from onCreate - with an onTouchListener, if the ghostLayout is touched and the focus is on the team names, it clears the focus.
    public void clearFocusEditText(View view) {
        InputMethodManager mm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        mm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        answer01.clearFocus();
        answer02.clearFocus();
        }

    public void quizResultCount(View v) {
        RadioButton answer03 = findViewById(R.id.question03_option01);
        RadioButton answer04 = findViewById(R.id.question04_option02);
        RadioButton answer05 = findViewById(R.id.question05_option04);
        RadioButton answer06 = findViewById(R.id.question06_option02);
        CheckBox answer0701 = findViewById(R.id.question07_option01);
        CheckBox answer0702 = findViewById(R.id.question07_option02);
        RadioButton answer08 = findViewById(R.id.question08_option04);
        CheckBox answer0901 = findViewById(R.id.question09_option01);
        CheckBox answer0902 = findViewById(R.id.question09_option04);
        RadioButton answer10 = findViewById(R.id.question10_option02);

        totalScore = 0;
        // Question One - rihanna
        if (answer01.getText().toString().toLowerCase().equals("rihanna"))
            totalScore += 1;
        // Question two - justin timberlake
        if (answer02.getText().toString().toLowerCase().equals("justin timberlake"))
            totalScore += 1;
        //  Question three - option one
        if (answer03.isChecked())
            totalScore += 1;
        // Question four - option two
        if (answer04.isChecked())
            totalScore += 1;
        // Question five - option four
        if (answer05.isChecked())
            totalScore += 1;
        // Question six - option two
        if (answer06.isChecked())
            totalScore += 1;
        // Question seven - option two one option two
        if (answer0701.isChecked()&& answer0702.isChecked())
            totalScore += 1;
        // Question eight - option four
        if (answer08.isChecked())
            totalScore += 1;
        // Question nine - option one and option four
        if (answer0901.isChecked() && answer0902.isChecked())
            totalScore += 1;
        // Question ten - optiom  two
        if (answer10.isChecked())
            totalScore += 1;
        // call method with final score
        quizResult();

    }

    public void quizResult() {
        if (totalScore == 10)
            finalScoreMessage = getString(R.string.finalScoreMessage01);
        else if (totalScore < 10 && totalScore > 5)
            finalScoreMessage = getString(R.string.finalScoreMessage02) + " " + totalScore + "/10";
        else
            finalScoreMessage = getString(R.string.finalScoreMessage03) + " " + totalScore + "/10";
        Toast.makeText(this, finalScoreMessage, Toast.LENGTH_LONG).show();
    }
}
