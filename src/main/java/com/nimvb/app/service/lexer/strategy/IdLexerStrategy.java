package com.nimvb.app.service.lexer.strategy;

import com.nimvb.app.model.Token;
import com.nimvb.app.model.TokenType;
import com.nimvb.app.service.lexer.strategy.base.AbstractLexerStrategy;

import java.io.BufferedReader;
import java.io.IOException;

public class IdLexerStrategy extends AbstractLexerStrategy {
    public IdLexerStrategy(BufferedReader reader) {
        super(reader);
    }

    @Override
    public Token lex() throws IOException {
        Token token = new Token();
        token.setType(TokenType.UNKNOWN);

        String content   = peek(2);
        String signRegex = TokenType.ID.getRegex().split(",")[0];
        String idRegex   = TokenType.ID.getRegex().split(",")[1];
        if (content.matches((signRegex + idRegex))) {
            content = "";
            token.setType(TokenType.ID);
            do {

                String current = peek();
                if (current.matches(signRegex) && !content.startsWith(current)) {
                    content += current;
                    read();
                    continue;
                }
                if (current.matches(idRegex)) {
                    content += current;
                    read();
                    continue;
                }
                break;

            } while (true);
            token.setValue(content);
        }
        return token;
    }
}
