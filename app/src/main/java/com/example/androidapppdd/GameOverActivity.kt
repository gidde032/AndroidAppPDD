package com.example.androidapppdd

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameOverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        val score = intent.getIntExtra("SCORE", 0)
        val total = intent.getIntExtra("TOTAL", 5)

        val resultText = findViewById<TextView>(R.id.resultText)
        val scoreText = findViewById<TextView>(R.id.finalScoreText)
        val playAgainButton = findViewById<Button>(R.id.playAgainButton)
        val homeButton = findViewById<Button>(R.id.homeButton)

        // Display results
        scoreText.text = "You got $score out of $total correct!"

        val percentage = (score.toFloat() / total.toFloat() * 100).toInt()
        resultText.text = when {
            percentage == 100 -> "Perfect! You're a Pokemon Master! 🌟"
            percentage >= 80 -> "Great job! 🎉"
            percentage >= 60 -> "Not bad! 👍"
            else -> "Keep practicing! 💪"
        }

        // Play again button
        playAgainButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Home button
        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}