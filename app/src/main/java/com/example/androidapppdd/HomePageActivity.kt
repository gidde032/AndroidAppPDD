package com.example.androidapppdd

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import coil.load

class HomePageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val tyranitarImage = findViewById<ImageView>(R.id.tyranitarImage)
        val pokeballImage = findViewById<ImageView>(R.id.pokeballImage)
        val startGameButton = findViewById<Button>(R.id.startGameButton)

        // Load Pokeball
        pokeballImage.load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/poke-ball.png") {
            crossfade(true)
        }

        // Load Tyranitar from PokeAPI
        tyranitarImage.load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/248.png") {
            crossfade(true)
            placeholder(android.R.drawable.ic_menu_gallery)
            error(android.R.drawable.ic_dialog_alert)
        }

        // Start game when button is clicked
        startGameButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
}