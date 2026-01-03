package Projects;

import java.text.DecimalFormat;
import java.util.*;

class Account{
    DecimalFormat df = new DecimalFormat("###, ##0.00' Rs'");
    Scanner sc = new Scanner(System.in);
    private int cn;
    private int pn;

    void setCustomerNumber(int cn ) {

        this.cn = cn;
    }

    void setPINNumber(int pn) {

        this.pn = pn;
    }

    int getCustomerNumber()
    {
        return cn;
    }


    int getPINNumber() {

        return pn;
    }
    double currentBalance = 2000;

    String getCurrentBalance() {

         return df.format(currentBalance);
    }

    void getCurrentWithdrawInput() {
        System.out.println("Enter the amount to Withdraw: ");
        double currentWithdraw = sc.nextDouble();
        if(currentBalance == 0) {
            System.err.println("You do not have enough funds.");

        } else if (currentWithdraw > currentBalance) {
            System.err.println("Insufficient Funds.");
        } else {

            currentBalance -= currentWithdraw;
            System.out.println("Amount Debited Successfully.");
            System.out.println("New Current Balance: " + df.format(currentBalance));
        }
    }

    void getCurrentDepositInput() {
        System.out.print("Enter the amount to deposit: ");
        double currentDeposite = sc.nextDouble();


        if(currentDeposite <= 0) {

            System.out.println("Please enter the valid amount.");
        } else {

            currentBalance += currentDeposite;

            System.out.println("Amount deposited Successfully.");
            System.out.println("New Current Balance: " + df.format(currentBalance));
        }
    }

    double savingBalance = 2000;

    String getSavingBalance() {
        return df.format(savingBalance);
    }

    void getSavingDepositInput() {
        System.out.print("Enter the amount to deposit: ");
        double savingDeposite = sc.nextDouble();

        if(savingDeposite <= 0) {
            System.out.println("Please Enter the valid amount");
        }
        else {
            savingBalance += savingDeposite;

            System.out.println("Amount deposited Successfully.");
            System.out.println("New Saving Balance: " + df.format(savingBalance));
        }
    }

    void getSavingWithdrawInput() {
        System.out.print("Enter the amount to Withdraw: ");
        double savingWithdraw = sc.nextDouble();
        if(savingBalance == 0) {
            System.err.println("You do not have enough funds.");

        } else if (savingWithdraw > savingBalance) {
            System.err.println("Insufficient Funds.");
        } else {

            savingBalance -= savingWithdraw;
            System.out.println("Amount Debited Successfully.");
            System.out.println("New Saving Balance: " + df.format(savingBalance));
        }
    }

}

class OptionMenu extends Account {
    DecimalFormat df = new DecimalFormat("###,##0.00' Rs'");
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, Integer> data = new HashMap();


    void getLogin() {

        //Bank Customer
        data.put(11111, 111);
        data.put(11112, 111);
        data.put(11113, 111);
        data.put(11114, 111);
        data.put(11115, 111);
        data.put(11116, 111);

        do{
            try {
                System.out.print("\nEnter the customer number: ");

                setCustomerNumber(sc.nextInt());

                System.out.print("Enter the PIN number: ");

                setPINNumber(sc.nextInt());


                int p = getCustomerNumber();
                int q = getPINNumber();

                if(data.containsKey(p) && data.get(p) == q){
                    getAccountType();
                } else {
                    System.err.println("\nID or Password is wrong.");
                    System.err.println("\nEnter valid ID and Password.");
                }


            } catch (InputMismatchException e) {
                System.err.println("Enter only numbers.");
                System.err.println("Characters and symbols are not allowed.");
                sc.next();
            }
        } while(true);


    }

    void getAccountType() {
        System.out.println("\n-----Account Type-----");
        System.out.println("1. Current Account\n2. Saving Account\n3. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch(choice) {
            case 1:
                getCurent();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("\nThank you for visiting.");
                System.out.println("\nVisit again\n\n");

                break;

            default: System.err.println("Invalid Choice.");
                System.out.println("Enter VALID CHOICE: ");
                getAccountType();

                break;
        }


    }

    void getCurent() {
        System.out.println("\n-----Current Account-----\n");
        int choice ;
        do {
            System.out.println("1. View Balance.\n2. Withdraw Money.\n3. Deposit Money.\n4. Exit");
            System.out.print("Enter Your Choice: ");
            int ch = sc.nextInt();



            switch(ch) {
                case 1:
                    System.out.println(getCurrentBalance());


                    break;

                case  2:
                    getCurrentWithdrawInput();
                    break;

                case 3:
                    getCurrentDepositInput();
                    break;

                case 4:
                    System.out.println("\nThank you for visiting.");
                    System.out.println("\nVisit again\n\n");
                    return;

                default:
                    System.err.println("Invalid Choice.");
                    System.out.println("Enter VALID CHOICE: ");
                    getAccountType();
                    break;

            }

            System.out.println("Do you want to Continue ? (1/0)");
            choice = sc.nextInt() ;


        } while (choice != 0);

    }

    void getSaving() {
        System.out.println("\n-----Saving Account-----\n");
        int choice ;
        do {
            System.out.println("1. View Balance.\n2. Withdraw Money.\n3. Deposit Money.\n4. Exit");
            System.out.print("Enter Your Choice: ");
            int ch = sc.nextInt();



            switch(ch) {
                case 1:
                    System.out.println(getSavingBalance());

                    break;

                case  2:
                    getSavingWithdrawInput();
                    break;

                case 3:
                    getSavingDepositInput();
                    break;

                case 4:
                    System.out.println("\nThank you for visiting.");
                    System.out.println("\nVisit again\n\n");
                    return;

                default:
                    System.err.println("Invalid Choice.");
                    System.out.println("Enter VALID CHOICE: ");
                    getAccountType();
                    break;

            }

            System.out.println("Do you want to Continue ? (1/0)");
            choice = sc.nextInt() ;


        } while (choice != 0);
    }

}


public class ATM {
    public static void main(String[] args) {

        OptionMenu op = new OptionMenu();
        System.out.println("-----Welcome to the ATM-----");
        op.getLogin();
    }
}