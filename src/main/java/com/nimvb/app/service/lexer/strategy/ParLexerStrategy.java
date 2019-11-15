package com.nimvb.app.service.lexer.strategy;

import com.nimvb.app.model.Token;
import com.nimvb.app.model.TokenType;
import com.nimvb.app.service.lexer.strategy.base.AbstractLexerStrategy;

import java.io.BufferedReader;
import java.io.IOException;

public class ParLexerStrategy extends AbstractLexerStrategy {
    public ParLexerStrategy(BufferedReader reader) {
        super(reader);
    }

    @Override
    public Token lex() throws IOException {
        Token token = new Token();
        token.setType(TokenType.UNKNOWN);
        String content = peek();
        if (content.matches(TokenType.PAR_OPEN.getRegex())) {
            read();
            token.setType(TokenType.PAR_OPEN);
        }
        if (content.matches(TokenType.PAR_CLOSE.getRegex())) {
            read();
            token.setType(TokenType.PAR_CLOSE);
        }
        if (token.getType() != TokenType.UNKNOWN) {
            token.setValue(content);
        }
        return token;
    }
}
