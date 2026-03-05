import java.util.Stack;

public class UseCase13PalindromeCheckerApp {

    public static boolean recursivePalindrome(String input, int start, int end) {

        if(start >= end) {
            return true;
        }

        if(input.charAt(start) != input.charAt(end)) {
            return false;
        }

        return recursivePalindrome(input, start + 1, end - 1);
    }

    public static boolean stackPalindrome(String input) {

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

    public static void main(String[] args) {

        String input = "a man a plan a canal panama";

        String lowerCaseInput = input.toLowerCase();
        String noSpace = lowerCaseInput.replaceAll("\\s", "");

        long startTime1 = System.nanoTime();
        boolean recursiveResult = recursivePalindrome(noSpace, 0, noSpace.length() - 1);
        long endTime1 = System.nanoTime();

        long startTime2 = System.nanoTime();
        boolean stackResult = stackPalindrome(noSpace);
        long endTime2 = System.nanoTime();

        long recursiveTime = endTime1 - startTime1;
        long stackTime = endTime2 - startTime2;

        System.out.println("UC13 Input: " + input);
        System.out.println("LowerCase converted Input: " + lowerCaseInput);
        System.out.println("NoSpace converted Input: " + noSpace);
        System.out.println("Recursive Palindrome: " + recursiveResult);
        System.out.println("Stack Palindrome: " + stackResult);
        System.out.println("Recursive Execution Time: " + recursiveTime + " ns");
        System.out.println("Stack Execution Time: " + stackTime + " ns");

    }
}
