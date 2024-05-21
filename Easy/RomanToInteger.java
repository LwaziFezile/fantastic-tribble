package Easy;

import java.util.HashMap;

public class RomanToInteger {
    /**
     * Converts a Roman numeral string to an integer.
     *
     * @param s the Roman numeral string to convert
     * @return the integer value of the Roman numeral
     */
    public int romanToInt(String s) {
        // Create a HashMap to store Roman numeral characters and their corresponding integer values
        HashMap<Character, Integer> hashMap = new HashMap<>();
        // StringBuilder for potential use (not actually used in the final result)
        StringBuilder stringBuilder = new StringBuilder();
        // Initialize the year (result) to 0
        int year = 0;
        // Define Roman numeral characters
        char[] romanString = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        // Define corresponding integer values for Roman numerals
        int[] numbers = new int[]{1, 5, 10, 50, 100, 500, 1000};
        // Populate the HashMap with Roman numeral characters and their values
        for (int i = 0; i < romanString.length; i++) {
            hashMap.put(romanString[i], numbers[i]);
        }
        // Convert the input string to a character array
        char[] str = s.toCharArray();
        // Iterate through the characters of the string from the end to the beginning
        for (int i = str.length - 1; i >= 0; i--) {
            stringBuilder.append(str[i]);
            // Check if there is a preceding character
            if (i - 1 > -1) {
                // Get the integer values for the current and preceding characters
                int minus = hashMap.get(str[i - 1]);
                int current = hashMap.get(str[i]);
                // If the preceding value is less than the current value, subtract it and adjust the index
                if (minus < current) {
                    year += (current - minus);
                    i = i - 1;
                } else {
                    // Otherwise, just add the current value to the year
                    year += hashMap.get(str[i]);
                }
            } else if (i == 0) {
                // If it's the first character, simply add its value
                year += hashMap.get(str[i]);
            }
            // Reset the StringBuilder (not actually necessary for the logic)
            stringBuilder = new StringBuilder();
        }
        // Return the resulting integer value
        return year;
    }
}
