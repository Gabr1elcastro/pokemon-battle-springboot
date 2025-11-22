package com.pokemon;

import com.pokemon.domain.Pokemon;
import com.pokemon.service.ChoosePokemonService;
import com.pokemon.service.CreatePokemonService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        CreatePokemonService createPokemonService = new CreatePokemonService();
        ChoosePokemonService choosePokemonService = new ChoosePokemonService();
        while (true) {
            List<Pokemon> pokemonList = createPokemonService.create();
            List<Pokemon> choosedPokemon = choosePokemonService.choose(pokemonList, leitor);
            Pokemon lutador1 = choosedPokemon.get(0);
            Pokemon lutador2 = choosedPokemon.get(1);

            while (lutador1.getHp() > 0 && lutador2.getHp() > 0) {

                // Bloco IF: O que acontece se o domain.Pokemon 1 for mais rápido
                if (lutador1.getSpeed() > lutador2.getSpeed()) {
                    lutador1.atacar(lutador2);

                    // O domain.Pokemon 2 só ataca de volta SE sobreviver
                    if (lutador2.getHp() > 0) {
                        lutador2.atacar(lutador1);
                    }
                } else {
                    lutador2.atacar(lutador1);
                    if (lutador1.getHp() > 0) {
                        lutador1.atacar(lutador2);
                    }
                }
                try {
                    Thread.sleep(1300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if (lutador1.getHp() > 0) {
                System.out.println(lutador1.getName() + " Ganhou! ");
            } else {
                System.out.println(lutador2.getName() + " Ganhou! ");
            }

            System.out.println("Jogar novamente? (1 para SIM / 0 para NÃO)");
            int jogarNovamente = leitor.nextInt();
            if (jogarNovamente == 0) {
                break;
            }
        }

        leitor.close();
    }
}