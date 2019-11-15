package com.nimvb.app.service.parser.strategy.builder;

import com.nimvb.app.service.parser.strategy.base.AbstractParserStrategy;
import com.nimvb.app.service.parser.strategy.factory.ParserStrategyFactory;
import com.nimvb.app.service.parser.strategy.factory.ParserStrategyFactoryService;
import com.nimvb.app.service.util.ReflectionUtil;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ParserStrategyFactoryBuilderService implements ParserStrategyFactoryBuilder {
    @Override
    public ParserStrategyFactory build() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        List<AbstractParserStrategy> parserStrategies      = new ArrayList<>();
        ParserStrategyFactory        parserStrategyFactory = new ParserStrategyFactoryService(parserStrategies);
        File                         parent                = ReflectionUtil.parentPackageAsFile(AbstractParserStrategy.class);
        List<Class<?>>               childClasses          = ReflectionUtil.getChildClasses(parent, AbstractParserStrategy.class);
        for (Class<?> childClass : childClasses) {
            AbstractParserStrategy lexerStrategy =
                    (AbstractParserStrategy) childClass
                            .getDeclaredConstructor(ParserStrategyFactory.class)
                            .newInstance(parserStrategyFactory);
            parserStrategies.add(lexerStrategy);
        }
        return parserStrategyFactory;
    }
}
