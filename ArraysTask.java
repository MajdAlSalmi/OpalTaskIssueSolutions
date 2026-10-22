import java.util.Scanner;

public class ArraysTask {

    public static Scanner scInput = new Scanner(System.in);
     static clInputs readInput = new clInputs();

    static int arraySum(int arr[]) {

        int sum = 0;

        for (int arrayElements : arr) {
            sum += arrayElements;
        }

        return sum;
    }

    static double averageArray(int arr[], int size) {
        return arraySum(arr) / size;

    }

    static int findMax(int arr[]) {

        int maxElement = arr[0];

        for (int arrayElements : arr) {
            if (arrayElements > maxElement)
                maxElement = arrayElements;
        }

        return maxElement;
    }

    static int findMin(int arr[]) {

        int minElement = arr[0];

        for (int arrayElements : arr) {
            if (arrayElements < minElement)
                minElement = arrayElements;
        }

        return minElement;
    }

    static int countEven(int arr[]) {

        int evenNumbersCount = 0;

        for (int arrayElements : arr) {
            if (arrayElements % 2 == 0)
                evenNumbersCount++;
        }

        return evenNumbersCount;

    }

    static int indexOf(int arr[], int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }

        return -1;

    }

    static int[] reverseArray(int originalArray[]) {

        int[] newArray = new int[originalArray.length];
        int counter = 0;

        for (int i = originalArray.length - 1; i > -1; i--) {
            newArray[counter] = originalArray[i];
            counter++;

        }

        return newArray;

    }

    static void printArray(int arr[]) {

        for (int arrayElements : arr) {
            System.out.print(arrayElements + " ");
        }
    }

    static int[] readGrades(int size) {

        int[] grades = new int[size];

        for (int i = 0; i < size; i++)

            grades[i] = readInput.readNumber("Enter grade " + (i + 1)+": ");

        return grades;

    }

    static int countPassed(int[] grades) {

        int passGradesCount = 0;

        for (int Grades : grades) {

            if (Grades >= 50)
                passGradesCount++;

        }

        return passGradesCount;

    }

    static void program(int number, int[] array) {

        switch (number) {

            case 1:
                System.out.println("Sum: " + arraySum(array));
                System.out.println("Average: " + averageArray(array,array.length));
                break;

            case 2: {
                System.out.println("Max: " + findMax(array));
                System.out.println("Min: " + findMin(array));
                System.out.println("Difference: " + (findMax(array) - findMin(array)));
            }
                break;

            case 3: {
                int readNumber = readInput.readNumber("Enter a number to search for: ");

                if (indexOf(array, readNumber) == -1)
                    System.out.println(readNumber + " not found");
                else
                    System.out.println(readNumber + " found at index " + indexOf(array, readNumber));

            }
                break;

            case 4: {

                System.out.print("Original: ");
                printArray(array);
System.out.println("");
                System.out.print("Reversed: ");
                printArray(reverseArray(array));

                break;
            }

            case 5: {

                int[] arr = readGrades(5);
                int countFailed = 0;
                System.out.println("Passed: " + countPassed(arr));

                for (int failedGradesArrayElement : arr) {

                    if (failedGradesArrayElement < 50)
                        countFailed++;
                }

                System.out.println("Failed: " + countFailed);

            }
                break;

            default:
                System.out.println("not within choices;");

        }

    }

    public static void main(String[] args) {

        int[] numbers = { 12, 7, 25, 3, 18, 9, 30, 14 };
        
//choose from 1-5 
        program(5, numbers);


    }



    static class clInputs {

    int readNumber(String prompt) {

        int number = 0;

        System.out.print(prompt);

        number = scInput.nextInt();

        return number;
    }

}
}



  