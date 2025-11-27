package com.pokemon;

import com.pokemon.domain.Pokemon;
import com.pokemon.service.ChoosePokemonService;
import com.pokemon.service.CreatePokemonService;
import com.pokemon.service.PokemonBattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class PokemonBattleApplication implements CommandLineRunner {

    @Autowired
    CreatePokemonService createPokemonService;
    @Autowired
    ChoosePokemonService choosePokemonService;
    @Autowired
    PokemonBattleService pokemonBattleService;
	public static void main(String[] args) {
		SpringApplication.run(PokemonBattleApplication.class, args);
	}

    @Override
    public void run(String[] args) throws Exception {

        Scanner leitor = new Scanner(System.in);

        while (true) {
            List<Pokemon> pokemonList = createPokemonService.create();
            List<Pokemon> choosedPokemon = choosePokemonService.choose(pokemonList, leitor);

            pokemonBattleService.battle(choosedPokemon.get(0), choosedPokemon.get(1));

            System.out.println("Jogar novamente? (1 para SIM / 0 para NÃO)");
            int jogarNovamente = leitor.nextInt();
            leitor.nextLine();
            if (jogarNovamente == 0) {
                break;
            }
        }

        leitor.close();
    }
}
