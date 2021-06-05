package sample;

import org.junit.Test;
import java.io.*;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class Tests {
    Plant plant;
    ArrayList<Plant> plants;
    String plantName1;
    String plantType1;
    String plantName2;
    String plantType2;

    @Test
    public void testToString() {
        //New plant object
        plant = new Plant("Tomato", "Early Girl", "Fruit", "60 days", "15", "Selected");

        //Check if it is returning the same string
        assertEquals("Tomato Early Girl", plant.toString());
    }

    @Test
    //Test all scenarios for Compare Plants method - False return
    public void testComparePlants() throws IOException {
        //New plant object
        plant = new Plant("Tomato2000", "Early Girl2000", "Fruit", "60 days", "15", "Selected");

        //Check Optional plants are created correctly
        plants = CreatePlant.createPlants("optional.txt");

        //Check if it is returning the same string
        assertEquals(false, plants.get(0).comparePlants(plant));
    }

    @Test
    //Test all scenarios for Compare Plants method - True return
    public void testCompareTruePlants() throws IOException {
        //New plant object
        plant = new Plant("Tomato", "Roma Tomato", "Fruit", "75 days", "15 Tomatos", "Selected");

        //Check Optional plants are created correctly
        plants = CreatePlant.createPlants("selected.txt");

        //Check if it is returning the same string
        assertEquals(true, plants.get(0).comparePlants(plant));
    }

    @Test
    //Test all scenarios for Create Plants method - Optional Plants
    public void testOptionalPlants() throws IOException {

        //Optional plants available in the Optional text file
        plantName1 = "Currant";
        plantType1 = "Black Currant";
        plantName2 = "Roses";
        plantType2 = "Hybrid tea rose";

        //Check Optional plants are created correctly
        plants = CreatePlant.createPlants("optional.txt");

        //Using  expected string to compare to the string from the file.
        assertEquals(plantName1, plants.get(0).plantName);
        assertEquals(plantType1, plants.get(0).plantType);
        assertEquals(plantName2, plants.get(1).plantName);
        assertEquals(plantType2, plants.get(1).plantType);
    }

    @Test
    //Test all scenarios for Create Plants method - Selected Plants
    public void testSelectedPlants() throws IOException {

        //Selected plants available in the selected text file
        plantName1 = "Tomato";
        plantType1 = "Roma Tomato";
        plantName2 = "Lavender";
        plantType2 = "English";

        //Check selected plants are created correctly
        plants = CreatePlant.createPlants("selected.txt");

        //Using  expected string to compare to the string from the file.
        assertEquals(plantName1, plants.get(0).plantName);
        assertEquals(plantType1, plants.get(0).plantType);
        assertEquals(plantName2, plants.get(1).plantName);
        assertEquals(plantType2, plants.get(1).plantType);

    }

    @Test
    //Test all scenarios for Create Plants method - All Plants
    public void testAllPlants() throws IOException {

        //All plants available in the all text file
        plantName1 = "Tomato";
        plantType1 = "Roma Tomato";
        plantName2 = "Currant";
        plantType2 = "Black Currant";

        //Check all plants are created correctly
        plants = CreatePlant.createPlants("allPlants.txt");

        //Using  expected string to compare to the string from the file.
        assertEquals(plantName1, plants.get(0).plantName);
        assertEquals(plantType1, plants.get(0).plantType);
        assertEquals(plantName2, plants.get(1).plantName);
        assertEquals(plantType2, plants.get(1).plantType);

    }

    }




