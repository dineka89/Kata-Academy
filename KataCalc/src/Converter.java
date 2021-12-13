import java.util.LinkedHashMap;
import java.util.Map;

public class Converter {
    static Integer[] arabic = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    static String[] roman = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};

    public static String convertArabicToRoman(int a) {
        String result = "";
        for (int i = 0; i < arabic.length; i++) {
            if (arabic[i] == a) {
                result = roman[i];
            }
        }
        return result;
    }

    public static int convertRomanToArabic(String a) {
        int result = -1;
        for (int i = 0; i < roman.length; i++) {
            if (roman[i].equalsIgnoreCase(a)) {
                result = arabic[i];
            }
        }
        return result;
    }

    public static String RomanNumerals(int Int) {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
        roman_numerals.put("M", 1000);
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String res = "";
        for(Map.Entry<String, Integer> entry : roman_numerals.entrySet()){
            int matches = Int/entry.getValue();
            res += repeat(entry.getKey(), matches);
            Int = Int % entry.getValue();
        }
        return res;
    }
    public static String repeat(String s, int n) {
        if(s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}
