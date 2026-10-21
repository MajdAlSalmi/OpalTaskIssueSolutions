package OpalTaskIssueSolutions;
public class DiamondTaskSolution {
    static void printSpaces(int counter){
        for(int i=0; i<counter; i++)
        System.out.print(" ".repeat(i));

    }
    static void printTriangle(int length){
    for(int i=0; i<length; i++){
   
            for(int spaces=length; spaces>i; spaces--){
                        System.out.print(" ");
            
            }
    
            for(int j=0; j<i+1; j++){
                                printSpaces(2);

                System.out.print("*");
                 

            }

          
        System.out.print("\n");
    }
    }

    
    static void printTriangleReverse(int length){
    for(int i=0; i<length; i++){
   
            for(int spaces=0; spaces<i+1; spaces++){
                        System.out.print(" ");
            
            }
    
            for(int j=length; j>i; j--){
                                                printSpaces(2);

                System.out.print("*");


                 

            }

          
        System.out.print("\n");
    }
    }







    
    
    public static void main(String[] args) {
    printTriangle(5);
        printTriangleReverse(5);
        
        // printTriangleInReverse(5);
    
    }
}
