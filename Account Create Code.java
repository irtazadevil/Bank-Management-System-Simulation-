import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
public class AccountCreate {
  // Just to keep track
  static int TotalAccountsCreated;
  // Account Login
  String Gmail;
  String FullName;
  long PhoneNumber;
  public long FirstAmountInput;
  int Pin;
  long AccountNumberGenerator;
  String AccountNumber;
  Scanner input = new Scanner(System.in);
  public static int TotalAccountCreated() {
    TotalAccountsCreated++;
    return TotalAccountsCreated;
  }

  public void AccountInformation() {
    String choice,
        AccountCreatChoice;
    
    System.out.println("Welcome to Account Creation Interface");
    System.out.println("Please fill the form for your Account Creation");
    System.out.println("Note : Becareful while filling it, Our Bank will not be responsible for anything");
    System.out.println("Enter your Full Name :");
    FullName = input.nextLine();
    System.out.println("Enter your G-Mail :");
    Gmail = input.nextLine();
    System.out.println("Enter your 4-Digit PIN you like to set :");
    Pin = input.nextInt();
    System.out.println("Enter your first Amount (To fill the null place):");
    FirstAmountInput = input.nextLong();
    System.out.println("Enter your Phone Number :");
    PhoneNumber = input.nextLong();
    System.out.println("Are your sure you want to save it? Yes or No?");
    choice = input.next();
    if (choice.equals("Yes")) {
      Random number = new Random();
      AccountNumberGenerator = number.nextInt(10000000)+100000000;
      AccountNumber = String.valueOf(AccountNumberGenerator);
      AccountNumber = "AC" + AccountNumber;
      System.out.println("Thanks for filling the form");
      System.out.println("Form");
      System.out.println("Full name : " + FullName);
      System.out.println("Account Number : AC" + AccountNumber);
      System.out.println("G-Mail : " + Gmail);
      System.out.println("Account PIN : " + Pin);
      System.out.println("Phone Number : +92" + PhoneNumber);
      System.out.println("Amount Entered at First : " + FirstAmountInput);
      System.out.println("Enter Yes or No for final step of creation of your Account?");
      AccountCreatChoice = input.next();
      if (AccountCreatChoice.equals("Yes")) {
        System.out.println("Your account is being created! Please Wait......");
        Timer Request = new Timer();
        TimerTask task = new TimerTask() {
          public void run() {
            System.out.println("Congratulations! Your Account is created");
            System.out.println("Press Enter to move to Your Main Menu");
          }
        };
        Request.schedule(task, 5000);
        input.nextLine();// \n Consumer
        input.nextLine();
        bankLogin MainMenu = new bankLogin(FirstAmountInput, AccountNumber);
        System.out.println("Welcome " + FullName + " !");
        MainMenu.MainMenu();
      } else {
        System.out.println("Warning : Wrong Input");
        System.out.println("Its so sensitive! Fill the form Again");
        AccountInformation();
      }
    } else if (choice.equals("No")) {
      input.nextLine();// Consumes the \n
      System.out.println("Press Enter to move to Main Interface");
      input.nextLine();
    } else {
      System.out.println("Warning : Wrong Input ! Choose Again !");
      AccountInformation();
    }
  }
}
