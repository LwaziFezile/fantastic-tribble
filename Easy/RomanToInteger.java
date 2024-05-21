package Easy;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        int year = 0;
        char[] romanString = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] numbers = new int[]{1, 5, 10, 50, 100, 500, 1000};
        for (int i = 0; i < romanString.length; i++) {
            hashMap.put(romanString[i], numbers[i]);
        }
        char[] str = s.toCharArray();
        for (int i = str.length - 1; i >= 0; i--) {
            stringBuilder.append(str[i]);
            if (i-1 > -1){
                int minus = hashMap.get(str[i-1]);
                int current = hashMap.get(str[i]);
                if (minus < current){
                    year += (current - minus);
                    i = i - 1;
                }else{
                    year += hashMap.get(str[i]);
                }
            } else if (i == 0) {
                year += hashMap.get(str[i]);
            }
            stringBuilder = new StringBuilder();
        }
        return year;
    }
}
