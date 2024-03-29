package com.phplukaas.pepapigquiz.model;

import java.util.List;

public class Question {

    // Declare our variables
    private final String mQuestion;
    private final List<String> mChoiceList;
    private final int mAnswerIndex;

    public String getQuestion() {
        return mQuestion;
    }

    public List<String> getChoiceList() {
        return mChoiceList;
    }

    public int getAnswerIndex() {
        return mAnswerIndex;
    }

    public Question(String question, List<String> choiceList, int answerIndex) {
        mQuestion = question;
        mChoiceList = choiceList;
        mAnswerIndex = answerIndex;
    }
}
