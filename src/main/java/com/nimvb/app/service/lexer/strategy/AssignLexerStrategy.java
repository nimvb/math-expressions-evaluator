package com.nimvb.app.service.lexer.strategy;

import com.nimvb.app.model.Token;
import com.nimvb.app.model.TokenType;
import com.nimvb.app.service.lexer.strategy.base.AbstractLexerStrategy;

import java.io.BufferedReader;
import java.io.IOException;

public class AssignLexerStrategy extends AbstractLexerStrategy {
    public AssignLexerStrategy(BufferedReader reader) {
        super(reader);
    }

    @Override
    public Token lex() throws IOException {
        Token token = new Token();
        token.setType(TokenType.UNKNOWN);
        token.setValue("");
        String next = peek();
        if (next.matches(TokenType.ASSIGN.getRegex())) {
            read();
            token.setType(TokenType.ASSIGN);
            token.setValue(next);
        }
        return token;
    }
}
