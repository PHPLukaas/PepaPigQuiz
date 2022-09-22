package com.phplukaas.pepapigquiz.model;

import java.util.Collections;
import java.util.List;

public class QuestionBank {

    private List<Question> mQuestionList;
    private int mQuestionIndex;

    public QuestionBank(List<Question> questionList) {
        mQuestionList = questionList;
        // Shuffle the question list before storing it
        Collections.shuffle(mQuestionList);

    }

    public Question getCurrentQuestion() {
        return mQuestionList.get(mQuestionIndex);
    }

    public Question getNextQuestion() {
        // Loop over the questions and return a new one at each call
        mQuestionIndex++;
        return getCurrentQuestion();
    }




}
