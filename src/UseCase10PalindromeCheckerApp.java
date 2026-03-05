public class UseCase10PalindromeCheckerApp {



    public static boolean isPalindrome(String input, int start,int end){
        if(start >= end) {
            return true;
        }
        if(input.charAt(start) != input.charAt(end)) {
            return false;
        }

        return isPalindrome(input, start+1, end-1);
    }

    public static void main(String[] args) {

        String input = "a man a plan a canal panama";
        String lowerCaseInput = input.toLowerCase();
        String noSpace = input.replaceAll("\\s", "");

        boolean result = isPalindrome(noSpace, 0, noSpace.length()-1);

        System.out.println("UC10 Input: " + input);
        System.out.println("LowerCase converted Input: " + lowerCaseInput);
        System.out.println("NoSpace converted Input: " + noSpace);
        System.out.println("Palindrome: " + result + "\n");

    }
}

