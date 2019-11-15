package com.nimvb.app.service.lexer.builder;

import com.nimvb.app.service.lexer.LexerService;
import com.nimvb.app.service.lexer.base.AbstractLexer;
import com.nimvb.app.service.lexer.builder.base.LexerBuilder;
import com.nimvb.app.service.lexer.strategy.base.AbstractLexerStrategy;
import com.nimvb.app.service.lexer.strategy.base.LexerStrategy;
import com.nimvb.app.service.util.ReflectionUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class LexerBuilderService implements LexerBuilder {

    List<LexerStrategy> lexerStrategies;
    BufferedReader      reader;

    public LexerBuilderService(InputStream inputStream) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        reader = new BufferedReader(new InputStreamReader(inputStream));
        lexerStrategies = new ArrayList<>();
        File           parent       = ReflectionUtil.parentPackageAsFile(AbstractLexerStrategy.class);
        List<Class<?>> childClasses = ReflectionUtil.getChildClasses(parent, AbstractLexerStrategy.class);
        for (Class<?> childClass : childClasses) {
            LexerStrategy lexerStrategy = (LexerStrategy) childClass.getDeclaredConstructor(BufferedReader.class).newInstance(reader);
            lexerStrategies.add(lexerStrategy);
        }

    }

    @Override
    public AbstractLexer build() {

        return new LexerService(reader, lexerStrategies);
    }
}
