package app.actions;

import ExpressionOP.Expressions.Core.Expression;
import ExpressionOP.Factories.OperationFactory;
import ExpressionOP.InfixToPostfix;
import ExpressionOP.Operations.Operation;
import ExpressionOP.TreeParser;

import java.util.ArrayList;

/**
 * Created by Sem on 25-Jul-17.
 */
public class ResultAction extends Action {

    @Override
    public ArrayList<Operation> doAction(final ArrayList<Operation> infixExpression) {
        ArrayList<Operation> postFixOperation = InfixToPostfix.convert(infixExpression);
        Expression expressionTree = TreeParser.postFixToExpressionTree(postFixOperation);

        ArrayList<Operation> expressionResult = new ArrayList<>();
        expressionResult.add(OperationFactory.createOperand(expressionTree.resolve()));
        return expressionResult;
    }

    @Override
    public String getName() {
        return "=";
    }
}

