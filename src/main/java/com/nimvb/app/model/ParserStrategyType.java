package com.nimvb.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ParserStrategyType {

    EXPRESSION("EXPRESSION", "<Expr> ::= <Term> | Term { + | - } <Expr>"),
    TERM("TERM", "<Term> ::= <Factor> | <Factor> {*|/|%} <Term>"),
    FACTOR("TERM", "<Factor>::= <number> | ( <expr> ) | {+|-} <factor> | SIN(<expr>) | COS(<expr>) | $t ");
    @Getter
    private String type;
    @Getter
    private String bnf;

    public static String generateBnfString() {
        String bnf = "";
        for (ParserStrategyType value : ParserStrategyType.values()) {
            bnf += value.getBnf() + "\n";
        }
        return bnf;
    }
}
