import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String input = bufferedReader.readLine();

        String sum = calc(input);

        System.out.println(sum);

    }

    private static String calc(String input) throws Exception {
        String[] signs = input.split(" ");

        if (signs.length != 3) {
            throw new Exception();
        }

        Integer sum = 0;
        Integer value1 = 0;
        Integer value2 = 0;
        Boolean isFirstNumberArabic = false;
        Boolean isFirstNumberTranslated = false;
        Boolean isSecondNumberArabic = false;
        Boolean isSecondNumberTranslated = false;
        Boolean isSignTranslated = false;

        switch (signs[0]) {
            case "I": {
                value1 = 1;
                isFirstNumberTranslated = true;
                break;
            }
            case "II": {
                value1 = 2;
                isFirstNumberTranslated = true;
                break;
            }
            case "III": {
                value1 = 3;
                isFirstNumberTranslated = true;
                break;
            }
            case "IV": {
                value1 = 4;
                isFirstNumberTranslated = true;
                break;
            }
            case "V": {
                value1 = 5;
                isFirstNumberTranslated = true;
                break;
            }
            case "VI": {
                value1 = 6;
                isFirstNumberTranslated = true;
                break;
            }
            case "VII": {
                value1 = 7;
                isFirstNumberTranslated = true;
                break;
            }
            case "VIII": {
                value1 = 8;
                isFirstNumberTranslated = true;
                break;
            }
            case "IX": {
                value1 = 9;
                isFirstNumberTranslated = true;
                break;
            }
            case "X": {
                value1 = 10;
                isFirstNumberTranslated = true;
                break;
            }
            default: {
                isFirstNumberArabic = true;
                break;
            }
        }

        if (isFirstNumberArabic) {
            try {
                value1 = Integer.valueOf(signs[0]);
                isFirstNumberTranslated = true;
            } catch (Exception e) {

            }
            if (value1 > 10 || value1 < 1)
                throw new Exception();
        }

        switch (signs[2]) {
            case "I": {
                value2 = 1;
                isSecondNumberTranslated = true;
                break;
            }
            case "II": {
                value2 = 2;
                isSecondNumberTranslated = true;
                break;
            }
            case "III": {
                value2 = 3;
                isSecondNumberTranslated = true;
                break;
            }
            case "IV": {
                value2 = 4;
                isSecondNumberTranslated = true;
                break;
            }
            case "V": {
                value2 = 5;
                isSecondNumberTranslated = true;
                break;
            }
            case "VI": {
                value2 = 6;
                isSecondNumberTranslated = true;
                break;
            }
            case "VII": {
                value2 = 7;
                isSecondNumberTranslated = true;
                break;
            }
            case "VIII": {
                value2 = 8;
                isSecondNumberTranslated = true;
                break;
            }
            case "IX": {
                value2 = 9;
                isSecondNumberTranslated = true;
                break;
            }
            case "X": {
                value2 = 10;
                isSecondNumberTranslated = true;
                break;
            }
            default: {
                isSecondNumberArabic = true;
                break;
            }
        }

        if (isSecondNumberArabic) {
            try {
                value2 = Integer.valueOf(signs[2]);
                isSecondNumberTranslated = true;
            } catch (Exception e) {

            }
            if (value2 > 10 || value2 < 1)
                throw new Exception();
        }

        switch (signs[1]) {
            case "-": {
                sum = value1 - value2;
                isSignTranslated = true;
                break;
            }
            case "+": {
                sum = value1 + value2;
                isSignTranslated = true;
                break;
            }
            case "*": {
                sum = value1 * value2;
                isSignTranslated = true;
                break;
            }
            case "/": {
                sum = value1 / value2;
                isSignTranslated = true;
                break;
            }
            default: {
                break;
            }
        }
        if (!isFirstNumberTranslated || !isSecondNumberTranslated || !isSignTranslated)
        throw new Exception();

        if (!isFirstNumberArabic && !isSecondNumberArabic && sum <= 0) {
            throw new Exception();
        }

        if ((isFirstNumberArabic && !isSecondNumberArabic) || (!isFirstNumberArabic && isSecondNumberArabic))
            throw new Exception();

        if (isFirstNumberArabic && isSecondNumberArabic)
            return sum.toString();
        else {
            String result = new String();
            int m = sum / 1000;
            sum %= 1000;
            for (int i = 0; i < m; i++) {
                result += "M";
            }

            int d = sum / 500;
            sum %= 500;
            for (int i = 0; i < d; i++) {
                result += "D";
            }

            int c = sum / 100;
            sum %= 100;
            if (c == 4) {
                result += "CD";
            }
            else {
                for (int i = 0; i < c; i++) {
                    result += "C";
                }
            }

            int l = sum / 50;
            sum %= 50;
            for (int i = 0; i < l; i++) {
                result += "L";
            }

            int x = sum / 10;
            sum %= 10;
            if (x == 4) {
                result += "XL";
            }
            else {
                for (int i = 0; i < x; i++) {
                    result += "X";
                }
            }

            int v = sum / 5;
            sum %= 5;
            for (int i = 0; i < v; i++) {
                result += "V";
            }

            int i = sum;
            if (i == 4) {
                result += "IV";
            }
            else {
                for (int j = 0; j < i; j++) {
                    result += "I";
                }
            }
            return result;
        }
    }
}