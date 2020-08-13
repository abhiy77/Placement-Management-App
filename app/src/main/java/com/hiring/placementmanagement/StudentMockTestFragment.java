package com.hiring.placementmanagement;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hiring.placementmanagement.com.hiring.placementmanagement.model.Question;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;


public class StudentMockTestFragment extends Fragment {

    private Button buttonStartMockTest;
    private TextView textViewHighScore;
    ArrayList<Question> questionList;


    private static final int REQUEST_CODE_QUIZ = 1;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighScore";

    private int highScore;



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_mock_test, container, false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        buttonStartMockTest = getView().findViewById(R.id.button_start_mock_test);
        textViewHighScore = getView().findViewById(R.id.text_view_highscore);

        buttonStartMockTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });

        loadHighScore();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
           questionList  = getArguments().getParcelableArrayList("QUESTION_LIST");
        }

    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode == REQUEST_CODE_QUIZ){
            if(resultCode == RESULT_OK){
                int score = data.getIntExtra(QuizActivity.EXTRA_SCORE,0);
                if(score > highScore){
                    updateHighScore(score);
                }
            }
        }
    }



    // Defined Methods

    private void loadHighScore() {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
        highScore = sharedPreferences.getInt(KEY_HIGHSCORE,0);
        textViewHighScore.setText("High Score: " + highScore);
    }

    private void startQuiz(){
        Intent intent = new Intent(getActivity(),QuizActivity.class);
        intent.putParcelableArrayListExtra("QUIZ_QUESTIONS",questionList);
        getActivity().startActivityForResult(intent,REQUEST_CODE_QUIZ);
    }

    private void updateHighScore(int newScore){
        highScore = newScore;
        textViewHighScore.setText("High Score: " + highScore);
        SharedPreferences prefs = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highScore);
        editor.apply();
    }

}