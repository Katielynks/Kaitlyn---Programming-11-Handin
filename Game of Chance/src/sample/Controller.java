package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Controller {
    public Label yourMoney;
    public Label yourDice;
    public Label oppDice;
    public Button btnYourRoll;
    public Button btnOppRoll;
    private int diceYourResult;
    private int diceOppResult;
    public RadioButton btnHigh;
    public RadioButton btnLow;
    private boolean isHigher = false;
    private boolean isLower = false;
    public TextField betAmount;
    public Button btnPlayAgain;

    //When rolling a dice, pick a random number from 1 to 6
    private int rollDice() {
        //find a random number from 1 to 6 which is type of double
        double rollDice = Math.random() * 6 + 1;

        //convert it to Integer
        int diceAnswer = (int) rollDice;

        //return a number from 1 to 6
        return diceAnswer;
    }

    //Roll your dice method
    public void rollYours(ActionEvent actionEvent) {
        //Returns the outcome of your dice roll
        diceYourResult = rollDice();

        //yourDice label will display with the outcome of your dice roll
        yourDice.setText(Integer.toString(diceYourResult));

        //The your dice roll button will be disable after the first click
        btnYourRoll.setDisable(true);

        //Buttons Amount, Higher, and Lower are enabled
        betAmount.setDisable(false);
        btnHigh.setDisable(false);
        btnLow.setDisable(false);
    }

    //Roll opponents dice method
    public void rollOpponents(ActionEvent actionEvent) {

        //declare the new balance after the bet
        int newBalance;

        //get your balance
        int balance = Integer.parseInt(yourMoney.getText());

        //get the bet amount
        int betAmountResult = Integer.parseInt(betAmount.getText());

        //Buttons Amount, Higher, and Lower are enabled
        betAmount.setDisable(true);
        btnHigh.setDisable(true);
        btnLow.setDisable(true);

        //Returns the outcome of opponent dice roll
        diceOppResult = rollDice();

        //oppDice label will display with the outcome of opponent dice roll
        oppDice.setText(Integer.toString(diceOppResult));

        //if it's a good bet, then the winAmount is added to balance
        if (diceOppResult > diceYourResult && isHigher == true || diceOppResult < diceYourResult && isLower == true) {
            newBalance = balance + betAmountResult;
        }

        //if it is a tie, then the balance is the same
        else if (diceOppResult == diceYourResult) {
            newBalance = balance;
        }

        //if it's a bad bet, then the loseAmount is subtracted from balance
        else
        {
            newBalance = balance - betAmountResult;
        }

        //yourMoney label will display your money amount after the bet
        yourMoney.setText(Integer.toString(newBalance));

        //Opponent roll button is disabled
        btnOppRoll.setDisable(true);

        //Play Again button is enabled
        btnPlayAgain.setDisable(false);
    }

    //Enabling the opponent roll button
    public void enableOpponentDice() {
        betAmount.setDisable(false);
        //Enable the opponent roll button
        if ((isHigher || isLower) && (!betAmount.getText().isEmpty())) {
            btnOppRoll.setDisable(false);
        }

        //Disable the opponent roll button
        else {
            btnOppRoll.setDisable(true);
        }
    }

    //Higher radio button method
    public void higher(ActionEvent actionEvent) {
        //setting Higher to True and Lower to False when Higher radio button is clicked
        isHigher = true;
        isLower = false;

        //Disabling the bet amount
        betAmount.setDisable(true);

        //Enabling the opponent roll button
        enableOpponentDice();
    }

    //Lower radio button method
    public void lower(ActionEvent actionEvent) {
        //setting Lower to True and Higher to False when Lower radio button is clicked
        isLower = true;
        isHigher = false;

        //Disabling the bet amount
        betAmount.setDisable(true);

        //Enabling the opponent roll button
        enableOpponentDice();
    }

    //Play Again method
    public void playAgain(ActionEvent actionEvent) {

        //setting default value for Your and the opponent dice to start over
        yourDice.setText("0");
        oppDice.setText("0");

        //clear the bet amount
        betAmount.clear();

        //De-selecting Higher and Lower radio buttons values
        btnHigh.setSelected(false);
        btnLow.setSelected(false);

        //Disable all buttons except Your Roll button after Play Again
        btnYourRoll.setDisable(false);
        btnOppRoll.setDisable(true);
        btnHigh.setDisable(true);
        btnLow.setDisable(true);
        btnPlayAgain.setDisable(true);

    }
}