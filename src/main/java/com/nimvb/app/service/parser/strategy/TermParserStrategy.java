package com.nimvb.app.service.parser.strategy;

import com.nimvb.app.model.Operator;
import com.nimvb.app.model.ParserStrategyType;
import com.nimvb.app.model.Token;
import com.nimvb.app.model.TokenType;
import com.nimvb.app.service.interpreter.BinaryExpression;
import com.nimvb.app.service.interpreter.base.Expression;
import com.nimvb.app.service.lexer.base.AbstractLexer;
import com.nimvb.app.service.parser.strategy.base.AbstractParserStrategy;
import com.nimvb.app.service.parser.strategy.factory.ParserStrategyFactory;

import java.io.IOException;

public class TermParserStrategy extends AbstractParserStrategy {
    public TermParserStrategy(ParserStrategyFactory parserStrategyFactory) {
        super(parserStrategyFactory, ParserStrategyType.TERM);
    }

    @Override
    public Expression parse(AbstractLexer lexer) throws IOException {
        Expression result  = parserStrategyFactory.buildStrategy(ParserStrategyType.FACTOR).parse(lexer);
        Token      current = lexer.getToken().clone();
        if (current.getType() == TokenType.MUL ||
                current.getType() == TokenType.DIV ||
                current.getType() == TokenType.MOD) {
            lexer.next();
            result = new BinaryExpression(
                    result,
                    parse(lexer),
                    Operator.toOperator(current.getType())
            );
        }
        return result;
    }
}
