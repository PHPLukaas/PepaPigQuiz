package com.phplukaas.pepapigquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.phplukaas.pepapigquiz.R;
import com.phplukaas.pepapigquiz.model.Question;
import com.phplukaas.pepapigquiz.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity {

    // Declare our view variables
    private TextView mQuestionTextView;
    private Button mAnswer1Button;
    private Button mAnswer2Button;
    private Button mAnswer3Button;
    private Button mAnswer4Button;



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
}