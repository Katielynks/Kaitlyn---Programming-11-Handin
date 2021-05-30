import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<>();
    private ArrayList<Withdraw> withdraws = new ArrayList<>();
    private double checkingBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    //getter for CheckingBalance
    public double getCheckingBalance() {
        return checkingBalance;
    }

    //getter for SavingBalance
    public double getSavingBalance() {
        return savingBalance;
    }

    //Default customer constructor, set default values
    // for accountNumber, checkingBalance, savingBalance, savingRate, and name
    Customer() {
        accountNumber = 1;
        checkingBalance = 100;
        savingBalance = 100;
        savingRate = 0;
        name = "James";
    }

    //The constructor used to setup our Customer object with desired parameters
    Customer(String name, int accountNumber, double checkingBalance, double savingBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
        this.savingRate = savingRate;
    }

    public double deposit(double amt, Date date, String account) {
        //Requires: amt, date, account
        //Modifies: This
        //Effects: Adds a new deposit to the Arraylist
        deposits.add(new Deposit(amt, date, account));

        //If the account is Checking
        if (account.equals("Checking") && amt >= 0) {

            //Adding the amount to the balance of checking account
            checkingBalance = checkingBalance + amt;

            //Return the new checking balance
            return checkingBalance;
        }
        //If the account is Saving
        else if (account.equals("Saving") && amt >= 0) {

            //Adding the amount to the balance of Saving account
            savingBalance = savingBalance + amt;

            //Return the new Saving balance
            return savingBalance;

        } else {
            System.out.println("Deposit Failed");
        }
        return 0;
    }

    public double withdraw(double amt, Date date, String account) {
        //Requires: amt, date, account
        //Modifies: This
        //Effects: Adds a new withdraw to the Arraylist

        //If the account is Checking
        if(account.equals("Checking") && amt >= 0){

            //Subtracting the amount from the balance of checking account
            checkingBalance = checkingBalance - amt;

            checkOverdraft(amt, "Checking");

            //Return the new checking balance
            return checkingBalance;

        }
        //If the account is Saving
        else if(account.equals("Saving") && amt >= 0){
            //Subtracting the amount from the balance of Saving account
            savingBalance = savingBalance - amt;

            checkOverdraft(amt, "Saving");

            //Return the new Saving balance
            return savingBalance;
        }
        return 0;
    }


    private boolean checkOverdraft(double amt, String account){
        //Requires: amt, account
        //Modifies: This
        //Effects: Check if it overdraft, if it is,
        //         we will revert the transaction and bring the account back to what is was before

        //If the account is Checking
        if(account.equals("Checking")){

            //Check if balance is less than overdraft
            if(checkingBalance<OVERDRAFT){

                //revert the transaction and bring the account back to what is was before
                checkingBalance = checkingBalance + amt;

                return true;
            }
        }

        //If the account is Saving
        else if(account.equals("Saving")){

            //Check if balance is less than overdraft
            if(savingBalance<OVERDRAFT){

                //revert the transaction and bring the account back to what is was before
                savingBalance = savingBalance + amt;

                return true;
            }
        }
        return false;
    }

    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
