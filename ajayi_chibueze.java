import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// meal class
// QUESTION 1
class Meal {
    // creating the singleton instance
    public static Meal getInstance () {
        return new Meal();
    }
    // other implements
    // name attribute
    void name(String meal_name) {

    }
    // protein attribute
    void proteinContentInMiligram(double value) {

    }
    // carbohydrate attribute
    void carbonHydrateContentInMiligram(double value) {

    }
    // fat attribute
    void fatContentInMiligram(double value) {

    }

}

// QUESTION 2 : LinkedList 
class MealLinkedList {
    private String[] meal_names = {};
    private double[] protein_content_in_miligram = {}, carbohydrate_content_in_miligram = {}, fat_content_in_miligram = {};
    // add the meal to the linked list
    public void add (String name, double protein_cont, double carbohydate_cont, double fat_cont) {
        // avoid double entry
        if (search(name) < 0) { System.out.println("Duplicating entry"); return; }
        meal_names[meal_names.length - 1] = name;
        protein_content_in_miligram[protein_content_in_miligram.length - 1] = protein_cont;
        carbohydrate_content_in_miligram[carbohydrate_content_in_miligram.length - 1] = carbohydate_cont;
        fat_content_in_miligram[fat_content_in_miligram.length - 1] = fat_cont;
    }
    // remove a particular meal
    public void remove (String meal_name) { int x = -1;
        // check if the meal exist
        int meal_index = search(meal_name);
        if (meal_index >= 0) { x = meal_index;
            meal_names[x] = ""; carbohydrate_content_in_miligram[x] = 0d;
            protein_content_in_miligram[x] = 0d; fat_content_in_miligram[x] = 0d;
            return;
        }
        System.out.print("Such meal doesn't exist");
    }
    // index of a particular meal in the linked list and returning the index
    public int search (String meal_name) { int x = -1;
        for (String name_ : meal_names) { x ++;
            if (name_.equals(meal_name)) return x;
            return -1;
        }
        return -1;
    }
    // search for a particular meal 
    public int find (String meal_name) { return search (meal_name);}
    // creating the toString method of the Meal list
    @Override
    public String toString() { 
        return meal_names.toString();
    }
}

// QUESTION 5 : 
class TeraData {
    //reading files from machine files
    public static String [] getConfiguration (String config_file) throws IOException, Exception {     
        File config = new File(config_file); String [] data = new String[10];
        Scanner scanner = new Scanner(config); int x = -1;

        while (scanner.hasNextLine()) { x ++;
            data[x] = (String) scanner.nextLine().toString();
        } scanner.close();

        return data;
    }

    public static String computeTransmissionProbability (String [] data) { String output = "";
        String [] analysis_data = data;  int x = -1;
        for (String result : analysis_data) { x ++;
            if (x == 0) continue;
            String [] results = result.split(",");
            int u = Integer.parseInt(results[0]), // u value
                v = x > 0 ? Integer.parseInt(results[1]) : 0, // v value
                p = x > 0 ? Integer.parseInt(results[2]) : 0; // p value
            output += "Probability: " + Integer.toString(p/10);
            output += "%/n";
        }
        return output;
    }

}

// main method
public class ajayi_chibueze {
    
    // main function
    public static void main(String[] args) throws Exception {
        String [] data = TeraData.getConfiguration("teradata-world-setup.txt");
        String probabilityAnalysisMessage = TeraData.computeTransmissionProbability(data);
        System.out.print(probabilityAnalysisMessage);
    }
}  