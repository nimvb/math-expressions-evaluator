package com.nimvb.app.service.parser.strategy;

import com.nimvb.app.model.Operator;
import com.nimvb.app.model.ParserStrategyType;
import com.nimvb.app.model.Token;
import com.nimvb.app.model.TokenType;
import com.nimvb.app.service.exception.ParseErrorException;
import com.nimvb.app.service.interpreter.*;
import com.nimvb.app.service.interpreter.base.Expression;
import com.nimvb.app.service.lexer.base.AbstractLexer;
import com.nimvb.app.service.parser.strategy.base.AbstractParserStrategy;
import com.nimvb.app.service.parser.strategy.factory.ParserStrategyFactory;

import java.io.IOException;

public class FactorParserStrategy extends AbstractParserStrategy {
    public FactorParserStrategy(ParserStrategyFactory parserStrategyFactory) {
        super(parserStrategyFactory, ParserStrategyType.FACTOR);
    }

    @Override
    public Expression parse(AbstractLexer lexer) throws IOException {
        Token      current = lexer.getToken().clone();
        Expression result  = null;
        if (current.getType() == TokenType.NUMBER) {
            lexer.next();
            result = new NumericExpression(Double.parseDouble(current.getValue()));
        }
        if (current.getType() == TokenType.PLUS || current.getType() == TokenType.MINUS) {
            lexer.next();
            result = new BinaryExpression
                    (
                            result,
                            parserStrategyFactory.buildStrategy(ParserStrategyType.FACTOR).parse(lexer),
                            Operator.toOperator(current.getType())
                    );
        }
        if (current.getType() == TokenType.SIN) {
            lexer.next();
            if (lexer.getToken().getType() != TokenType.PAR_OPEN) {
                throw new ParseErrorException();
            }
            lexer.next();
            result = new SinExpression(
                    parserStrategyFactory
                            .buildStrategy(ParserStrategyType.EXPRESSION)
                            .parse(lexer)
            );
            if (lexer.getToken().getType() != TokenType.PAR_CLOSE) {
                throw new ParseErrorException();
            }
            lexer.next();
        }
        if (current.getType() == TokenType.COS) {
            lexer.next();
            if (lexer.getToken().getType() != TokenType.PAR_OPEN) {
                throw new ParseErrorException();
            }
            lexer.next();
            result = new CosExpression(
                    parserStrategyFactory
                            .buildStrategy(ParserStrategyType.EXPRESSION)
                            .parse(lexer));
            if (lexer.getToken().getType() != TokenType.PAR_CLOSE) {
                throw new ParseErrorException();
            }
            lexer.next();
        }
        if (current.getType() == TokenType.ID) {
            lexer.next();
            result = new VariableExpression(current.getValue());
        }
        if (current.getType() == TokenType.PAR_OPEN) {
            lexer.next();
            result =
                    parserStrategyFactory
                            .buildStrategy(ParserStrategyType.EXPRESSION)
                            .parse(lexer);
            if (current.getType() != TokenType.PAR_CLOSE) {
                throw new ParseErrorException();
            }
            lexer.next();

        }
        return result;
    }
}
