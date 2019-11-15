package com.nimvb.app.service.parser;

import com.nimvb.app.model.ParserStrategyType;
import com.nimvb.app.service.interpreter.base.Expression;
import com.nimvb.app.service.lexer.base.AbstractLexer;
import com.nimvb.app.service.parser.base.Parser;
import com.nimvb.app.service.parser.strategy.factory.ParserStrategyFactory;

import java.io.IOException;

public class ParserService implements Parser {

    private AbstractLexer         lexer;
    private ParserStrategyFactory parserStrategyFactory;

    public ParserService(AbstractLexer lexer, ParserStrategyFactory parserStrategyFactory) {

        this.lexer = lexer;
        this.parserStrategyFactory = parserStrategyFactory;
    }

    @Override
    public Expression parse() throws IOException {
        lexer.next();
        return parserStrategyFactory
                .buildStrategy(ParserStrategyType.EXPRESSION)
                .parse(lexer);

    }

}
