package CustomerFeedbacckPortal;

import java.util.Scanner;
import java.io.*;

public class FeedbackPortal {

    static Scanner scInput = new Scanner(System.in);

    static BufferedWriter bwFeedbackWriter;
    static BufferedReader bwFeedbackReader;
    static String[] names = new String[100];
    static int[] ratings = new int[5];
    static String[] comments = new String[100];
    static int count = 0;

    static void loadFeedbackFromFile() {
        String line;

        try {
            bwFeedbackReader = new BufferedReader(new FileReader("feedback.txt"));
            while ((line = bwFeedbackReader.readLine()) != null) {
                String[] parts = line.split("\\|");
                names[count] = parts[0];
                ratings[count] = Integer.parseInt(parts[1]);
                comments[count] = parts[2];
                count++;
            }
            bwFeedbackReader.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void searchByRating(int ratingValue) {

        try {
            for (int i = 0; i < count; i++) {

                if (ratings[i] == ratingValue) {

                    System.out.println(names[i] + " | " + ratings[i] + " | " + comments[i]);

                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    static void deleteFeedback(int index) {

        try {
            if (index < 0 || index >= count) {
                System.out.println("Invalid index");
                return;
            }

            for (int i = index; i < count - 1; i++) {

                names[i] = names[i + 1]; // taking the next element and putting it in the current index
                ratings[i] = ratings[i + 1];
                comments[i] = comments[i + 1];

            }
            names[count - 1] = null; // removing the last element
            ratings[count - 1] = 0;
            comments[count - 1] = null;

            count--;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    static void showAverageRating() {

        try {

            int sum = 0;
            for (int i = 0; i < count; i++) {
                sum += ratings[i];
            }
            int average = sum / count;
            System.out.println("Average rating: " + average);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    static void showAllFeedbacks() {

        try {
            
            for (int i = 0; i < count; i++)
                System.out.println(names[i] + " | " + ratings[i] + " | " + comments[i]);
                

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    static void saveFeedbackToFile() {
        try {
            bwFeedbackWriter = new BufferedWriter(new FileWriter("feedback.txt"));
            for (int i = 0; i < count; i++) {
                bwFeedbackWriter.write(names[i] + "|" + ratings[i] + "|" + comments[i]);
                bwFeedbackWriter.newLine();
            }
            bwFeedbackWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void addFeedback() {

        try {

            System.out.println("Enter your name:");
            String name = scInput.next();
            int rating;

            do {

                System.out.println("Enter your rating (1-5):");
                rating = scInput.nextInt();
            } while (rating < 1 || rating > 5);

            scInput.nextLine(); // Consume the newline character
            System.out.println("Enter your comment:");
            String comment = scInput.nextLine();
            names[count] = name;
            ratings[count] = rating;
            comments[count] = comment;
            count++;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    static void showMenu() {
        try {
            System.out.println("===== CUSTOMER FEEDBACK PORTAL =====");
            System.out.println("1. Add feedback");
            System.out.println("2. Show all feedback");
            System.out.println("3. Show average rating");
            System.out.println("4. Search by rating");
            System.out.println("5. Delete feedback");
            System.out.println("6. Load feedback");
            System.out.println("7. Save to file");
            System.out.println("8. Save and exit");
            System.out.print("Choose: ");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void main(String[] args) {

        short choice = 0;
        do {

            try {

                showMenu();
                choice = scInput.nextShort();

                switch (choice) {
                    case 1: {
                        addFeedback();
                    }
                        break;

                    case 2:
                        showAllFeedbacks();
                        break;

                    case 3:
                        showAverageRating();
                        break;

                    case 4: {
                        System.out.println("Enter rating to search for:");
                        int ratingValue = scInput.nextInt();
                        searchByRating(ratingValue);
                    }
                        break;

                    case 5: {
                        short index = 0;
                        for (int i = 0; i < count; i++) {
                            System.out.println((i + 1) + ". " + names[i] + " | " + ratings[i] + " | " + comments[i]);
                        }

                        System.out.println("\nEnter index of feedback to delete:");
                        index = scInput.nextShort();
                        deleteFeedback(index);
                    }
                        break;

                    case 6:
                        loadFeedbackFromFile();
                        break;

                    case 7:
                        saveFeedbackToFile();
                        break;

                    case 8: {
                        saveFeedbackToFile();
                        System.out.println("Goodbye");
                        return;
                    }

                    default:
                        System.out.println("Not a valid choice\n\n\n\n");
                }

            } catch (Exception e) {
                System.out.println("Erro : " + e.getMessage());
                scInput.nextLine(); // Consume the newline character
            }

        } while (true);
    }
}
