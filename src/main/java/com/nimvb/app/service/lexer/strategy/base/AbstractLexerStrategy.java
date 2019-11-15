package com.nimvb.app.service.lexer.strategy.base;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;


public abstract class AbstractLexerStrategy implements LexerStrategy {

    @Getter
    protected BufferedReader reader;

    public AbstractLexerStrategy(BufferedReader reader) {
        this.reader = reader;
    }

    protected String peek() throws IOException {
        reader.mark(1);
        String content = String.valueOf(((char) reader.read()));
        reader.reset();
        return content;
    }

    protected int peekInteger() throws IOException {
        reader.mark(1);
        int value = reader.read();
        reader.reset();
        return value;
    }

    protected void read() throws IOException {
        this.reader.read();
    }

    protected void read(int count) throws IOException {
        for (int i = 0; i < count; i++) {
            read();
        }
    }

    protected String peek(int count) throws IOException {
        reader.mark(count);
        String content = "";
        for (int i = 0; i < count; i++) {
            content += String.valueOf(((char) reader.read()));
        }
        reader.reset();
        return content;
    }
}
