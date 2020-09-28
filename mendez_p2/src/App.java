import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static double getUserWeight(){
        System.out.println("\nPlease enter your weight: ");
        Scanner input = new Scanner(System.in);
        double weightValue = input.nextDouble();
        //Checking If the user enters a negative number
        if (weightValue > 0.0) {
            System.out.println("Thank you, displaying your entered weight: ");
            System.out.print(weightValue);
        }
        else if (weightValue < 0.0){
            do{
                System.out.println("Please enter a non-negative value for your weight: ");
                Scanner realInput = new Scanner(System.in);
                weightValue = realInput.nextDouble();
            } while (weightValue < 0.0);
        }

        //Just checking if the user enters a 0, then asks to rescan the input and rescans
        else{
            System.out.println("You did not enter any weight value, please enter a weight value: ");
            Scanner secondTimeUserInput = new Scanner(System.in);
            weightValue = secondTimeUserInput.nextDouble();
        }
        return weightValue;
    }

    public static double getUserHeight(){

        System.out.println("\nPlease enter your height: ");
        Scanner input = new Scanner(System.in);
        double heightValue = input.nextDouble();

        if (heightValue > 0.0){
            System.out.println("\nThank you, displaying your entered height: ");
            System.out.print(heightValue);
        }
        else if (heightValue < 0.0){
            do{
                System.out.println("\nPlease enter a non-negative value for your height: ");
                Scanner realInput = new Scanner(System.in);
                heightValue = realInput.nextDouble();

            } while(heightValue < 0.0);
        }
        else{
            System.out.println("\n0 is not a valid height value, please enter a height value: ");
            Scanner thirdUserInput = new Scanner(System.in);
            heightValue = thirdUserInput.nextDouble();
        }

        return heightValue;
    }

    //This is how you calculate the average
    //loop through BMI objects that you've collected, sum up the scores of the objects then divide by the number of times you looped


    public static void main(String [] args){
        //Wrapped BodyMassIndex bmiDAta.
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()){
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            //the .add is a method already defined in the java.util which already adds the value to the ArrayList so don't worry.
            //Adds it to the end of the ArrayList
            //adds the bmi of height and weight to the bmiData.
            bmiData.add(bmi);
            //Method in here
            displayBmiInfo(bmi);
        }
        //Method in here
        displayBmiStatistics(bmiData);
    }

    //End of the main

    //Prototype function to display the data.
    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){
        //for(BodyMassIndex data :bmiData){
            for(int i = 0; i < bmiData.size(); i++){
                BodyMassIndex score = bmiData.get(i);
                System.out.println(score);
            }
        //}
    }

    public static boolean moreInput(){
        boolean yesOrNo = true;

        int count = 0;
        
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Would you like to enter a height and weight value?: ( Y or N ) ");
            String choice = input.nextLine();

            switch(choice) {
                //They do want to enter more input;
                case "Y":
                    yesOrNo = true;
                    count = 1;
                    break;
                case "N":
                    yesOrNo = false;
                    count = 1;
                    break;
                default:
                    System.out.println("\nYou did not enter either Y or N. Please try again: ");

            }

        } while(count == 0);

        return yesOrNo;
    }

    public static void displayBmiInfo(BodyMassIndex b){
        b.printBmiScore();
    }

    //End of the class
}

