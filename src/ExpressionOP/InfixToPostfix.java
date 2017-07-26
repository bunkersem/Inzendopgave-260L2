package ExpressionOP;

import ExpressionOP.Operations.Operation;
import ExpressionOP.Operations.OperationType;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Sem on 25-Jul-17.
 */
public class InfixToPostfix {
    public static ArrayList<Operation> convert(ArrayList<Operation> infixOperations) {

        Stack<Operation> postfix = new Stack<>();
        Stack<Operation> operators = new Stack<>();

        for (int i = 0; i < infixOperations.size(); i++) {
            Operation curr = infixOperations.get(i);

            if (curr.getType() == OperationType.VALUE) {
                // This is an operand.
                postfix.push(curr);
            }
            // Test if the current operation is of type "operator" by checking the Operator.operators List.
            else if (Arrays.asList(Operation.operators).contains(curr.getType())) {
                // This is an operator.

                // If The last pushed operator on the stack has a higher precedence.
                // It is important to resolve that situation.

                // Because if this new operator has a lower precedence than the last one on the stack.
                // We can pop any operator of the "operator" stack that has a higher precedence than the current one.

                // So as long as the curr operator has a lower precedence than  First lets pop all of the operators of of the "operators" stack and into the "postfix" stack.
                while (!operators.isEmpty() && operators.peek().getPrecedence() > curr.getPrecedence()) {
                    postfix.push(operators.pop());
                }

                // The operator stack is empty or the last operator on the stack has a lower precedence.
                // We can just push this operator on to the stack.
                operators.push(curr);

            }
            else {
                throw new IllegalStateException();
            }
        }
        // We processed the whole infix expression.
        // If we still have operators on the "operators" stack. Push them onto the postfix stack.
        while (!operators.isEmpty()) {
            postfix.push(operators.pop());
        }
        return new ArrayList<>(postfix);
    }
}
