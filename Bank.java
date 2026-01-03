package Projects;

// Use Runnable so all threads share the same 'op' object and balance
class Account1 implements Runnable {
    int balance = 5000;
    int withdraw;

    Account1(int withdraw) {
        this.withdraw = withdraw;
    }

    // Must be public void run() with no arguments
    public void run(){
        calC();
    }
    synchronized void calC() {
        String name = Thread.currentThread().getName();

        if (withdraw <= balance) {
            System.out.println(name + " your transaction is successful.");
            balance -= withdraw;
            System.out.println("Remaining Balance: " + balance);
        } else {
            System.out.println(name + ", your Transaction Failed Successfully.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {

        System.out.println("-----Welcome to Axis bank-----");
        // One shared resource with 5000 balance
        Account1 op = new Account1(2000);
        Account1 op2 = new Account1(2000);

        Thread t1 = new Thread(op, "Pratap");
        Thread t2 = new Thread(op2, "Yuvraj");
        Thread t3 = new Thread(op2, "Sumit");
        Thread t4 = new Thread(op, "Dhanraj");
        Thread t5 = new Thread(op, "Vedant");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}