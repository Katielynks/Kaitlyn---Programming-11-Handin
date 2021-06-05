package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    public TextField textPlantName;
    public TextField textPlantType;
    public TextField textCategory;
    public TextField textMaturity;
    public TextField textYeild;
    public CheckBox cbxSelected;
    public CheckBox cbxOptional;
    public Label lblError;
    public Button btnAddPlant;

    public ListView<Plant> plantsList = new ListView<>();
    public Label lblPlantName;
    public Label lblPlantType;
    public Label lblCategory;
    public Label lblMaturity;
    public Label lblYeild;
    public Label lblPlan;
    public Label lblErrorTwo;
    public Button btnDeletePlant;
    public Button btnSave;

    public ListView<Plant> anyListOfPlants = new ListView<>();
    private ArrayList<Plant> plants = new ArrayList<>();
    public CheckBox cbxAllPlantsTwo;
    public CheckBox cbxSelectedTwo;
    public CheckBox cbxOptionalTwo;
    public Label lblPlantNameTwo;
    public Label lblPlantTypeTwo;
    public Label lblCategoryTwo;
    public Label lblMaturityTwo;
    public Label lblYeildTwo;
    public Label lblPlanTwo;
    public Label lblErrorThree;
    public Button btnLoad;

    //Method to add plants, press the Add Plant button
    public void addPlant(ActionEvent actionEvent) {

        //Required fields - check if they are filled in
        if (textPlantName.getText().isEmpty() || textPlantType.getText().isEmpty() || textCategory.getText().isEmpty() || textMaturity.getText().isEmpty() || textYeild.getText().isEmpty()) {

            //Error message
            lblError.setText("First Name, Last Name, Category, Maturity, and Yeild are required fields.");
        }

        //If all fields are filled in
        else {

            //When everything is filled in, there is no error
            lblError.setText("");

            //Get plantName, plantType, Category, maturity, yeild and the plant type
            String plantName = textPlantName.getText();
            String plantType = textPlantType.getText();
            String Category = textCategory.getText();
            String maturity = textMaturity.getText();
            String yeild = textYeild.getText();
            String type = "";

            //If the selected check box is selected, type will be selected
            if (cbxSelected.isSelected()) {
                type = "Selected";
            } else if (cbxOptional.isSelected()) {
                type = "Optional";
            }


            //Create a plant object according to the text inputted by the user
            Plant plant = new Plant(plantName, plantType, Category, maturity, yeild, type);

            //Add item to ListView list
            plantsList.getItems().add(plant);

            //Clear the text fields for next use
            textPlantName.clear();
            textPlantType.clear();
            textCategory.clear();
            textMaturity.clear();
            textYeild.clear();

            //Unselect checkboxes
            cbxSelected.setSelected(false);
            cbxOptional.setSelected(false);

            //Enable plantsList
            plantsList.setDisable(false);

            //Enable Save button
            btnSave.setDisable(false);
        }
    }

    //Check if it is a selected plant
    public void setSelected(ActionEvent actionEvent) {
    }

    //Check if it is a selected plant
    public void setOptional(ActionEvent actionEvent) {
    }

    //Method to display plants before saving
    public void displayPlant(MouseEvent mouseEvent) {

        //Enable Delete button
        btnDeletePlant.setDisable(false);

        //Set plant object to selected plant from list
        Plant plant = plantsList.getSelectionModel().getSelectedItem();

        //Labels for selected plant
        lblPlantName.setText(plant.plantName);
        lblPlantType.setText(plant.plantType);
        lblCategory.setText(plant.getCategory());
        lblMaturity.setText(plant.getMaturity());
        lblYeild.setText(plant.getYeild());

        //If the plant is a selected
        if (plant.getType().equals("Selected")) {

            //Set label to selected
            lblPlan.setText("Selected");
        }

        else if (plant.getType().equals("Optional")) {
            lblPlan.setText("Optional");
        }

        else {
            //Set label to Not Selected
            lblPlan.setText("Not Selected");
        }
    }

    //Method to delete a plant prior to saving
    public void deletePlant(ActionEvent actionEvent) {

        //Set plant object to selected plant from list
        Plant plant = plantsList.getSelectionModel().getSelectedItem();

        //Remove selected plant from list
        plantsList.getItems().remove(plant);

        //Clear labels
        clearLabels(lblPlantName, lblPlantType, lblCategory, lblMaturity, lblYeild, lblPlan);

        //Disable plantsList, delete button and save button
        if (plantsList.getItems().isEmpty()) {
            plantsList.setDisable(true);
            btnDeletePlant.setDisable(true);
            btnSave.setDisable(true);
        }
    }

    //Method to clear labels
    private void clearLabels(Label plantName, Label plantType, Label category, Label maturity, Label yeild, Label type) {
        plantName.setText("");
        plantType.setText("");
        category.setText("");
        maturity.setText("");
        yeild.setText("");
        type.setText("");
    }

    //Method to save plants
    public void save(ActionEvent actionEvent) throws IOException {

        //Error message if the list is empty
        if (plantsList.getItems().isEmpty()) {
            lblErrorTwo.setText("Please add a plant before saving");
        }

        else {

            //If a list has values, no error message
            lblErrorTwo.setText("");

            //ObservableList to hold plants
            ObservableList<Plant> myList = plantsList.getItems();

            //for plants in the list
            for (Plant f : myList) {

                //write to allPlants.txt
                f.writeToFile("allPlants.txt");

                //if selected write to selected.txt
                if (f.getType().equals("Selected")) {
                    f.writeToFile("selected.txt");
                } else if (f.getType().equals("Optional")) {
                    f.writeToFile("optional.txt");
                }
            }

            //Clear the list
            plantsList.getItems().clear();

            //Clear labels
            clearLabels(lblPlantName, lblPlantType, lblCategory, lblMaturity, lblYeild, lblPlan);

            //Disable List, save button, and delete button
            plantsList.setDisable(true);
            btnSave.setDisable(true);
            btnDeletePlant.setDisable(true);
        }
    }

    //Load the list that is selected
    public void load(ActionEvent actionEvent) throws IOException {

        //Error if list not selected
        if (!cbxAllPlantsTwo.isSelected() && !cbxSelectedTwo.isSelected() && !cbxOptionalTwo.isSelected()) {
            lblErrorThree.setText("Please select a list");

            //Disable the list
            anyListOfPlants.setDisable(true);
        }

        else {

            //Clear labels
            clearLabels(lblPlantNameTwo, lblPlantTypeTwo, lblCategoryTwo, lblMaturityTwo, lblYeildTwo, lblPlanTwo);

            //Empty the error message
            lblErrorThree.setText("");

            //Clear list
            anyListOfPlants.getItems().clear();
            plants.clear();

            //If the list has values
            String list = getSelectedList();
            if (list != null) {

                //Create plants
                plants = CreatePlant.createPlants(list);

                //Disable a list
                anyListOfPlants.setDisable(false);

                //add plants to a ListView
                for (Plant f : plants) {
                    anyListOfPlants.getItems().add(f);
                }
            }

            //If no plants in the list
            if(plants.isEmpty()){

                //Error if no plants in the list
                lblErrorThree.setText("There are no plants in this list");

                //Disable the list
                anyListOfPlants.setDisable(true);
            }
        }
    }

    //Return the selected list. With the different checkboxes, this method allows user to chose which list they wish to load. (inside load method)
    private String getSelectedList() {

        //Return the allPlants.txt in case when All Plants checkbox is selected
        if (cbxAllPlantsTwo.isSelected()) {
            return "allPlants.txt";
        }

        //Return the selected.txt in case when selected checkbox is selected
        else if (cbxSelectedTwo.isSelected()) {
            return "selected.txt";
        }

        //Return the selected.txt in case when optional checkbox is selected
        else if (cbxOptionalTwo.isSelected()) {
            return "optional.txt";
        }
        //Otherwise return null
        else{
            return null;
        }
    }


    //Unselect the All Fiends check box
    public void setAllPlantsList(ActionEvent actionEvent) {
        cbxSelectedTwo.setSelected(false);
        cbxOptionalTwo.setSelected(false);
    }

    //Unselect the check boxes
    public void setSelectedList(ActionEvent actionEvent) {
        cbxAllPlantsTwo.setSelected(false);
        cbxOptionalTwo.setSelected(false);
    }

    //Unselect the check boxes
    public void setOptionalList(ActionEvent actionEvent) {
        cbxAllPlantsTwo.setSelected(false);
        cbxSelectedTwo.setSelected(false);
    }

    //Display list of plants after clicking the Load button
    public void displayPlantTwo(MouseEvent mouseEvent) {

        //Set plant object to selected plant from list
        Plant plant= anyListOfPlants.getSelectionModel().getSelectedItem();

        //Labels for selected plants
        lblPlantNameTwo.setText(plant.plantName);
        lblPlantTypeTwo.setText(plant.plantType);
        lblCategoryTwo.setText(plant.getCategory());
        lblMaturityTwo.setText(plant.getMaturity());
        lblYeildTwo.setText(plant.getYeild());

        //If selected
        if(plant.getType().equals("Selected")){

            //Set label to selected
            lblPlanTwo.setText("Selected");
        }
        else if(plant.getType().equals("Optional")){

            //Set label to Optional
            lblPlanTwo.setText("Optional");
        }
        //Set label to Not Selected
        else{
            lblPlanTwo.setText("Not Selected");
        }
    }
}