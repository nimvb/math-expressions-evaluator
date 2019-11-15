package com.nimvb.app.service.interpreter;

import com.nimvb.app.model.ExpressionContext;
import com.nimvb.app.model.Operator;
import com.nimvb.app.service.interpreter.base.Expression;

public class BinaryExpression implements Expression {

    private Expression lhs;
    private Expression rhs;
    private Operator   operator;

    public BinaryExpression(Expression lhs, Expression rhs, Operator operator) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.operator = operator;
    }


    @Override
    public double interpret(ExpressionContext context) {
        double lhsResult = lhs.interpret(context);
        double rhsResult = rhs.interpret(context);
        double result    = -1;
        switch (this.operator) {

            case ADDITION:
                result = lhsResult + rhsResult;
                break;
            case SUBTRACTION:
                result = lhsResult - rhsResult;
                break;
            case DIV:
                result = lhsResult / rhsResult;
                break;
            case MUL:
                result = lhsResult * rhsResult;
                break;
            case MOD:
                result = lhsResult % rhsResult;
                break;
        }
        return result;
    }
}
