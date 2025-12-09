package com.example.androidapppdd

data class Pokemon(
    val id: Int,
    val name: String,
    val imageUrl: String
)

object PokemonData {
    val pokemonList = listOf(
        Pokemon(1, "Bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"),
        Pokemon(25, "Pikachu", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png"),
        Pokemon(6, "Charizard", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/6.png"),
        Pokemon(9, "Blastoise", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/9.png"),
        Pokemon(248, "Tyranitar", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/248.png")
    )

    fun getRandomPokemon(): List<Pokemon> {
        return pokemonList.shuffled()
    }
}