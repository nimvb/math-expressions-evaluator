package com.nimvb.app.service.lexer.strategy;

import com.nimvb.app.model.Token;
import com.nimvb.app.model.TokenType;
import com.nimvb.app.service.lexer.strategy.base.AbstractLexerStrategy;

import java.io.BufferedReader;
import java.io.IOException;

public class CosLexerStrategy extends AbstractLexerStrategy {
    public CosLexerStrategy(BufferedReader reader) {
        super(reader);
    }

    @Override
    public Token lex() throws IOException {
        Token token = new Token();
        token.setType(TokenType.UNKNOWN);
        String content = peek(3);
        if (content.matches(TokenType.COS.getRegex())) {
            read(3);
            token.setType(TokenType.COS);
            token.setValue(content);
        }
        return token;
    }
}
