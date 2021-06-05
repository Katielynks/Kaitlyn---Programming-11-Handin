package sample;

import java.io.*;

public class Plant {
    //Fields for Plant
    public String plantName;
    public String plantType;
    private String category;
    private String maturity;
    private String yeild;
    private String type;

    //The constructor used to setup our Plant object with desired parameters
    Plant(String plantName, String plantType, String category, String maturity, String yeild, String type){
        this.plantName=plantName;
        this.plantType=plantType;
        this.category=category;
        this.maturity=maturity;
        this.yeild=yeild;
        this.type=type;
    }

    //Write Plants to file
    public void writeToFile(String fileName) throws IOException{

        //Create a buffer with the file reader as a parameter to read the file and store it in the buffer
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true ));

        //Write our fields with separators
        bw.write(plantName + "!\n");
        bw.write(plantType + "@\n");
        bw.write(category + "#\n");
        bw.write(maturity + "$\n");
        bw.write(yeild + "%\n");

        //Same here for Selected and No selected Plants choice
        if(type.equals("Selected")){
            bw.write("Selected"+"]\n");
        }
        else if(type.equals("Optional")){
            bw.write("Optional"+"]\n");
        }
        else{
            bw.write("Not Selected"+"]\n");
        }

        //Indicate the end of the fields
        bw.write(";\n");

        //Close the file
        bw.close();
    }

    //Check if two Plants are the same, if yes - return true, no - return false
    public boolean comparePlants(Plant f){
        if((this.plantName+this.plantType).equals(f.plantName+f.plantType)){
            return true;
        }else{
            return false;
        }
    }

    //Getter for maturity
    public String getMaturity() {
        return maturity;
    }

    //Getter for category
    public String getCategory() {
        return category;
    }

    //Getter for yeild
    public String getYeild() {
        return yeild;
    }

    //Getter for type
    public String getType(){ return type;}

    //Overrides and returns the first name and last name to display in the list
    public String toString() {
        return plantName+" "+plantType;
    }
}