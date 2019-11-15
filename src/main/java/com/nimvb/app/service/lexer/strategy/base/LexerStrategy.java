package com.nimvb.app.service.lexer.strategy.base;

import com.nimvb.app.model.Token;

import java.io.IOException;

public interface LexerStrategy {
    Token lex() throws IOException;
}
