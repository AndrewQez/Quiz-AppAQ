package org.forestpark.quizProject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView questionsScore;
    private TextView questionText;
    private Button trueButton;
    private Button falseButton;
    private TextView feedbackText;

    private String[] myQuestions = {
            "Messi is the greatest of all Time", //True
            "A penalty is worth 1 point", //True
            "Taking your shirt off is a yellow card", // True
            "The World Cup is every 4 years", //True
            "France are World Cup Champions", //False
            "Dortmund are Champions League Winners", //False
            "Cristiano Ronaldo is R9's Son", //False
            "IShowSpeed invented the Sui", //False
            "Kobe loved Soccer", //True
            "Slide tackles are illegal" //False
    };

    private Boolean[] answers = {true, true, true, true, false, false, false, false, true, false};

    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        questionsScore = findViewById(R.id.questionsScore);
        questionText = findViewById(R.id.questionText);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        feedbackText = findViewById(R.id.feedbackText);

        // Display first question
        displayQuestion();

        // Set up button click listeners
        trueButton.setOnClickListener(v -> {
            checkAnswer(true);
        });

        falseButton.setOnClickListener(v -> {
            checkAnswer(false);
        });
    }

    private void displayQuestion() {
        // Set the current question text
        questionText.setText(myQuestions[currentQuestionIndex]);
    }

    private void checkAnswer(boolean userAnswer) {
        // Check if the user's answer is correct
        if (userAnswer == answers[currentQuestionIndex]) {
            score++;
            feedbackText.setText("Correct!");
        } else {
            feedbackText.setText("Try again");
        }

        // Update the score TextView
        questionsScore.setText("Score: " + score);

        // Move to the next question
        currentQuestionIndex++;

        // Check if we have reached the end of the quiz
        if (currentQuestionIndex < myQuestions.length) {
            displayQuestion();
        } else {
            // Show a toast when all questions are answered
            Toast.makeText(this, "Quiz Finished! Final Score: " + score, Toast.LENGTH_LONG).show();
            // Optionally, reset for a new quiz or disable buttons
            trueButton.setEnabled(false);
            falseButton.setEnabled(false);
        }
    }
}
