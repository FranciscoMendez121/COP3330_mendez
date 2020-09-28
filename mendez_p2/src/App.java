import java.util.ArrayList;
import java.util.Scanner;

public class App {
    //This method prompts the user for their weight, scans then stores the value.
    public static double getUserWeight() {
        //Prompting the user to enter a weight and scanning the information
        System.out.println("\nPlease enter your weight: ");
        Scanner input = new Scanner(System.in);
        double weightValue = input.nextDouble();

        //If the user enters a positive number, store the number of the weight.
        if (weightValue > 0.0) {
            System.out.println("Thank you, displaying your entered weight: ");
            System.out.print(weightValue);
        }
        /*
        If the weight is negative, continue asking the user to enter a positive "non-negative" number until they
        finally enter a positive number.
        */
        else if (weightValue < 0.0) {
            do {
                System.out.println("Please enter a non-negative value for your weight: ");
                Scanner realInput = new Scanner(System.in);
                weightValue = realInput.nextDouble();
            } while (weightValue < 0.0);
        }
        //Just checking if the user enters a 0, then asks to rescan the input and rescans
        else {
            do {
                System.out.println("You did not enter any weight value, please enter a weight value: ");
                Scanner secondTimeUserInput = new Scanner(System.in);
                weightValue = secondTimeUserInput.nextDouble();
            } while (weightValue == 0.0);
        }
        return weightValue;
    }

    //This method will prompt the user to enter a height and scan the height
    public static double getUserHeight() {

        System.out.println("\nPlease enter your height: ");
        Scanner input = new Scanner(System.in);
        double heightValue = input.nextDouble();
        //If the height is positive, perfect, now store that value and display the height
        if (heightValue > 0.0) {
            System.out.println("\nThank you, displaying your entered height: ");
            System.out.print(heightValue);
        }
        /*
        If the height value is negative, continue to prompt the user to enter a positive value for the height
        once they do enter a positive value for the height, store the value and display it.
        */
        else if (heightValue < 0.0) {
            do {
                System.out.println("\nPlease enter a non-negative value for your height: ");
                Scanner realInput = new Scanner(System.in);
                heightValue = realInput.nextDouble();

            } while (heightValue < 0.0);
        }
        /*
        If the height value is zero, continue to prompt the user to enter a positive value for the height
        once they do enter a positive value for the height, store the value and display it.
        */
        else {
            do {
                System.out.println("\n0 is not a valid height value, please enter a height value: ");
                Scanner secondTimeUserInput = new Scanner(System.in);
                heightValue = secondTimeUserInput.nextDouble();
            } while (heightValue == 0.0);
        }

        return heightValue;
    }

    //function to display the average bmi score data.
    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        for (int i = 0; i < bmiData.size(); i++) {
            BodyMassIndex score = bmiData.get(i);
            System.out.println(score);
        }
    }

    /*
    This method prompts the user if they wish to add input to the function. If they do then return true
    If they do not want to add more input, then return false.
    */
    public static boolean moreInput() {
        //Initializing the return value to be true.
        boolean yesOrNo = true;
        /*
        This integer will determine if the user enters a value that is not Y or N.
        The value will only change if the user enters Y or N.
        */
        int count = 0;
        //This do while loop ensures that the user enters either Y or N and adjusts the count value.
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Would you like to enter a height and weight value?: ( Y or N ) ");
            String choice = input.nextLine();

            switch (choice) {
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

        } while (count == 0);

        return yesOrNo;
    }

    /*
    This method calls a method in the BodyMassIndex class to print out the bmi score
    which will also print out the category
    */
    public static void displayBmiInfo(BodyMassIndex b) {
        b.printBmiScore();
    }


    //main method where the program enters. Can not be changed as per instructions.
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);

            bmiData.add(bmi);
            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

}

