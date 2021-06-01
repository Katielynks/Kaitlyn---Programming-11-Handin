package sample;

public class Friend {
    public String firstName;
    public String lastName;
    private String gender;
    private String number;
    private String profession;
    private String hobby;
    private String animal;

    //The constructor used to setup our friend object with desired parameters
    Friend(String firstName, String lastName, String gender, String number, String hobby, String profession, String animal){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.number = number;
        this.profession = profession;
        this.hobby = hobby;
        this.animal = animal;
    }

    //Getters for getNumber
    public String getNumber() {
        return number;
    }

    //Getters for getProfession
    public String getProfession() {
        return profession;
    }

    //Getters for getGender
    public String getGender() {
        return gender;
    }

    //Getters for getHobby
    public String getHobby() {
        return hobby;
    }

    //Getters for getAnimal
    public String getAnimal() {
        return animal;
    }


    //Overrides and returns the first name, last name, and phone number to display in the list
    public String toString() {
        return firstName+" "+lastName+"\t"+number;
    }
}