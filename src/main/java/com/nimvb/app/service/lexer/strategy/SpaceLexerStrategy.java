package com.nimvb.app.service.lexer.strategy;

import com.nimvb.app.model.Token;
import com.nimvb.app.model.TokenType;
import com.nimvb.app.service.lexer.strategy.base.AbstractLexerStrategy;

import java.io.BufferedReader;
import java.io.IOException;

public class SpaceLexerStrategy extends AbstractLexerStrategy {
    public SpaceLexerStrategy(BufferedReader reader) {
        super(reader);
    }

    @Override
    public Token lex() throws IOException {
        Token token = new Token();
        token.setType(TokenType.UNKNOWN);

        String content = "";
        do {
            String current = peek();
            if (current.matches(TokenType.SPACE.getRegex())) {
                read();
                content += current;
                token.setType(TokenType.SPACE);
            } else {
                break;
            }
        } while (true);
        token.setValue(content);
        return token;
    }
}
