package com.nimvb.app.service.lexer.strategy;

import com.nimvb.app.model.Token;
import com.nimvb.app.model.TokenType;
import com.nimvb.app.service.lexer.strategy.base.AbstractLexerStrategy;

import java.io.BufferedReader;
import java.io.IOException;

public class SinLexerStrategy extends AbstractLexerStrategy {
    public SinLexerStrategy(BufferedReader reader) {
        super(reader);
    }

    @Override
    public Token lex() throws IOException {
        Token token = new Token();
        token.setType(TokenType.UNKNOWN);
        String content = peek(3);
        if (content.matches(TokenType.SIN.getRegex())) {
            read(3);
            token.setType(TokenType.SIN);
            token.setValue(content);
        }
        return token;
    }
}
