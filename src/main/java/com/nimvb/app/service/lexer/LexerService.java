package com.nimvb.app.service.lexer;

import com.nimvb.app.model.TokenType;
import com.nimvb.app.service.lexer.base.AbstractLexer;
import com.nimvb.app.service.lexer.strategy.base.LexerStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class LexerService extends AbstractLexer {


    public LexerService(BufferedReader reader, List<LexerStrategy> strategies) {
        super(reader, strategies);
    }

    @Override
    public boolean next() throws IOException {
        for (LexerStrategy lexerStrategy : lexerStrategies) {
            token = lexerStrategy.lex();
            if (token.getType() == TokenType.EOF) {
                break;
            }
            if (token.getType() != TokenType.UNKNOWN) {
                if (token.getType() == TokenType.SPACE) {
                    return next();
                }
                return true;
            }
        }
        return false;
    }
}
