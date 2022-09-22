package com.phplukaas.pepapigquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.phplukaas.pepapigquiz.R;
import com.phplukaas.pepapigquiz.model.User;

public class MainActivity extends AppCompatActivity {

    // Declare our view variables
    private TextView mGreetingTextView;
    private EditText mNameEditText;
    private Button mPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all the views
        mGreetingTextView = findViewById(R.id.main_textview_greeting);
        mNameEditText = findViewById(R  .id.main_edittext_name);
        mPlayButton = findViewById(R.id.main_button_start);

        // Disable button until user enters name
        mPlayButton.setEnabled(false);

        // Detect when user enters name
        mNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // Enable button
                mPlayButton.setEnabled(true);
                mPlayButton.setEnabled(!s.toString().isEmpty());
            }
        });

        // Detect when user clicks button
        mPlayButton.setOnClickListener(v -> {

            // Get user name
            User mUser = new User();
            mUser.setFirstName(mNameEditText.getText().toString());

            // Intent to start GameActivity
            Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(gameActivityIntent);

        });




    }
}