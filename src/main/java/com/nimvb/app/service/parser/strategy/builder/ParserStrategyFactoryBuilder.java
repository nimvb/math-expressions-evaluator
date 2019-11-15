package com.nimvb.app.service.parser.strategy.builder;

import com.nimvb.app.service.parser.strategy.factory.ParserStrategyFactory;

import java.lang.reflect.InvocationTargetException;

public interface ParserStrategyFactoryBuilder {

    ParserStrategyFactory build() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
