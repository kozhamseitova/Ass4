package com.company;

public class MinusExpression implements Expression {

    public Expression left;
    public Expression right;

    public MinusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpreter() {
        return left.interpreter()-right.interpreter();
    }
}
