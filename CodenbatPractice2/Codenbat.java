import java.util.Scanner;

public class Codenbat {

    static void printHollowSquare(int size) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static Scanner scInput=new Scanner(System.in);
    static int readNumber(String prompt){
        int number=0;
        System.out.print(prompt);
number=scInput.nextInt();

        return number;
        
    }


    static void printRepeatedNumberTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(i + 1);
            }
            System.out.println();
        }
    }

    
    
 static void printSpaces(int n){

       for(int k=n; k>0; k--)
                System.out.print(" ");
     
    }

 static void printReversedSpaces(int n){

       for(int k=0; k<n; k++)
                System.out.print(" ");
           
            
        
    }

    
 static void printHollowTriangle(int n) {
        for (int i = 0; i < n; i++) {
            printSpaces(n - i);

            for (int j = 0; j < i + 1; j++) {
                if( j==0 || j==i){
                System.out.print("*");
                            printReversedSpaces(i);

                
                }
                else
                System.out.print(" ");

                    
            }
            System.out.println();
        }

    }

     static void printHollowReversedTriangle(int n) {
        for (int i = 0; i < n; i++) {
                            printReversedSpaces(i);

            for (int j = n; j>0; j--) {
                if( j==n || j==i+1){
                System.out.print("*");
                    printSpaces(n-i);

                }
                else
                            System.out.print(" ");

                    
            }

            System.out.println();
        }

    }

    static void printHollowDiamond(int size){

        printHollowTriangle(size);
        printHollowReversedTriangle(size);
        
    }

    static void printDescendingAlphabetTriangle(int number){

        for(int i=0; i<=number; i++){
            for(int j=(65+5-1); j>=(65+number)-i; j--){
                System.out.print((char)j);
                
            }
            System.out.println();
        }
}
        
    static void printXPattern(int n) {
printHollowReversedTriangle(n);
        printHollowTriangle(n);
    }

    static void printOddNumberTriangle(int n){

        int number=1;
        for(int i=0; i<n; i++){
            for(int j=0; j<i+1; j++){
                System.out.print(number+" ");
                number+=2;
            }
            System.out.println();
        }
    }

static void printPlusSign(int n) {
        int mid = n / 2;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == mid || j == mid) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void printReversedNumberTriangle(int n){

        for(int i=n; i>0; i--){
            for( int j=0; j<i; j++)
                System.out.print((j+1)+" ");
            
            System.out.println();
        }
    }

static void printFullDiamond(int n) {
        // Upper half (including the middle widest row)
        for (int i = 0; i < n; i++) {
            // Print leading spaces
            for (int j = 0; j < n - i - 1; j++) {
                  System.out.print(" "); // standard print
            }
            // Print stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half
        for (int i = n - 2; i >= 0; i--) {
            // Print leading spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    static void printHourglass(int n) {
        // Upper half (Inverted triangle)
        for (int i = 0; i < n; i++) {
            // Print leading spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int j = 0; j < 2 * (n - i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half (Regular triangle, starting from i = 1 to avoid duplicating the middle row)
        for (int i = 1; i < n; i++) {
            // Print leading spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {

        printHollowSquare(readNumber("Enter the size of the square: "));
        printRepeatedNumberTriangle(readNumber("Enter the number of rows for the repeated number triangle: "));
        printReversedNumberTriangle(readNumber("Enter number of rows for repeated reversed Triangle:"));
        printFullDiamond(readNumber("Enter diamond size: "));
        printHollowDiamond(readNumber("Enter hollow diamond size: "));
        printXPattern(readNumber("Enter X pattern size: "));
        printHourglass(readNumber("Enter hour glass sign:"));
        printDescendingAlphabetTriangle(readNumber("Enter Descending Alphabet Triangle: "));
        printOddNumberTriangle(readNumber("Enter odd number Triangle:"));
        printPlusSign(readNumber("Enter plus Sign size:"));



        

    }
}