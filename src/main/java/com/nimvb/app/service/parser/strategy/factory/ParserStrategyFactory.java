package com.nimvb.app.service.parser.strategy.factory;

import com.nimvb.app.model.ParserStrategyType;
import com.nimvb.app.service.parser.strategy.base.AbstractParserStrategy;

public interface ParserStrategyFactory {

    AbstractParserStrategy buildStrategy(ParserStrategyType type);
}
