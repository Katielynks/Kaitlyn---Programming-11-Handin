import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

            // Create a variable for the players choice: "r", "p", or "s"
            String personInput;

            // Create a variable for storing the Computer and Player choice string to output choices
            String choice;

            // Add in the scanner
            Scanner scan = new Scanner(System.in);

            // Instructions for the player
            System.out.println("Choose rock, paper, or scissors." +
                               " 'r' for rock, 'p' for paper, and 's' for scissors.");

            // Create a random digit for the computer from 1-3
            int random = (int) (Math.random() * 3) + 1;

            // Create a string for the computers choice  "r", "p", or "s"
            String computerOutput = "";

            // Translate computer's randomly generated Output to strings
            if (random == 1)
                computerOutput = "rock";
            else if (random == 2)
                computerOutput = "paper";
            else if (random == 3)
                computerOutput = "scissors";

            // Scan the user's input and convert it to a lowercase letter to make sure we cover
            // the scenario when user selects an upper case
            personInput = scan.next().toLowerCase();

            // Translate the players input into words
            personInput = switch (personInput) {
                case "r" -> "rock";
                case "p" -> "paper";
                case "s" -> "scissors";
                default -> personInput;
            };

            // Define the variable choice with values to use in the scenarios below
            choice = "Computer Choice: " + computerOutput + "\t Player Choice: " + personInput;

            // If there is a tie between player and computer, output "Draw!"
            if (personInput.equals(computerOutput))
            {System.out.println("Draw!");
                System.out.println(choice);}

            // The 2 scenarios below show when the person chooses rock
            else if ((personInput.equals("rock")) && (computerOutput.equals("scissors")))
            {System.out.println("You Win!");
                System.out.println(choice);}

            else if ((personInput.equals("rock")) && (computerOutput.equals("paper")))
            {System.out.println("You Lose!");
                System.out.println(choice);}

            //The 2 scenarios below show when the person chooses paper
            else if ((personInput.equals("paper")) && (computerOutput.equals("scissors")))
            {System.out.println("You Lose!");
                System.out.println(choice);}

            else if ((personInput.equals("paper")) && (computerOutput.equals("rock")))
            {System.out.println("You Win!");
                System.out.println(choice);}

            //The 2 scenarios below show when the person chooses scissors
            else if ((personInput.equals("scissors")) && (computerOutput.equals("paper")))
            {System.out.println("You Win!");
                System.out.println(choice);}

            else if ((personInput.equals("scissors")) && (computerOutput.equals("rock")))
            {System.out.println("You Lose!");
                System.out.println(choice);}

            //Display the invalid input
            else System.out.println("Invalid selection please play again.");

        }
    }
