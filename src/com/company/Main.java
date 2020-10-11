package com.company;


import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Context context = new Context();
        Expression expression = context.evaluate("1+2-5");
        System.out.println("First equation:" + expression.interpreter());
        String tokenString = "1 2 3 4 5 * * - +"; // 1 + 2 - 3 * 4 * 5 = -57
        Stack<Expression> stack = new Stack<Expression>();
        String[] tokenList = tokenString.split(" ");
        for (String s : tokenList) {
            if (isOperator(s)) {
                Expression rightExpression = stack.pop();
                Expression leftExpression = stack.pop();
                Expression operator = getOperatorInstance(s, leftExpression, rightExpression);
                int result = operator.interpreter();
                stack.push(new NumberExpression(result));
            } else {
                Expression i = new NumberExpression(Integer.parseInt(s));
                stack.push(i);
            }
        }
        System.out.println("Second: " + stack.pop().interpreter());
    }
    public static Expression getOperatorInstance(String s, Expression left, Expression right) {
        switch (s) {
            case "-":
                return new MinusExpression(left, right);
            case "+":
                return new PlusExpression(left, right);
            case "*":
                return new MultiplicationExpression(left, right);
        }
        return null;
    }
    public static boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*"))
            return true;
        else
            return false;
    }

}

