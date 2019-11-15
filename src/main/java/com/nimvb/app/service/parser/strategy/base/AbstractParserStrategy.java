package com.nimvb.app.service.parser.strategy.base;

import com.nimvb.app.model.ParserStrategyType;
import com.nimvb.app.service.parser.strategy.factory.ParserStrategyFactory;
import lombok.Getter;

public abstract class AbstractParserStrategy implements ParserStrategy {

    @Getter
    protected ParserStrategyType    type;
    protected ParserStrategyFactory parserStrategyFactory;

    public AbstractParserStrategy(ParserStrategyFactory parserStrategyFactory, ParserStrategyType type) {
        this.parserStrategyFactory = parserStrategyFactory;
        this.type = type;
    }
}
