package com.nimvb.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Operator {
    ADDITION("+"),
    SUBTRACTION("-"),
    DIV("/"),
    MUL("*"),
    MOD("%");
    @Getter
    private String type;


    public static Operator toOperator(TokenType type) {
        switch (type) {

            case PLUS:
                return Operator.ADDITION;
            case MINUS:
                return Operator.SUBTRACTION;
            case MUL:
                return Operator.MUL;
            case DIV:
                return Operator.DIV;
            case MOD:
                return Operator.MOD;
        }
        throw new RuntimeException();
    }
}
