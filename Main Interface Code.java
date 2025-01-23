
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class mainBank {
    public static void main(String[] args) {
        int SelectedOption;
        String AccountCreated;
        Scanner input = new Scanner(System.in);

        System.out.println("1.Login to your Account\n2.Create your Account");
        System.out.println("Enter your choice : ");
        SelectedOption = input.nextInt();
        input.nextLine();// Consumes the \n
        System.out.println("Press Enter to continue...");
        input.nextLine();
        if (SelectedOption == 1) {
            bankLogin account = new bankLogin(0,"0");
            account.AccountHolder();
        } else if (SelectedOption == 2) {
            System.out.println("Welcome to Account Creation Section!");
            System.out.println("Do you want to create your account? Yes or No?");
            System.out.println("Enter your choice?");
            AccountCreated = input.next();
            if (AccountCreated.equals("Yes")) {
                System.out.println("Your account request created and Sent!");
                System.out.println("Please Wait.....\nTill the option is visible");
                Timer Request = new Timer();
                TimerTask task = new TimerTask() {
                    public void run() {
                        System.out.println("Your Account request Accepted");
                        System.out.println("Press Enter to move to account creation form");
                    }
                };
                Request.schedule(task, 5000);
                input.nextLine();// Consumes \n
                input.nextLine();
                bankCreate account = new bankCreate();
                account.AccountInformation();
            } else if (AccountCreated.equals("No")) {
                System.out.println("No account created\nThanks for visiting");
            }else{
                System.out.println("Warning : Incorrect Input ! Choose Again !");
                main(args);
            }
        }else{
            System.out.println("Warnng : Wrong Input! Choose Again");
            main(args);
        }
        input.close();
    }
}
