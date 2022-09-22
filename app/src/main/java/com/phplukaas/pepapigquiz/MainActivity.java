package com.phplukaas.pepapigquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        mNameEditText = findViewById(R.id.main_edittext_name);
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
            // Get user's name
            String name = mNameEditText.getText().toString();

            // Display greeting
            mGreetingTextView.setText("Hello " + name + "!");
        });




    }
}