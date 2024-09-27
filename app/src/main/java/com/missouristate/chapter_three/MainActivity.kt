package com.missouristate.chapter_three

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.missouristate.chapter_three.databinding.ActivityMainBinding

private const val TAG = "MainActivity"



class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private val questionBank = listOf(
        Question(R.string.question_australia,true),
        Question(R.string.question_oceans,true),
        Question(R.string.question_mideast,false),
        Question(R.string.question_africa,false),
        Question(R.string.question_americas,true),
        Question(R.string.question_asia,true),
    )

    private var currentIndex = 0

    //lateinit allows initializing a not-null property outside of a constructor



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //BINDING SET UP
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate(Bundle) called")


        //https://developer.android.com/develop/ui/views/notifications/snackbar/action

        binding.trueButton.setOnClickListener {
            checkAnswer(true)
        }
        binding.falseButton.setOnClickListener {
            checkAnswer(false)
        }

        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }

        updateQuestion()

    }

    //refactored code
    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer (userAnswer:Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct
        } else {
            R.string.incorrect
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }



    /// LOGGING (Assignment 3.1)

    override fun onStart(){
        super.onStart()
        Log.d(TAG,"onStart() called")
    }

    override fun onPause(){
        super.onPause()
        Log.d(TAG,"onPause() called")
    }

    override fun onStop(){
        super.onStop()
        Log.d(TAG,"onStop() called")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d(TAG,"onDestroy() called")
    }


}