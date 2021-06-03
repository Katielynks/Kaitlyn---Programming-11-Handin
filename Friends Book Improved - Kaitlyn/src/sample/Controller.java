package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    public TextField textFirstName;
    public TextField textLastName;
    public TextField textGender;
    public TextField textPhone;
    public TextField textHobby;
    public CheckBox cbxBestFriends;
    public Label lblError;
    public Button btnAddFriend;

    public ListView<Friend> friendsList = new ListView<>();
    public Label lblFirstName;
    public Label lblLastName;
    public Label lblGender;
    public Label lblPhone;
    public Label lblHobby;
    public Label lblTypeOfFriend;
    public Label lblErrorTwo;
    public Button btnDeleteFriend;
    public Button btnSave;

    public ListView<Friend> anyListOfFriends = new ListView<>();
    private ArrayList<Friend> friends = new ArrayList<>();
    public CheckBox cbxAllFriendsTwo;
    public CheckBox cbxBestFriendsTwo;
    public Label lblFirstNameTwo;
    public Label lblLastNameTwo;
    public Label lblGenderTwo;
    public Label lblPhoneTwo;
    public Label lblHobbyTwo;
    public Label lblTypeOfFriendTwo;
    public Label lblErrorThree;
    public Button btnLoad;

    //Method to add friends, press the Add Friend button
    public void addFriend(ActionEvent actionEvent) {

        //Required fields - check if they are filled in
        if (textFirstName.getText().isEmpty() || textLastName.getText().isEmpty() || textGender.getText().isEmpty() || textPhone.getText().isEmpty() || textHobby.getText().isEmpty()) {

            //Error message
            lblError.setText("First Name, Last Name, Gender, Phone, and Hobby are required fields.");
        }

        //If all fields are filled in
        else {

            //When everything is filled in, there is no error
            lblError.setText("");

            //Get firstName, lastName, Gender, phone, hobby and the friend type
            String firstName = textFirstName.getText();
            String lastName = textLastName.getText();
            String Gender = textGender.getText();
            String phone = textPhone.getText();
            String hobby = textHobby.getText();
            String type = "";

            //If the bff check box is selected, type will be bff
            if (cbxBestFriends.isSelected()) {
                type = "BFF";
            }

            //Create a friend object according to the text inputted by the user
            Friend friend = new Friend(firstName, lastName, Gender, phone, hobby, type);

            //Add item to ListView list
            friendsList.getItems().add(friend);

            //Clear the text fields for next use
            textFirstName.clear();
            textLastName.clear();
            textGender.clear();
            textPhone.clear();
            textHobby.clear();

            //Unselect bff checkbox
            cbxBestFriends.setSelected(false);

            //Enable friendsList
            friendsList.setDisable(false);

            //Enable Save button
            btnSave.setDisable(false);
        }
    }

    //Check if it is a best friend
    public void setBestFriend(ActionEvent actionEvent) {
    }

    //Method to display friends before saving
    public void displayFriend(MouseEvent mouseEvent) {

        //Enable Delete button
        btnDeleteFriend.setDisable(false);

        //Set friend object to selected friend from list
        Friend friend = friendsList.getSelectionModel().getSelectedItem();

        //Labels for selected friend
        lblFirstName.setText(friend.firstName);
        lblLastName.setText(friend.lastName);
        lblGender.setText(friend.getGender());
        lblPhone.setText(friend.getPhone());
        lblHobby.setText(friend.getHobby());

        //If the friend is a bff
        if (friend.getType().equals("BFF")) {

            //Set label to bff
            lblTypeOfFriend.setText("BFF");
        }

        else {
            //Set label to Not Selected
            lblTypeOfFriend.setText("Not Selected");
        }
    }

    //Method to delete a friend prior to saving
    public void deleteFriend(ActionEvent actionEvent) {

        //Set friend object to selected friend from list
        Friend friend = friendsList.getSelectionModel().getSelectedItem();

        //Remove selected friend from list
        friendsList.getItems().remove(friend);

        //Clear labels
        clearLabels(lblFirstName, lblLastName, lblGender, lblPhone, lblHobby, lblTypeOfFriend);

        //Disable friendsList, delete button and save button
        if (friendsList.getItems().isEmpty()) {
            friendsList.setDisable(true);
            btnDeleteFriend.setDisable(true);
            btnSave.setDisable(true);
        }
    }

    //Method to clear labels
    private void clearLabels(Label firstName, Label lastName, Label gender, Label phone, Label hobby, Label type) {
        firstName.setText("");
        lastName.setText("");
        gender.setText("");
        phone.setText("");
        hobby.setText("");
        type.setText("");
    }

    //Method to save friends
    public void save(ActionEvent actionEvent) throws IOException {

        //Error message if the list is empty
        if (friendsList.getItems().isEmpty()) {
            lblErrorTwo.setText("Please add a friend before saving");
        }

        else {

            //If a list has values, no error message
            lblErrorTwo.setText("");

            //ObservableList to hold friends
            ObservableList<Friend> myList = friendsList.getItems();

            //for friends in the list
            for (Friend f : myList) {

                //write to allFriends.txt
                f.writeToFile("allFriends.txt");

                //if bff write to bestFriends.txt
                if (f.getType().equals("BFF")) {
                    f.writeToFile("bestFriends.txt");
                }
            }

            //Clear the list
            friendsList.getItems().clear();

            //Clear labels
            clearLabels(lblFirstName, lblLastName, lblGender, lblPhone, lblHobby, lblTypeOfFriend);

            //Disable List, save button, and delete button
            friendsList.setDisable(true);
            btnSave.setDisable(true);
            btnDeleteFriend.setDisable(true);
        }
    }

    //Load the list that is selected
    public void load(ActionEvent actionEvent) throws IOException {

        //Error if list not selected
        if (!cbxAllFriendsTwo.isSelected() && !cbxBestFriendsTwo.isSelected()) {
            lblErrorThree.setText("Please select a list");

            //Disable the list
            anyListOfFriends.setDisable(true);
        }

        else {

            //Clear labels
            clearLabels(lblFirstNameTwo, lblLastNameTwo, lblGenderTwo, lblPhoneTwo, lblHobbyTwo, lblTypeOfFriendTwo);

            //Empty the error message
            lblErrorThree.setText("");

            //Clear list
            anyListOfFriends.getItems().clear();
            friends.clear();

            //If the list has values
            String list = getSelectedList();
            if (list != null) {

                //Create friends
                friends = CreateFriend.createFriends(list);

                //Disable a list
                anyListOfFriends.setDisable(false);

                //add friends to a ListView
                for (Friend f : friends) {
                    anyListOfFriends.getItems().add(f);
                }
            }

            //If no friends in the list
            if(friends.isEmpty()){

                //Error if no friends in the list
                lblErrorThree.setText("There are no friends in this list");

                //Disable the list
                anyListOfFriends.setDisable(true);
            }
        }
    }

    //Return the selected list. With the different checkboxes, this method allows user to chose which list they wish to load. (inside load method)
    private String getSelectedList() {

        //Return the allFriends.txt in case when All Friends checkbox is selected
        if (cbxAllFriendsTwo.isSelected()) {
            return "allFriends.txt";
        }

        //Return the bestFriends.txt in case when BFF checkbox is selected
        else if (cbxBestFriendsTwo.isSelected()) {
            return "bestFriends.txt";
        }

        //Otherwise return null
        else{
            return null;
        }
    }


    //Unselect the All Fiends check box
    public void setAllFriendsList(ActionEvent actionEvent) {
        cbxBestFriendsTwo.setSelected(false);
    }

    //Unselect the BFF check box
    public void setBestFriendsList(ActionEvent actionEvent) {
        cbxAllFriendsTwo.setSelected(false);
    }

    //Display list of friends after clicking the Load button
    public void displayFriendTwo(MouseEvent mouseEvent) {

        //Set friend object to selected friend from list
        Friend friend= anyListOfFriends.getSelectionModel().getSelectedItem();

        //Labels for selected friends
        lblFirstNameTwo.setText(friend.firstName);
        lblLastNameTwo.setText(friend.lastName);
        lblGenderTwo.setText(friend.getGender());
        lblPhoneTwo.setText(friend.getPhone());
        lblHobbyTwo.setText(friend.getHobby());

        //If BFF
        if(friend.getType().equals("BFF")){

            //*Set label to bff
            lblTypeOfFriendTwo.setText("BFF");
        }
        //Set label to Not Selected
        else{
            lblTypeOfFriendTwo.setText("Not Selected");
        }
    }
}