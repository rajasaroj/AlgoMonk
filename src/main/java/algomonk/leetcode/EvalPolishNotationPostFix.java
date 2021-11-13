package algomonk.leetcode;

import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class EvalPolishNotationPostFix {

    public static void main(String[] args) {
        //String[] tokens = new String[] {"2","1","+","3","*"};
        String[] tokens = new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(new EvalPolishNotationPostFix().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            if(tokens[i].matches("-?[0-9]+")) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int secondOperand = stack.pop();
                int firstOperand = stack.pop();
                int result = eval(firstOperand, tokens[i], secondOperand);
                stack.push(result);
            }

        }
        return stack.pop();
    }

    public int eval(int firstOperand, String operator, int secondOperand) {
        switch (operator) {
            case "+":
               return   firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                return firstOperand / secondOperand;
            default:
                return 0;
        }
    }
}
