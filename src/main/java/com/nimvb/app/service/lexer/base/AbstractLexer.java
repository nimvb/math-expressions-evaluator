package com.nimvb.app.service.lexer.base;

import com.nimvb.app.model.Token;
import com.nimvb.app.service.lexer.strategy.base.LexerStrategy;

import java.io.BufferedReader;
import java.util.List;

public abstract class AbstractLexer implements Lexer {

    protected Token               token;
    protected BufferedReader      reader;
    protected List<LexerStrategy> lexerStrategies;

    public AbstractLexer(BufferedReader reader, List<LexerStrategy> strategies) {
        this.reader = reader;
        lexerStrategies = strategies;
    }

    public Token getToken() {
        return token;
    }
}
