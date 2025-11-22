package com.pokemon.domain;

public class Pokemon {
    private String name;
    private PokemonType type;
    private int hp;
    private int atack;
    private int defense;
    private int speed;

    public String getName() {
        return name;
    }

    public PokemonType getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public int getAtack() {
        return atack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

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
        if ((this.type.equals("agua") && alvo.type.equals("fogo")) ||
                (this.type.equals("fogo") && alvo.type.equals("grama")) ||
                (this.type.equals("grama") && alvo.type.equals("agua"))
        ) {
            dano *= 2;
        }
        alvo.hp = alvo.hp - dano;
        System.out.println(this.name + " Atacou " + alvo.name + " e causou: " + dano + " de dano.");
    }
}


