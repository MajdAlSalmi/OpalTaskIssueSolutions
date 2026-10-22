import java.util.Scanner;

public class AtmProject {

    static Scanner scInput = new Scanner(System.in);
    static int tries = 3;
    static clAtmInfo atmInfo = new clAtmInfo();

    static void defaultCheckForInterestRate() {

        if (atmInfo.balance < 1000) {
            atmInfo.tier = 1.0 / 100;
        } else if (atmInfo.balance >= 1000 && atmInfo.balance <= 5000) {
            atmInfo.tier = 2.0 / 100;

        } else if (atmInfo.balance >= 5000 && atmInfo.balance <= 20000) {
            atmInfo.tier = 3.0 / 100;

        } else if (atmInfo.balance >= 20000) {
            atmInfo.tier = 4.0 / 100;

        }

    }

    static int readNumber(String prompt) {

        int number = 0;

        System.out.println(prompt);

        number = scInput.nextInt();

        return number;
    }

    static String readText(String prompt) {

        String text;

        System.out.println(prompt);
        text = scInput.nextLine();

        return text;

    }

    static float readFloatNumber(String prompt) {

        float number = 0;

        System.out.println(prompt);

        number = scInput.nextFloat();

        return number;

    }

    static boolean isPinCorrect(int pinNumber) {

        return pinNumber == atmInfo.pin;
    }

    void printTriesNumber(int tries) {
        System.out.println(tries + " tries left");
    }

    static void deposit(double AmountToDeposit) {

        if (AmountToDeposit > 0 && AmountToDeposit <= 5000) {
            atmInfo.depositCounts++;
            atmInfo.depositTotal += AmountToDeposit;

            atmInfo.balance += AmountToDeposit;
            System.out.println("Deposit successful. Balance: "+atmInfo.balance);
        }

        else
            System.out.println("Amount must be greater than 0 and not more than 5000");

    }

    static void withDraw(double AmountToWithdraw) {

        if (AmountToWithdraw > 0 && (AmountToWithdraw % 10 == 0)) {

            if (atmInfo.sessionTotal < 1000) {
                atmInfo.withdrawCounts++;
                atmInfo.withDrawTotal += AmountToWithdraw;
                atmInfo.sessionTotal += AmountToWithdraw;
                if (AmountToWithdraw >= 1 && AmountToWithdraw <= 500){                    atmInfo.balance -= (AmountToWithdraw + 2.00);
  System.out.println("Fee: "+atmInfo.tier);
                                System.out.println("Withdrawal successful. Balance: "+atmInfo.balance);
                }
                else{
                    atmInfo.balance -= (AmountToWithdraw + 5.00);

                        System.out.println("Fee: "+atmInfo.tier);
                                System.out.println("Withdrawal successful. Balance: "+atmInfo.balance);

                }
            } else {
                System.out.println("Your withdraw session has reached the limit of 1000");
            }
        } else {
            System.out.println("Amount with drawn can be within a multiple of 10");
        }

    }

    static void accountTier() {

        if (atmInfo.balance < 1000) {
            System.out.println("Tier: " + "Bronze" + ", interest rate: " + "1%");
            atmInfo.tier = .0 / 100;

        } else if (atmInfo.balance >= 1000 && atmInfo.balance <= 5000) {
            System.out.println("Tier: " + "Silver" + ", interest rate: " + "2%");

        } else if (atmInfo.balance >= 5000 && atmInfo.balance <= 20000) {
            System.out.println("Tier: " + "Gold" + ", interest rate: " + "3%");

        } else if (atmInfo.balance >= 20000) {
            System.out.println("Tier: " + "Platinum" + ", interest rate: " + "4%");

        }

    }

    static void checkBalance() {
        System.out.println("Current balance is: " + atmInfo.balance);
    }

    static void SavingsProjection(int years) {

        double CurrentBalance = atmInfo.balance;
        if (years >= 1 && years <= 10) {
            for (int i = 0; i < years; i++) {
                // Year 1: 1221.96
                CurrentBalance += (atmInfo.balance * atmInfo.tier);
                System.out.println("Year " + (i + 1) + ": " + CurrentBalance);

            }
        } else {
            System.out.println("Years must be within the range of 1 to 10 only");

        }

    }

    static void receiptSummary() {

        System.out.println("Deposits: " + atmInfo.depositCounts + ", total: " + atmInfo.depositTotal);
        System.out.println("Withdrawals: " + atmInfo.withdrawCounts + ", total: " + atmInfo.withDrawTotal);
        System.out.println("Balance: " + atmInfo.balance);

    }

    static void changePin(int OldPin) {

        int newPin = 0;
        String confirmation;
        if (isPinCorrect(OldPin)) {

            newPin = readNumber("Enter your new pin. MUST BE ONLY WITHIN THE DIGITS OF 4");

            if (newPin >= 1000 && newPin <= 9999) {
                scInput.nextLine();
                confirmation = readText("Are you sure you want the new pin?:");
                if (confirmation.equals("y")){
                 
                    atmInfo.pin = newPin;
                System.out.println("new pin: "+atmInfo.pin);
                }
                else
                    return;
            } else {
                System.out.println("Pin exceeded 4 digits");
            }
        } else
            System.out.println("Pin in incorrect");

    }

    static void menu() {
        defaultCheckForInterestRate();

        int choice = 0;
        do {
            System.out.println("\n");

            System.out.println("1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Account tier");
            System.out.println("5. Savings projection");
            System.out.println("6. Receipt summary");
            System.out.println("7. Change PIN");
            System.out.println("0. Exit");
            choice = readNumber("\nChoose: ");

            switch (choice) {

               

                case 1:
                    checkBalance();
                    break;

                case 2: {
                    deposit(readFloatNumber("Enter an amount to deposit: "));

                }
                    break;

                case 3: {
                    withDraw(readFloatNumber("Enter amount to withdraw: "));

                }
                    break;

                case 4:
                    accountTier();
                    break;

                case 5:
                    SavingsProjection(readNumber("Enter number of years: "));
                    break;

                case 6:
                    receiptSummary();
                    break;

                case 7:
                    changePin(readNumber("Enter your old pin"));
                    break;

                    case 0:{
                        System.out.println("Goodbye");
                        return;

                    }
                default:
                    System.out.println("Not a valid choice\n\n\n\n");

            }

        } while (true);

    }

    public static void main(String[] args) {

        int PinCheck = 0;
        boolean openMenu = false;

        while (tries > 0) {
            PinCheck = readNumber("Enter your pin:");
            if (!isPinCorrect(PinCheck)){
                tries--;
            System.out.println("Wrong PIN. Attempts left: "+tries);
            }
            else {
                openMenu = true;
                break;
            }

        }

        if (openMenu){
         System.out.println("Welcome!\n\n");
            menu();
        }

    }

    static class clAtmInfo {

        static double balance = 1000.00;
        static int pin = 1234;
        static int depositCounts = 0;
        static double depositTotal = 0;

        static int withdrawCounts = 0;
        static double withDrawTotal = 0;

        static double tier = 0.0;
        double sessionTotal;

    }

}
