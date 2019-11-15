package com.nimvb.app.service.lexer.base;

import java.io.IOException;

public interface Lexer {

    boolean next() throws IOException;
}
