public class BodyMassIndex {

    private double height;
    private double weight;

    //This would be the constructor
    public BodyMassIndex(double height, double weight){
        //Checking if the height input is correct, if not, warn user.
        if(height < 0.0) {
            throw new IllegalArgumentException("height (" + height + ") must be greater than 0");
        }
        //Same process but for weight.
        if(weight < 0.0){
            throw new IllegalArgumentException("weight (" + weight + ") must be greater than 0");
        }

        //Everything checks out, proceed to create the height and weight.
        this.height = height;
        this.weight = weight;
    }

    //This method contains the categories for each bmi score range and will return a string value to test in the test class.
    public String printCategoryDeterminer(double score){
        //Initializing a String string which will change depending on the bmi category. Primarily for testing.
        String string = "";
        if(score < 18.5){
            System.out.println("\nUnderweight");
            string = "Underweight";
        }
        if(score >= 18.5 && score < 24.9){
            System.out.println("\nNormal weight");
            string = "Normal weight";
        }
        if(score >= 25 && score < 29.9){
            System.out.println("\nOver weight");
            string = "Over weight";
        }
        if(score >= 30){
            System.out.println("\nObese");
            string = "Obese";
        }

        System.out.printf("\nYour Bmi score is: %.02f\n",score);
        return string;
    }

    //This method rounds the double value to two decimal places for the bmi calculation.
    public static double roundVal(double value, int places){
        long fact = (long) Math.pow(10,places);
        value = value * fact;
        long temp = Math.round(value);
        return ((double) temp / fact);
    }

    //This method calculated the bmi score and calls the roundVal method to round the answer to two decimal places
    public double calcBmi(){
        double score = ((weight * 703)/(height * height));

        return roundVal(score,2);
    }


    //This method calls calcBmi and prints the bmi score based on the categories listed on the method printCategoryDeterminer.
    public void printBmiScore(){

        double score = calcBmi();

        printCategoryDeterminer(score);
    }

}
