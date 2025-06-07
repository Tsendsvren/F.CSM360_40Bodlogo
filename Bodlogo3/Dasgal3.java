package Bodlogo3;

import java.util.*;

public class Dasgal3 {

    private static final String[] numbers = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
            "twenty",
            "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven",
            "twenty eight", "twenty nine"
    };

    public static String timeInWords(int h, int m) {
        if (m == 0) {
            return numbers[h] + " o' clock";
        } else if (m == 15) {
            return "quarter past " + numbers[h];
        } else if (m == 30) {
            return "half past " + numbers[h];
        } else if (m == 45) {
            return "quarter to " + numbers[h % 12 + 1];
        } else if (m <= 30) {
            return numbers[m] + (m == 1 ? " minute" : " minutes") + " past " + numbers[h];
        } else {
            return numbers[60 - m] + (60 - m == 1 ? " minute" : " minutes") + " to " + numbers[h % 12 + 1];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(timeInWords(h, m));
        scanner.close();
    }
}