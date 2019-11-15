package com.nimvb.app.service.parser.base;

import com.nimvb.app.service.interpreter.base.Expression;

import java.io.IOException;

public interface Parser {

    Expression parse() throws IOException;
}
