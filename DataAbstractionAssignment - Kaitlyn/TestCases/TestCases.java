import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCases {

    @Test
    //Test toString method in Deposit class
    public void testDepositToString() {
        //Instantiate the date object
        Date date = new Date();

        //Instantiate the Deposit object
        Deposit depositChecking = new Deposit(100,date,"Checking");

        //Check if toString method returns what is expected
        assertEquals("Deposit of: $100.0 Date: " + date + " into account: Checking",depositChecking.toString());

        //Instantiate the Deposit object
        Deposit depositSaving = new Deposit(100,date,"Saving");

        //Check if toString method returns what is expected
        assertEquals("Deposit of: $100.0 Date: " + date + " into account: Saving",depositSaving.toString());
    }

    @Test
    //Test toString method in Withdraw class
    public void testWithdrawToString() {
        //Instantiate the date object
        Date date = new Date();

        //Instantiate the Withdraw object
        Withdraw withdrawChecking = new Withdraw(100, date,"Checking");

        //Check if toString method returns what is expected
        assertEquals("Withdrawal of: $100.0 Date: " + date + " from account: Checking",withdrawChecking.toString());

        //Instantiate the Withdraw object
        Withdraw withdrawSaving = new Withdraw(100, date,"Saving");

        //Check if toString method returns what is expected
        assertEquals("Withdrawal of: $100.0 Date: " + date + " from account: Saving",withdrawSaving.toString());
    }

    @Test
    //Test the deposit method in Customer class
    public void testCustomerDeposit() {
        //Instantiate the Customer object
        Customer customer = new Customer();

        //Instantiate the date object
        Date date = new Date();

        //Create the $100 deposit in customer class
        customer.deposit(100,date,"Checking");

        //check if checking balance is $200
        assertEquals(200,customer.getCheckingBalance());

        //Create the $100 deposit in customer class
        customer.deposit(100,date,"Saving");

        //check if saving balance is $200
        assertEquals(200,customer.getSavingBalance());
    }

    @Test
    //Test the deposit method in Withdraw class
    public void testCustomerWithdraw() {
        //Instantiate the Customer object
        Customer customer = new Customer();

        //Instantiate the date object
        Date date = new Date();

        //The maximum overdraft is -$100 before a client will have to pay overdraft fees.
        // We have $100 in Saving account. We withdraw $201 from Saving account.
        // $100 - $201 = -$101. -$101 is going over the limit of Overdraft of -$100.
        // Because of this we will REVERT the transaction and bring the account back to what is was before
        // The balance will be reverted to $100.
        // check if saving balance is $100.
        assertEquals(100,customer.withdraw(201, date,"Saving"));

        //The maximum overdraft is -$100 before a client will have to pay overdraft fees.
        // We have $100 in Checking account. We withdraw $201 from Checking account.
        // $100 - $201 = -$101. -$101 is going over the limit of Overdraft of -$100.
        // Because of this we will REVERT the transaction and bring the account back to what is was before
        // The balance will be reverted to $100.
        // check if Checking balance is $100.
        assertEquals(100,customer.withdraw(201, date,"Checking"));

        //Creates another withdrawal of $50 from Saving but it is not overdraft
        customer.withdraw(50,date,"Saving");
        // check if Saving balance is $50.
        assertEquals(50,customer.getSavingBalance());

        //Creates another withdrawal of $50 from Checking but it is not overdraft
        customer.withdraw(50,date,"Checking");
        // check if Checking balance is $50.
        assertEquals(50,customer.getCheckingBalance());
    }
}
