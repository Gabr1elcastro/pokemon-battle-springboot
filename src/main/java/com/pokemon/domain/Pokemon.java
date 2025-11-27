package com.pokemon.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class Pokemon {
    private String name;
    private PokemonType type;
    private int hp;
    private int atack;
    private int defense;
    private int speed;


    public Pokemon(String nomePraSalvar, PokemonType tipoPraSalvar, int hpPraSalvar, int ataquePraSalvar, int defesaPraSalvar, int velocidadePraSalvar) {
        this.name = nomePraSalvar;
        this.type = tipoPraSalvar;
        this.hp = hpPraSalvar;
        this.atack = ataquePraSalvar;
        this.defense = defesaPraSalvar;
        this.speed = velocidadePraSalvar;
    }

    public void atacar(Pokemon alvo) {
        int dano = this.atack - alvo.defense;
        PokemonType myType = this.type;
        PokemonType alvoType = alvo.type;
        List<PokemonType> tiposFracosContraMeuPokemon = myType.getVantagens();
        boolean meuAlvoEFracoContraMim = tiposFracosContraMeuPokemon.contains(alvoType);

        if (meuAlvoEFracoContraMim) {
            dano *= 2;
        }
        alvo.hp = alvo.hp - dano;
        System.out.println(this.name + " Atacou " + alvo.name + " e causou: " + dano + " de dano.");
    }
}


