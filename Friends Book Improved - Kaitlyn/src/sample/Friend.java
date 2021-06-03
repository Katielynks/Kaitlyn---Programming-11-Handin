package sample;

import java.io.*;

public class Friend {
    //Fields for Friend
    public String firstName;
    public String lastName;
    private String gender;
    private String phone;
    private String hobby;
    private String type;

    //The constructor used to setup our friend object with desired parameters
    Friend(String firstName, String lastName, String gender, String phone, String hobby, String type){
        this.firstName=firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.phone=phone;
        this.hobby=hobby;
        this.type=type;
    }

    //Write friends to file
    public void writeToFile(String fileName) throws IOException{

        //Create a buffer with the file reader as a parameter to read the file and store it in the buffer
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true ));

        //Write our fields with separators
        bw.write(firstName + "!\n");
        bw.write(lastName + "@\n");
        bw.write(gender + "#\n");
        bw.write(phone + "$\n");
        bw.write(hobby + "%\n");

        //Sane here for BFF and No selected friends choice
        if(type.equals("BFF")){
            bw.write("BFF"+"]\n");
        }
        else{
            bw.write("Not Selected"+"]\n");
        }

        //Indicate the end of the fields
        bw.write(";\n");

        //Close the file
        bw.close();
    }

    //Check if two friends are the same, if yes - return true, no - return false
    public boolean compareFriends(Friend f){
        if((this.firstName+this.lastName+this.gender+this.hobby).equals(f.firstName+f.lastName+f.gender+f.hobby)){
            return true;
        }else{
            return false;
        }
    }

    //Getter for phone
    public String getPhone() {
        return phone;
    }

    //Getter for Gender
    public String getGender() {
        return gender;
    }

    //Getter for Hobby
    public String getHobby() {
        return hobby;
    }

    //Getter for type
    public String getType(){ return type;}

    //Overrides and returns the first name and last name to display in the list
    public String toString() {
        return firstName+" "+lastName;
    }
}