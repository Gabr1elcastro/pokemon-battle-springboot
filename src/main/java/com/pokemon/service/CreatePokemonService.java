package com.pokemon.service;

import com.pokemon.domain.Pokemon;
import com.pokemon.domain.PokemonType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatePokemonService {

    public List<Pokemon> create(){
        Pokemon pokemon1 = new Pokemon("Charmander", PokemonType.FOGO, 39, 52, 43, 65);
        Pokemon pokemon2 = new Pokemon("Squirtle", PokemonType.AGUA, 44, 48, 65, 43);
        Pokemon pokemon3 = new Pokemon("Bulbassauro", PokemonType.GRAMA, 45, 49, 49, 45);
        return List.of(pokemon1, pokemon2, pokemon3);
    }

}
