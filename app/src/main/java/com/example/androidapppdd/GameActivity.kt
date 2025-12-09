package com.example.androidapppdd

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.load

class GameActivity : AppCompatActivity() {

    private lateinit var pokemonList: List<Pokemon>
    private var currentIndex = 0
    private var score = 0

    private lateinit var pokemonImage: ImageView
    private lateinit var scoreText: TextView
    private lateinit var progressText: TextView
    private lateinit var guessInput: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        // Initialize views
        pokemonImage = findViewById(R.id.pokemonImage)
        scoreText = findViewById(R.id.scoreText)
        progressText = findViewById(R.id.progressText)
        guessInput = findViewById(R.id.guessInput)
        submitButton = findViewById(R.id.submitButton)

        // Get randomized pokemon list
        pokemonList = PokemonData.getRandomPokemon()

        // Load first pokemon
        loadCurrentPokemon()

        // Set up submit button
        submitButton.setOnClickListener {
            checkAnswer()
        }
    }

    private fun loadCurrentPokemon() {
        val currentPokemon = pokemonList[currentIndex]

        // Load image
        pokemonImage.load(currentPokemon.imageUrl) {
            crossfade(true)
            placeholder(android.R.drawable.ic_menu_gallery)
            error(android.R.drawable.ic_dialog_alert)
        }

        // Update UI
        scoreText.text = "Score: $score/${pokemonList.size}"
        progressText.text = "Pokemon ${currentIndex + 1} of ${pokemonList.size}"
        guessInput.text.clear()
        guessInput.isEnabled = true
        submitButton.isEnabled = true
    }

    private fun checkAnswer() {
        val guess = guessInput.text.toString().trim()
        val correctName = pokemonList[currentIndex].name

        if (guess.equals(correctName, ignoreCase = true)) {
            score++
            Toast.makeText(this, "Correct! It's $correctName!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Wrong! It was $correctName", Toast.LENGTH_SHORT).show()
        }

        // Move to next pokemon or finish game
        currentIndex++

        if (currentIndex < pokemonList.size) {
            // Load next pokemon after a short delay
            guessInput.postDelayed({
                loadCurrentPokemon()
            }, 1500)
            guessInput.isEnabled = false
            submitButton.isEnabled = false
        } else {
            // Game over
            guessInput.postDelayed({
                showGameOver()
            }, 1500)
            guessInput.isEnabled = false
            submitButton.isEnabled = false
        }
    }

    private fun showGameOver() {
        val intent = Intent(this, GameOverActivity::class.java)
        intent.putExtra("SCORE", score)
        intent.putExtra("TOTAL", pokemonList.size)
        startActivity(intent)
        finish()
    }
}