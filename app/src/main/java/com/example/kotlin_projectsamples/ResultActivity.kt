package com.example.kotlin_projectsamples

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    lateinit var result: TextView
    lateinit var playAgain: Button
    lateinit var exit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        result = findViewById(R.id.textViewResult)
        playAgain = findViewById(R.id.buttonAgain)
        exit = findViewById(R.id.buttonExit)

        val score = intent.getIntExtra("score", 0)
        result.text = "your score is $score"

        playAgain.setOnClickListener {
            val intent = Intent(this@ResultActivity, GameActivity::class.java)
            startActivity(intent)
            finish()
        }

        exit.setOnClickListener {
            // Close ResultActivity will open the MainActivity in Stack, so need to close MainActivity as well
            val intent = Intent(Intent(Intent.ACTION_MAIN))
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}