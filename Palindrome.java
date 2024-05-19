public class Palindrome {
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        StringBuilder reverseStr = new StringBuilder(str).reverse();
        String reverse = reverseStr.toString();
        return str.equals(reverse);
    }
}
