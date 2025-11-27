package com.pokemon.service;

import com.pokemon.domain.Pokemon;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class ChoosePokemonService {

    public List<Pokemon> choose(List<Pokemon> pokemonList, Scanner scanner) {
        printPokemonList(pokemonList);

        System.out.println("---------Digite o nome do primeiro Pokemon---------");
        Pokemon fighter1 = choosePokemon(scanner, pokemonList);

        System.out.println("---------Digite o nome do segundo Pokemon----------");
        Pokemon fighter2 = choosePokemon(scanner, pokemonList);

        return List.of(fighter1, fighter2);
    }

    private static void printPokemonList(List<Pokemon> pokemonList) {
        for (int i = 0; i < pokemonList.size(); i++) {
            System.out.println(pokemonList.get(i).getName());
        }
    }

    private Pokemon choosePokemon(Scanner scanner, List<Pokemon> pokemonList) {
        while (true) {
            String choosedPokemon = scanner.nextLine();

            for (int i = 0; i < pokemonList.size(); i++) {
                Pokemon currentPokemon = pokemonList.get(i);

                if (currentPokemon.getName().equalsIgnoreCase(choosedPokemon)) {
                    return currentPokemon;
                }
            }

            System.out.println("Incorrect name! Please re-enter the Pokemon's name:");
        }
    }
}