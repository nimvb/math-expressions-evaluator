package com.nimvb.app.service.parser.strategy.factory;

import com.nimvb.app.model.ParserStrategyType;
import com.nimvb.app.service.parser.strategy.base.AbstractParserStrategy;
import com.nimvb.app.service.parser.strategy.builder.ParserStrategyFactoryBuilder;
import com.nimvb.app.service.parser.strategy.builder.ParserStrategyFactoryBuilderService;

import java.util.List;

public class ParserStrategyFactoryService implements ParserStrategyFactory {

    private List<AbstractParserStrategy> strategies;

    public ParserStrategyFactoryService(List<AbstractParserStrategy> strategies) {

        this.strategies = strategies;
    }

    public static ParserStrategyFactoryBuilder builder() {
        return new ParserStrategyFactoryBuilderService();
    }

    @Override
    public AbstractParserStrategy buildStrategy(ParserStrategyType type) {
        for (AbstractParserStrategy strategy : strategies) {
            if (strategy.getType() == type) {
                return strategy;
            }
        }
        //TODO: Add custom exception
        throw new RuntimeException();
    }
}
