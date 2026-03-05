class PalindromeChecker {

    public boolean checkPalindrome(String input, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (input.charAt(start) != input.charAt(end)) {
            return false;
        }

        return checkPalindrome(input, start + 1, end - 1);
    }
}

public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "a man a plan a canal panama";

        String lowerCaseInput = input.toLowerCase();
        String noSpace = lowerCaseInput.replaceAll("\\s", "");

        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(noSpace, 0, noSpace.length() - 1);

        System.out.println("UC11 Input: " + input);
        System.out.println("LowerCase converted Input: " + lowerCaseInput);
        System.out.println("NoSpace converted Input: " + noSpace);
        System.out.println("Palindrome: " + result + "\n");

    }
}
