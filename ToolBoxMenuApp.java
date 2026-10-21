package OpalTaskIssueSolutions;
import java.util.Scanner;

public class ToolBoxMenuApp {

    static clPrime primeNumber = new clPrime();

    static Scanner scInput = new Scanner(System.in);

    static float readFloatNumber(String prompt) {

        float number = 0;

        System.out.println(prompt);

        number = scInput.nextFloat();

        return number;

    }

    static int readNumber(String prompt) {

        int number = 0;

        System.out.println(prompt);

        number = scInput.nextInt();

        return number;
    }

    static float temperatureToFahrenheit(float celsius) {

        float TemperatureInFahrenheit = (celsius * 9 / 5) + 32;
        return TemperatureInFahrenheit;
    }

    static String oddEven(int number) {

        if (number % 2 == 0)
            return "Number is even";
        else
            return "Number is odd";
    }

    static int maxOfThree(int num1, int num2, int num3) {

        if (num1 > num2 && num1 > num3)
            return num1;

        else if (num2 > num1 && num2 > num3)
            return num2;

        else
            return num3;

    }

    static void factorial(int number) {

        int factorialNumber = 1;
        for (int i = number; i >= 1; i--) {
            factorialNumber *= i;
        }
        System.out.println(number + "!" + " = " + factorialNumber);
    }

    static void multiplicationTable(int number) {

        for (int row = 1; row <=10; row++) {

                System.out.print(number + "*" + row + "=" + number * row + " ");

        System.out.println("\n");

            
        }

    }

    static void starTriangle(int rows) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println("\n");
        }
    }

    static String isPrimeNumber(int number) {
        if (primeNumber.isNoRemainder(number))
            return number + " is prime";

        return number + " is not prime";
    }

    static void reverseNumber(int number) {

        int numberReversed = 0;
        numberReversed = number % 10;

        while (number > 0) {

            number /= 10;
            numberReversed = (numberReversed * 10) + (number % 10);

        }

        numberReversed /= 10;
        System.out.println("ReversedNumber " + numberReversed);

    }

    static void numberPyramid(int number) {

        for (int i = 0; i < number; i++) {
            for (int j = 1; j <= i + 1; j++) {

                System.out.print(j);

            }
            System.out.println("\n");
        }

    }

    static void program() {
        System.out.println("\n\n");

        int choice = 0;

        do {

            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Even or odd");
            System.out.println("3. Maximum of three numbers");
            System.out.println("4. Factorial");
            System.out.println("5. Multiplication table");
            System.out.println("6. Triangle of stars");
            System.out.println("7. Prime check");
            System.out.println("8. Reverse a number");
            System.out.println("9. Number pyramid");
            System.out.println("0. Exit");

            choice = readNumber("Please enter a number between 0 and 9: ");

            switch (choice) {
                case 1:
                    System.out.println(temperatureToFahrenheit(readFloatNumber("Enter temperature in celsius")));
                    break;

                case 2:
                    System.out.println(oddEven(readNumber("Enter a number to check if odd or even:")));
                    break;

                case 3:
                    System.out.println(maxOfThree(readNumber("Enter number 1:"), readNumber("Enter number 2:"),
                            readNumber("Enter number 3:")));
                    break;

                case 4:
                    factorial(readNumber("Enter a non-negative number:"));
                    break;

                case 5:
                    multiplicationTable(readNumber("Enter a number: "));
                    break;

                case 6:
                    starTriangle(readNumber("Enter number of rows:"));
                    break;

                case 7:
                    System.out.println(isPrimeNumber(readNumber("Enter a number:")));
                    break;

                case 8:
                    reverseNumber(readNumber("Enter a number: "));
                    break;

                case 9:
                    numberPyramid(readNumber("Enter number of rows:"));
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Not within available choices:");

            }

        } while (true);

    }

    public static void main(String[] args) {

        program();

    }

}

class clPrime {

    public boolean isNoRemainder(int number) {

        if (number == 1 || number == 2)
            return true;
        else {

            for (int i = 2; i < number; i++) {
                if (number % i == 0)
                    return false;
            }

        }

        return true;

    }

}