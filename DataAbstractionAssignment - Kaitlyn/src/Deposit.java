import java.util.Date;

public class Deposit {
    // Fields: amount, date, and account
    private double amount;
    private Date date;
    private String account;

    //The constructor used to setup our Deposit object with desired parameters
    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(){
        //Requires: Nothing
        //Modifies: this
        //Returns: a string. Example: Deposit of: $400.0 Date: Sun Nov 04 00:00:00 PDT 2018 into account: Checking
        return "Deposit of: $" + amount + " Date: " + date.toString() + " into account: " + account;
    }
}
