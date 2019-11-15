package com.nimvb.app;

import com.nimvb.app.model.ExpressionContext;
import com.nimvb.app.model.ParserStrategyType;
import com.nimvb.app.service.interpreter.base.Expression;
import com.nimvb.app.service.lexer.base.AbstractLexer;
import com.nimvb.app.service.lexer.builder.LexerBuilderService;
import com.nimvb.app.service.lexer.builder.base.LexerBuilder;
import com.nimvb.app.service.parser.ParserService;
import com.nimvb.app.service.parser.base.Parser;
import com.nimvb.app.service.parser.strategy.factory.ParserStrategyFactoryService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        System.out.println(ParserStrategyType.generateBnfString());
        LexerBuilder      lexerBuilder = new LexerBuilderService(new ByteArrayInputStream("sin(10   * 10 * cos(50)) + $id % 1 ".getBytes()));
        AbstractLexer     lexer        = lexerBuilder.build();
        Parser            parser       = new ParserService(lexer, ParserStrategyFactoryService.builder().build());
        Expression        ast          = parser.parse();
        ExpressionContext context      = new ExpressionContext();
        context.getVariables().put("$id", 2.0);
        context.getVariables().put("$idz", 20.0);
        context.getVariables().put("$id122", 20.0);
        double interpret = ast.interpret(context);

        System.out.println(interpret);

    }
}
