package com.pokemon.service;

import com.pokemon.domain.Pokemon;

import java.util.List;
import java.util.Scanner;

public class ChoosePokemonService {

    public List<Pokemon> choose(List<Pokemon> pokemon, Scanner leitor) {
        Pokemon lutador1 = null;
        Pokemon lutador2 = null;

        for (int i = 0; i < pokemon.size(); i++) {
            System.out.println(pokemon.get(i).getName());
        }

        System.out.println("---------Digite o nome do primeiro Pokemon---------");

        String escolha1 = leitor.nextLine();
        for (int i = 0; i < pokemon.size(); i++) {
            if (pokemon.get(i).getName().equals(escolha1)) {
                lutador1 = pokemon.get(i);
            }

        }

        System.out.println("---------Digite o nome do segundo Pokemon----------");

        String escolha2 = leitor.nextLine();
        for (int i = 0; i < pokemon.size(); i++) {
            if (pokemon.get(i).getName().equals(escolha2)) {
                lutador2 = pokemon.get(i);
            }
        }
        return List.of(lutador1, lutador2);
    }
}
