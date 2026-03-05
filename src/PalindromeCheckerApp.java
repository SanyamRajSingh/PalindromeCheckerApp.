import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String reversed = "";

        while(!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return input.equals(reversed);
    }
}

class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for(int i = 0; i < input.length(); i++) {
            deque.add(input.charAt(i));
        }

        while(deque.size() > 1) {

            char first = deque.removeFirst();
            char last = deque.removeLast();

            if(first != last) {
                return false;
            }
        }

        return true;
    }
}

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "a man a plan a canal panama";

        String lowerCaseInput = input.toLowerCase();
        String noSpace = lowerCaseInput.replaceAll("\\s","");

        PalindromeStrategy strategy;

        strategy = new StackStrategy();

        boolean stackResult = strategy.checkPalindrome(noSpace);

        strategy = new DequeStrategy();

        boolean dequeResult = strategy.checkPalindrome(noSpace);

        System.out.println("UC12 Input: " + input);
        System.out.println("LowerCase converted Input: " + lowerCaseInput);
        System.out.println("NoSpace converted Input: " + noSpace);
        System.out.println("Stack Strategy Palindrome: " + stackResult);
        System.out.println("Deque Strategy Palindrome: " + dequeResult + "\n");

    }
}
