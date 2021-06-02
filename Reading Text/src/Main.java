import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //The file we are going to search in
        String fileName = "ProgrammingHistory.txt";

        //Scan user input to receive the word we are looking for in the txt file
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a word to search - Example: programs or Programmable \t");
        String word = scan.next();

        //New ArrayList of lines
        ArrayList<String> lines = new ArrayList<>();

        //Create a buffer with the file reader as a parameter to read the file and store it in the buffer
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        //Create a string to read the line
        String line;

        //Read the whole line at the time and attach it to a string.
        //Read it until the end of the file where it will return null
        while ((line = br.readLine()) != null){
            lines.add(line);
        }

        //close the file when done reading
        br.close();

        //Create an ArrayList for position
        ArrayList<Integer> position = new ArrayList<>();

        //Line Number
        int lineNumber = 0;

        //For each line in the lines ArrayList
        for (String linea : lines){

            //Find the word and add the lineNumber into the arraylist
            if((linea.indexOf(word)) >= 0){
                position.add(lineNumber);
            }

            //Adds 1 to the count
            lineNumber++;
        }

        //Display every index position of the arraylist that the word is in
        for (int positionId : position) {
            System.out.println(positionId);
        }
    }
}