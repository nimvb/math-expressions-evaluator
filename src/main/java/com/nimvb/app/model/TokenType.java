package com.nimvb.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TokenType {

    NUMBER("[0-9]"),
    ID("\\$,[a-zA-Z0-9]"),
    PLUS("\\+"),
    MINUS("-"),
    MUL("\\*"),
    DIV("/"),
    MOD("%"),
    ASSIGN("="),
    PAR_OPEN("\\("),
    PAR_CLOSE("\\)"),
    COS("cos"),
    SIN("sin"),
    SPACE("\\s"),
    SEMICOLON(";"),
    EOF(""),
    UNKNOWN("");

    @Getter
    private String regex;
}
