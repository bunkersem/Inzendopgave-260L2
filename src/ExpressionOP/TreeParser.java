package ExpressionOP;

import ExpressionOP.Expressions.Core.Expression;
import ExpressionOP.Factories.ExpressionFactory;
import ExpressionOP.Operations.Operation;
import ExpressionOP.Operations.OperationType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Stack;

/**
 * Created by Sem on 25-Jul-17.
 */
public class TreeParser {
    public static Expression postFixToExpressionTree (ArrayList<Operation> postFix) {
        Stack<Expression> expressionTree = new Stack<Expression>();

        for (int i = 0; i < postFix.size(); i++) {
            Operation curr = postFix.get(i);


            if (Arrays.asList(Operation.nihilOperators).contains(curr.getType())) {
                // This is a nihil operator (operand)
                expressionTree.push(ExpressionFactory.createExpression(curr));
            }
            // Test if the current operation is of type "operator" by checking the Operator.operators List.
            else if (Arrays.asList(Operation.monoOperators).contains(curr.getType())) {
                // Sanity checking
                if (expressionTree.size() < 1)
                    throw new IllegalStateException("A mono operator does not have enough operands");

                // This is a mono operator.
                Expression child = expressionTree.pop();
                expressionTree.push(ExpressionFactory.createExpression(curr, child));
            }
            else if (Arrays.asList(Operation.binaryOperators).contains(curr.getType())) {
                // Sanity checking
                if (expressionTree.size() < 2)
                    throw new IllegalStateException("A binary operator does not have enough operands");

                // This is a binary operator.
                // !Important. pop last child first because this is a stack.
                Expression child2 = expressionTree.pop();
                Expression child1 = expressionTree.pop();
                expressionTree.push(ExpressionFactory.createExpression(curr, child1, child2));

            }
            else {
                throw new IllegalStateException();
            }

        }
        if (expressionTree.size() == 1){
            // Success!
            return expressionTree.pop();
        }
        else {
            throw new IllegalStateException("Invalid postfix Expression");
        }
    }
}
