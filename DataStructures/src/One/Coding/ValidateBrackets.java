package One.Coding;

import java.util.Stack;

public class ValidateBrackets {
    public boolean isValidBrackets(String input){
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "{[]}";
        ValidateBrackets validateBrackets = new ValidateBrackets();
        boolean validBrackets = validateBrackets.isValidBrackets(input);
        System.out.println(validBrackets);
    }
}
