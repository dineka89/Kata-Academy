import java.io.IOException;
import java.util.Scanner;

public class Main {
    static boolean romanNum;

    public static void main(String[] args) throws Exception {
        evaluate();
    }

    //Метод обработчик
    private static void evaluate() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пример");
        String[] values = scanner.nextLine().split(" ");

        if (values.length < 3) {
            throw new Exception("строка не является математической операцией");
        } else if (values.length > 3) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        String type = values[1];
        String a = values[0];
        String b = values[2];

        if ((a.chars().allMatch(Character::isDigit)) && (b.chars().allMatch(Character::isDigit))) {
            int localA = Integer.parseInt(a);
            int localB = Integer.parseInt(b);
            if (!((localA > 0 && localA <= 10) && (localB > 0 && localB <= 10))) {
                throw new IOException("Incorrect value");
            }
            System.out.println("Результат: " + count(Integer.parseInt(a), Integer.parseInt(b), type));
        } else {
            romanNum = true;
            int localA = Converter.convertRomanToArabic(a);
            int localB = Converter.convertRomanToArabic(b);

            if (!((localA > 0 && localA <= 10) && (localB > 0 && localB <= 10))) {
                throw new IOException("Incorrect value");
            }
            int result = count(localA, localB, type);
            System.out.println("Результат: " + Converter.convertArabicToRoman(result));
        }
        System.out.println("Continue? Y/N");

        if (scanner.next().equalsIgnoreCase("Y")) {
            evaluate();
        } else {
            System.out.println("good bye!");
        }
    }

    //Метод для расчёта
    private static int count(int a, int b, String type) throws IOException {
        int result = 0;
        switch (type) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new IOException("Incorrect type!");
        }
        if (romanNum && result < 1) {
            throw new ArithmeticException();
        }

        return result;
    }
}
