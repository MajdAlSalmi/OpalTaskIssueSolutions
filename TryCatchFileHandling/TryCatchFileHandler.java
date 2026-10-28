import java.io.*;
import java.util.Scanner;

public class TryCatchFileHandler {

    static String copyText = "";

    public static void main(String[] args) throws IOException {

        //if want to read the file content in the copied file. WRITE TRUE in the fileReaderParameter.

        FileReader(true);
        FileWriter();

    }

    private static void FileWriter() {

        try {

            BufferedWriter bwWriter = new BufferedWriter(new FileWriter("outputCOPY.txt", true));

            Scanner scInput = new Scanner(System.in);
            String readInput;

                bwWriter.write(copyText + "\n");

                        System.out.println("Text copied to outputCOPY.txt file successfully.");


            bwWriter.close();

        } catch (IOException e) {
            System.out.println("Error occurred while writing to the file: " + e.getMessage());


        }
    }

    private static void FileReader(boolean readFileContent) {

        try {

            BufferedReader brReader = new BufferedReader(new FileReader("testText.txt"));

            String readLine;
            while ((readLine = brReader.readLine()) != null) {
                copyText += readLine + "\n";

            }
            if(readFileContent) {
                System.out.println("Content of the file:");
                System.out.println(copyText);
            }
            brReader.close();

        } catch (IOException e) {
            System.out.println("Error occurred while reading the file: " + e.getMessage());
        }

    }
}
