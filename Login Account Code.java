import java.util.Scanner;
import java.util.Date;
public class bankLogin {
    // Just to keep tracks of all Accounts
    static int TotalAccountsLogged;
    static int option;
    static String Enter;
    // Bank properties
    long DepositInput;
    long WithdrawInput;
    String AccountHolder;
    String AccountNumber;
    long TotalBalance;
    long ErrorAmount;
    public long CurrentAmount;
    Scanner input = new Scanner(System.in);
    public bankLogin(long amount, String number){        
    CurrentAmount = amount;
    ErrorAmount = amount;
    AccountNumber = number;
    }
    public void MainMenu() {
        System.out.println(
                "Main Menu\n1.Deposit Money\n2.Withdarw\n3.Check your Balance\n4.Generate your Receipt\n5.Exit\nEnter you choice?");
        option = input.nextInt();
        if (option == 1) {
            input.nextLine();// Consumes the \n
            System.out.println("Press Enter to move to Deposit Section");
            input.nextLine();
            Deposit();
        } else if (option == 2) {
            input.nextLine();// Consumes the \n
            System.out.println("Press Enter to move to Withdraw Section");
            input.nextLine();
            Withdraw();
        } else if (option == 3) {
            input.nextLine();// Consumes the \n
            System.out.println("Press Enter to move to Check Balance Section");
            input.nextLine();
            TotalBalance();
        } else if (option == 4) {
            input.nextLine();// Consumes the \n
            System.out.println("Press Enter to move to Generate Receipt Section");
            input.nextLine();
            Receipt();

        } else if (option == 5) {
            System.out.println("Thanks for using our bank");
        } else {
            System.out.println("Warning : Incorrect Input");
            MainMenu();
        }
    }

    public void Deposit() {
        String choice;
        System.out.println("Welcome to Deposit Section :");
        System.out.println("Enter total amount you want to deposit : ");
        DepositInput = input.nextInt();
        CurrentAmount += DepositInput;
        System.out.println("Successfully Deposited : " + DepositInput);
        System.out.println("Do you want to Generate Receipt? Yes or No?");
        choice = input.next();
        if (choice.equals("Yes")) {
            Receipt();
            System.out.println("Total amount Deposited : " + DepositInput);
            input.nextLine();// Consumes the \n
            System.out.println("Press Enter to move to Main Menu");
            input.nextLine();
            MainMenu();
        } else if (choice.equals("No")) {
            input.nextLine();// Consumes the \n
            System.out.println("Press Enter to move to Main Menu");
            input.nextLine();
            MainMenu();
        } else {
            System.out.println("Warning : Wrong Input ! Choose Again !");
            CurrentAmount = ErrorAmount;
            MainMenu();
        }
    }

    public void Withdraw() {
        String choice;
        System.out.println("Welcome to Withdraw Section :");
        System.out.println("Enter total amount you want to Withdraw : ");
        WithdrawInput = input.nextInt();
        CurrentAmount -= WithdrawInput;
        System.out.println("Successfully Withdrawn : " + WithdrawInput);
        System.out.println("Do you want to Generate Receipt? Yes or No?");
        choice = input.next();
        if (choice.equals("Yes")) {
            Receipt();
            System.out.println("Total amount withdrawn : " + WithdrawInput);
            input.nextLine();// Consumes the \n
            System.out.println("Press Enter to move to Main Menu");
            input.nextLine();
            MainMenu();
        } else if (choice.equals("No")) {
            input.nextLine();// Consumes the \n
            System.out.println("Press Enter to move to Main Menu");
            input.nextLine();
            MainMenu();
        } else {
            System.out.println("Warning : Wrong Input ! Choose Again !");
            CurrentAmount = ErrorAmount;
            MainMenu();
        }
    }

    public void AccountHolder() {
        System.out.println("Enter your name :");
        AccountHolder = input.nextLine();
        System.out.println("Enter your Account Password:");
        AccountNumber = input.next();
        TotalAccountsLogged();
        MainMenu();
    }

    public void TotalBalance() {
        System.out.println("Welcome to Check Balance Section :");
        System.out.println("Name : " + AccountHolder);
        System.out.println("Account Number : " + AccountNumber);
        System.out.println("Total Amount : " + CurrentAmount);
        System.out.println("Press Enter to move to Main Menu");
        input.nextLine();
        MainMenu();
    }

    public void Receipt() {
        Date time = new Date();
        System.out.println("Receipt Successfully generated");
        System.out.println("Receipt");
        System.out.println("Account Number : " + AccountNumber);
        System.out.println("Current Amount : " + CurrentAmount);
        System.out.println("Date : " + time);
        System.out.println("Press Enter to move to Main Menu");
        input.nextLine();
        MainMenu();
    }

    private void TotalAccountsLogged() {
        TotalAccountsLogged++;
    }
}
