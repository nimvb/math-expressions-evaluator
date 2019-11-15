package com.nimvb.app.service.lexer.strategy;

import com.nimvb.app.model.Token;
import com.nimvb.app.model.TokenType;
import com.nimvb.app.service.lexer.strategy.base.AbstractLexerStrategy;

import java.io.BufferedReader;
import java.io.IOException;

public class NumberLexerStrategy extends AbstractLexerStrategy {
    public NumberLexerStrategy(BufferedReader reader) {
        super(reader);
    }

    @Override
    public Token lex() throws IOException {
        Token token = new Token();
        token.setType(TokenType.UNKNOWN);

        String content = "";
        do {
            String current = peek();
            if (current.matches(TokenType.NUMBER.getRegex())) {
                read();
                content += current;
                token.setType(TokenType.NUMBER);
            } else {
                break;
            }
        } while (true);
        token.setValue(content);
        return token;
    }
}
