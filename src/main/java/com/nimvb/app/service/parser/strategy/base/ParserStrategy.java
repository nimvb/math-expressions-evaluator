package com.nimvb.app.service.parser.strategy.base;

import com.nimvb.app.service.interpreter.base.Expression;
import com.nimvb.app.service.lexer.base.AbstractLexer;

import java.io.IOException;

public interface ParserStrategy {

    Expression parse(AbstractLexer lexer) throws IOException;
}
