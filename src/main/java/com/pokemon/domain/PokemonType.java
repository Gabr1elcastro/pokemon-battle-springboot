package com.pokemon.domain;
import java.util.List;

public enum PokemonType {
    GRAMA,
    FOGO,
    AGUA;

   private List<PokemonType> vantagens;

    static {
        GRAMA.vantagens = List.of(AGUA);
        FOGO.vantagens = List.of(GRAMA);
        AGUA.vantagens = List.of(FOGO);
    }
}
