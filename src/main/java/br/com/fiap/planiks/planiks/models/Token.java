package br.com.fiap.planiks.planiks.models;

public record Token(
    String token,
    String type,
    String prefix
) {}