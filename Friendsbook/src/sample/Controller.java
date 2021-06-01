package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    public TextField txtfirstName;
    public TextField txtlastName;
    public TextField txtNumber;
    public TextField txtProfession;
    public TextField txtHobby;
    public TextField txtAnimal;

    private String gender;

    public Button btnMale;
    public Button btnFemale;
    public Button btnaddFriend;
    public Button btndeleteFriend;

    public Label lblfirstName;
    public Label lbllastName;
    public Label lblGender;
    public Label lblNumber;
    public Label lblProfession;
    public Label lblHobby;
    public Label lblAnimal;

    public ListView<Friend> displayFriends = new ListView<>();


    //Set the gender of male depending on whether the user clicks the button male
    public void maleFriend(ActionEvent actionEvent) {
        gender = "Male";
    }

    //Set the gender of female depending on whether the user clicks the button female
    public void femaleFriend(ActionEvent actionEvent) {
        gender = "Female";
    }

    //Press the Add Friend button
    public void addFriend(ActionEvent actionEvent) {

        //Create a friend object according to the text inputted by the user
        Friend friend = new Friend(txtfirstName.getText(),txtlastName.getText(),gender,txtNumber.getText(), txtHobby.getText(),txtProfession.getText(),txtAnimal.getText());

        //Add and display the newly created friend to the list
        displayFriends.getItems().add(friend);

        //Clear the following text fields
        txtfirstName.clear();
        txtlastName.clear();
        txtNumber.clear();
        txtHobby.clear();
        txtProfession.clear();
        txtAnimal.clear();

        //Enable the delete button
        btndeleteFriend.setDisable(false);
    }

    //Press the Delete friend button
    public void deleteFriend(ActionEvent actionEvent) {

        //If there are no friends in the list, disable the Delete button, so we can't delete
        if (displayFriends.getItems().isEmpty() == true) {
            btndeleteFriend.setDisable(true);
        }
        else {
            //Enable the Delete button, when at least one item is selected in the Friends list
            if (displayFriends.getSelectionModel().getSelectedIndex() >= 0) {
            btndeleteFriend.setDisable(false);

            //Remove the chosen friend and set the text to blank
            displayFriends.getItems().remove(displayFriends.getSelectionModel().getSelectedIndex());
            lblfirstName.setText("");
            lbllastName.setText("");
            lblGender.setText("");
            lblNumber.setText("");
            lblHobby.setText("");
            lblProfession.setText("");
            lblAnimal.setText("");
        }
        }
    }

    //Click on a friend on the list
    public void friendDescription(MouseEvent mouseEvent) {
        Friend friend;

        //Get the chosen object from the list's display of friends
        friend = displayFriends.getSelectionModel().getSelectedItem();

        //Get the following parameters for friend and displays them
        lblfirstName.setText(friend.firstName);
        lbllastName.setText(friend.lastName);
        lblGender.setText(friend.getGender());
        lblNumber.setText(friend.getNumber());
        lblHobby.setText(friend.getHobby());
        lblProfession.setText(friend.getProfession());
        lblAnimal.setText(friend.getAnimal());
    }

}