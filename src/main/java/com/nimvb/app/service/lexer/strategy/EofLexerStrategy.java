package com.nimvb.app.service.lexer.strategy;

import com.nimvb.app.model.Token;
import com.nimvb.app.model.TokenType;
import com.nimvb.app.service.lexer.strategy.base.AbstractLexerStrategy;

import java.io.BufferedReader;
import java.io.IOException;

public class EofLexerStrategy extends AbstractLexerStrategy {
    public EofLexerStrategy(BufferedReader reader) {
        super(reader);
    }

    @Override
    public Token lex() throws IOException {
        Token token = new Token();
        token.setType(TokenType.UNKNOWN);
        int currentValue = peekInteger();
        if (currentValue == -1) {
            read();
            token.setType(TokenType.EOF);
        }
        return token;
    }
}
