package com.company;

public class MultiplicationExpression implements Expression {

    public Expression left;
    public Expression right;

    public MultiplicationExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpreter() {
        return left.interpreter()*right.interpreter();
    }
}
