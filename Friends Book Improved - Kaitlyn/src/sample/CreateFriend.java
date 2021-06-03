package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateFriend {

    //Fields
    private static String firstName;
    private static String lastName;
    private static String gender;
    private static String phone;
    private static String hobby;
    private static String type;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> allFriends = new ArrayList<>();
    private static ArrayList<Friend> bestFriends =new ArrayList<>();

    //Method that reads selected txt file to create friends that were saved
    public static ArrayList createFriends(String fileName) throws IOException {

        //Create a string to read the line
        String line;
        String friendString="";

        //Create a buffer with the file reader as a parameter to read the file and store it in the buffer
        br = new BufferedReader(new FileReader(fileName));

        //Read the whole line at the time and attach it to a string.
        //Read it until the end of the file where it will return null
        while((line = br.readLine()) != null){

            //Construct a string if not equal ";"
            if(!line.equals(";")){
                friendString += line;
            }

            //Once we reached ";" we'll parse the friends
            else{
                parseFriend(friendString, fileName);
                friendString="";
            }
        }

        //Return bestFriends ArrayList if the file is for Best Friends
        if(fileName.equals("bestFriends.txt")){
            return bestFriends;
        }
        else{

            //*Return allFriends ArrayList if the file is for All Friends
            return allFriends;
        }

    }

    //Parse friend
    private static void parseFriend(String string, String fileName){
        int pos1 = 0;
        int pos2 = 0;
        int pos3 = 0;
        int pos4 = 0;
        int pos5 = 0;
        int pos6 = 0;

        //Go through the string
        for(int i=0; i< string.length(); i++){

            //Find position that is equal "!" and if it is save the position and firstName
            if(string.substring(i, i+1).equals("!")){
                pos1 = i;
                firstName = string.substring(0, pos1);
            }

            //Find position that is equal "@" and if it is save the position and lastName
            else if(string.substring(i, i+1).equals("@")){
                pos2 = i;
                lastName = string.substring(pos1+1, pos2);
            }

            //Find position that is equal "#" and if it is save the position and gender
            else if(string.substring(i, i+1).equals("#")){
                pos3 = i;
                gender = string.substring(pos2+1, pos3);
            }

            //Find position that is equal "$" and if it is save the position and phone
            else if(string.substring(i, i+1).equals("$")){
                pos4 = i;
                phone = string.substring(pos3+1, pos4);
            }

            //Find position that is equal "%" and if it is save the position and hobby
            else if(string.substring(i, i+1).equals("%")){
                pos5 = i;
                hobby = string.substring(pos4+1, pos5);
            }

            //Find position that is equal "]" and if it is save the position and type
            else if(string.substring(i, i+1).equals("]")){
                pos6 = i;
                if(string.substring(pos5+1, pos6).equals("BFF")){
                    type = "BFF";
                }
                else{
                    type = "";
                }
            }
        }

        //New friend object
        Friend friend = new Friend(firstName, lastName, gender, phone, hobby, type);

        //Same friend is set to false
        boolean same=false;

        //If the file is for All Friends
        if(fileName.equals("allFriends.txt")){

            //For each friend
            for(Friend f : allFriends){

                //Compare if there are duplicates, then update same to true
                if(f.compareFriends(friend)){
                    same=true;
                    break;
                }
            }
        }

        //*if the file is for Best Friends
        else if(fileName.equals("bestFriends.txt")) {

            //*For each friend
            for (Friend f : bestFriends) {

                //*Compare if there are duplicates, then update same to true
                if (f.compareFriends(friend)) {
                    same = true;
                    break;
                }
            }
        }

        //*If a friend is a new friend and does not match the one that is already on th list,
        if(!same){

            //*For bestFriends.txt
            if(fileName.equals("bestFriends.txt")){

                //*Add a friend to the Best Friend ArrayList
                bestFriends.add(friend);
            }
            else{

                //*Add a friend to the allFriends ArrayList
                allFriends.add(friend);
            }
        }
    }




}