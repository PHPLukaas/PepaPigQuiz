package com.phplukaas.pepapigquiz.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.phplukaas.pepapigquiz.R;
import com.phplukaas.pepapigquiz.model.Question;
import com.phplukaas.pepapigquiz.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    // Declare our view variables
    private TextView mQuestionTextView;
    private Button mAnswer1Button;
    private Button mAnswer2Button;
    private Button mAnswer3Button;
    private Button mAnswer4Button;
    private QuestionBank mQuestionBank = generateQuestionBank();
    private int mRemainingQuestionCount;
    private Question mCurrentQuestion;
    private int mScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Initialize all the views
        mQuestionTextView = findViewById(R.id.game_activity_textview_question);
        mAnswer1Button = findViewById(R.id.game_activity_button_1);
        mAnswer2Button = findViewById(R.id.game_activity_button_2);
        mAnswer3Button = findViewById(R.id.game_activity_button_3);
        mAnswer4Button = findViewById(R.id.game_activity_button_4);

        // Use the same listener for the four buttons.
        // The view id value will be used to distinguish the button triggered
        mAnswer1Button.setOnClickListener(this);
        mAnswer2Button.setOnClickListener(this);
        mAnswer3Button.setOnClickListener(this);
        mAnswer4Button.setOnClickListener(this);

        // Display question
        mCurrentQuestion = mQuestionBank.getCurrentQuestion();
        displayQuestion(mCurrentQuestion);

        mRemainingQuestionCount = 4;
        mScore = 0;
    }


    private void displayQuestion(final Question question) {
    // Set the text for the question text view and the four buttons
        mQuestionTextView.setText(question.getQuestion());
        mAnswer1Button.setText(question.getChoiceList().get(0));
        mAnswer2Button.setText(question.getChoiceList().get(1));
        mAnswer3Button.setText(question.getChoiceList().get(2));
        mAnswer4Button.setText(question.getChoiceList().get(3));
    }

    private QuestionBank generateQuestionBank() {
        Question question1 = new Question(
                "De quelle couleur est Peppa Pig?",
                Arrays.asList(
                        "Rouge",
                        "Violet",
                        "Vert",
                        "Rose"
                ),
                3
        );

        Question question2 = new Question(
                "Comment s'appelle le nounours de \"Peppa Pig\" ?\n",
                Arrays.asList(
                        "Rosalie",
                        "Teddy",
                        "Little Bear",
                        "Louis"
                ),
                1
        );

        Question question3 = new Question(
                "Qui a créé \"Peppa Pig\" ?  \n",
                Arrays.asList(
                        "Tessa Calow",
                        "Brandon Glee",
                        "Neville Astley",
                        "Louis Hemard"
                ),
                2
        );

        Question question4 = new Question(
                "Comment se nomme la maîtresse de \"Peppa Pig\" ?\n",
                Arrays.asList(
                        "Madame Dog",
                        "Madame Sheep",
                        "Madame Louis",
                        "Madame Gazelle"
                ),
                3
        );


        return new QuestionBank(Arrays.asList(question1, question2, question3, question4));

    }

    @Override
    public void onClick(View v) {
        int index;

        // Get the index of the answer from the tag property of the button
        if (v == mAnswer1Button) {
            index = 0;
        } else if (v == mAnswer2Button) {
            index = 1;
        } else if (v == mAnswer3Button) {
            index = 2;
        } else if (v == mAnswer4Button) {
            index = 3;
        } else {
            throw new IllegalStateException("Unknown clicked view : " + v);
        }

        // Check if the answer is correct
        if (index == mQuestionBank.getCurrentQuestion().getAnswerIndex()) {
            // Good answer
            Toast.makeText(this, "Bonne réponse", Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            // Wrong answer
            Toast.makeText(this, "Mauvaise réponse", Toast.LENGTH_SHORT).show();
        }

        // Check if this is the last question
        mRemainingQuestionCount--;

        if (mRemainingQuestionCount > 0) {
            mCurrentQuestion = mQuestionBank.getNextQuestion();
            displayQuestion(mCurrentQuestion);
        } else {
            // No question left, end the game
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Félicitations !")
                    .setMessage("Voici votre score: " + mScore)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .create()
                    .show();
        }




    }
}