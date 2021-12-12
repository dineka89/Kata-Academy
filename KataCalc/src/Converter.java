public class Converter {
    static Integer[] arabic = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    static String[] roman = {"XV", "XIV", "XIII", "XII", "XI", "X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};

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
}
