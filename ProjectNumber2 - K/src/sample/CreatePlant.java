package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreatePlant {

    //Fields
    private static String plantName;
    private static String plantType;
    private static String category;
    private static String maturity;
    private static String yeild;
    private static String type;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Plant> allPlants = new ArrayList<>();
    private static ArrayList<Plant> selPlants =new ArrayList<>();
    private static ArrayList<Plant> opPlants =new ArrayList<>();

    //Method that reads selected txt file to create plants that were saved
    public static ArrayList createPlants(String fileName) throws IOException {

        //Create a string to read the line
        String line;
        String plantString="";

        //Create a buffer with the file reader as a parameter to read the file and store it in the buffer
        br = new BufferedReader(new FileReader(fileName));

        //Read the whole line at the time and attach it to a string.
        //Read it until the end of the file where it will return null
        while((line = br.readLine()) != null){

            //Construct a string if not equal ";"
            if(!line.equals(";")){
                plantString += line;
            }

            //Once we reached ";" we'll parse the plants
            else{
                parsePlant(plantString, fileName);
                plantString="";
            }
        }

        //Return selPlants ArrayList if the file is for Best Plants
        if(fileName.equals("selected.txt")){
            return selPlants;
        }
        else if(fileName.equals("optional.txt")){
            return opPlants;
        }
        else{

            //Return allPlants ArrayList if the file is for All Plants
            return allPlants;
        }

    }

    //Parse plant
    private static void parsePlant(String string, String fileName){
        int pos1 = 0;
        int pos2 = 0;
        int pos3 = 0;
        int pos4 = 0;
        int pos5 = 0;
        int pos6 = 0;

        //Go through the string
        for(int i=0; i< string.length(); i++){

            //Find position that is equal "!" and if it is save the position and plantName
            if(string.substring(i, i+1).equals("!")){
                pos1 = i;
                plantName = string.substring(0, pos1);
            }

            //Find position that is equal "@" and if it is save the position and plantType
            else if(string.substring(i, i+1).equals("@")){
                pos2 = i;
                plantType = string.substring(pos1+1, pos2);
            }

            //Find position that is equal "#" and if it is save the position and category
            else if(string.substring(i, i+1).equals("#")){
                pos3 = i;
                category = string.substring(pos2+1, pos3);
            }

            //Find position that is equal "$" and if it is save the position and maturity
            else if(string.substring(i, i+1).equals("$")){
                pos4 = i;
                maturity = string.substring(pos3+1, pos4);
            }

            //Find position that is equal "%" and if it is save the position and yeild
            else if(string.substring(i, i+1).equals("%")){
                pos5 = i;
                yeild = string.substring(pos4+1, pos5);
            }

            //Find position that is equal "]" and if it is save the position and type
            else if(string.substring(i, i+1).equals("]")){
                pos6 = i;
                if(string.substring(pos5+1, pos6).equals("Selected")){
                    type = "Selected";
                }
                else if(string.substring(pos5+1, pos6).equals("Optional")){
                    type="Optional";
                }
                else{
                    type = "";
                }
            }
        }

        //New plant object
        Plant plant = new Plant(plantName, plantType, category, maturity, yeild, type);

        //Same plant is set to false
        boolean same=false;

        //If the file is for All Plants
        if(fileName.equals("allPlants.txt")){

            //For each plant
            for(Plant f : allPlants){

                //Compare if there are duplicates, then update same to true
                if(f.comparePlants(plant)){
                    same=true;
                    break;
                }
            }
        }

        //if the file is for selected Plants
        else if(fileName.equals("selected.txt")) {

            //For each plant
            for (Plant f : selPlants) {

                //Compare if there are duplicates, then update same to true
                if (f.comparePlants(plant)) {
                    same = true;
                    break;
                }
            }
        }
        //if the file is for Optional Plants
        else if(fileName.equals("optional.txt")) {

            //For each plant
            for (Plant f : opPlants) {

                //Compare if there are duplicates, then update same to true
                if (f.comparePlants(plant)) {
                    same = true;
                    break;
                }
            }
        }

        //If a plant is a new plant and does not match the one that is already on th list,
        if(!same){

            //For selected.txt
            if(fileName.equals("selected.txt")){

                //Add a plant to the selected Plant ArrayList
                selPlants.add(plant);
            }

            //Add a plant to the optional Plant ArrayList
            else if(fileName.equals("optional.txt")){
                opPlants.add(plant);
            }
            else{

                //Add a plant to the allPlants ArrayList
                allPlants.add(plant);
            }
        }
    }




}