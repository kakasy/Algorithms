package exercises;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Parenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String string = reader.readLine();
        System.out.println(check(string));
    }

    private static boolean check(String string) {

        Stack<Character> stack = new Stack();

        for (int i = 0; i < string.length(); i++) {

            char current = string.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if (current == ')' || current == '}' || current == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
            }
            char last = stack.peek();
            if (current == ')' && last == '(' || current == '}' && last == '{' ||
                    current == ']' && last == '[') {
                stack.pop();
            }
        }
        return stack.size() == 0;
    }
}
