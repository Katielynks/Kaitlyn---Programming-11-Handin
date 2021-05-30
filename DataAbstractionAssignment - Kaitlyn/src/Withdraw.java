import java.util.Date;

public class Withdraw {
    // Fields: amount, date, and account
    private double amount;
    private Date date;
    private String account;

    //The constructor used to setup our Withdraw object with desired parameters
    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(){
        //Requires: Nothing
        //Modifies: this
        //Returns: a string. Example: Withdrawal of: $400.0 Date: Sun Nov 04 00:00:00 PDT 2018 from account: Checking
        return "Withdrawal of: $" + amount + " Date: " + date.toString() + " from account: " + account;
    }
}
