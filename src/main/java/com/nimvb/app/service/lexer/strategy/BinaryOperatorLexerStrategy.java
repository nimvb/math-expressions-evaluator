package com.nimvb.app.service.lexer.strategy;

import com.nimvb.app.model.Token;
import com.nimvb.app.model.TokenType;
import com.nimvb.app.service.lexer.strategy.base.AbstractLexerStrategy;

import java.io.BufferedReader;
import java.io.IOException;

public class BinaryOperatorLexerStrategy extends AbstractLexerStrategy {
    public BinaryOperatorLexerStrategy(BufferedReader reader) {
        super(reader);
    }

    @Override
    public Token lex() throws IOException {
        Token token = new Token();
        token.setType(TokenType.UNKNOWN);
        String content = peek();
        if (content.matches(TokenType.PLUS.getRegex())) {
            read();
            token.setType(TokenType.PLUS);
        }
        if (content.matches(TokenType.MINUS.getRegex())) {
            read();
            token.setType(TokenType.MINUS);
        }
        if (content.matches(TokenType.DIV.getRegex())) {
            read();
            token.setType(TokenType.DIV);
        }
        if (content.matches(TokenType.MUL.getRegex())) {
            read();
            token.setType(TokenType.MUL);
        }
        if (content.matches(TokenType.MOD.getRegex())) {
            read();
            token.setType(TokenType.MOD);
        }
        if (token.getType() != TokenType.UNKNOWN) {
            token.setValue(content);
        }
        return token;
    }
}
