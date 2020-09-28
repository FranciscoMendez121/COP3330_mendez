import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    private BodyMassIndex bmi;
    //Testing the calcBmi method to ensure the calculation is correct.
    @Test
    public void testCalcBmi(){
        double height = 68;
        double weight = 170;

        bmi = new BodyMassIndex(height, weight);
        double score = bmi.calcBmi();

        assertEquals(25.85,score);
    }
    /*
    Testing if given a specific height and weight, the method will return the appropriate category.
    Here it will be "Underweight"
    */
    @Test
    public void testIsUnderweight(){

        double height = 50;
        double weight = 2;

        bmi = new BodyMassIndex(height,weight);

        double score = bmi.calcBmi();

        bmi.printCategoryDeterminer(score);

        String string1 = "Underweight";

        assertEquals(string1, bmi.printCategoryDeterminer(score));
    }
    /*
    Testing if given a specific height and weight, the method will return the appropriate category.
    Here it will be "Normal weight"
    */
    @Test
    public void testIsNormalWeight(){

        double height = 50;
        double weight = 70;

        bmi = new BodyMassIndex(height,weight);

        double score = bmi.calcBmi();

        bmi.printCategoryDeterminer(score);

        String string1 = "Normal weight";

        assertEquals(string1, bmi.printCategoryDeterminer(score));
    }
    /*
    Testing if given a specific height and weight, the method will return the appropriate category.
    Here it will be "Over weight"
    */
    @Test
    public void testIsOverWeight(){
        double height = 50;
        double weight = 100;

        bmi = new BodyMassIndex(height,weight);

        double score = bmi.calcBmi();

        bmi.printCategoryDeterminer(score);

        String string1 = "Over weight";

        assertEquals(string1, bmi.printCategoryDeterminer(score));
    }
    /*
    Testing if given a specific height and weight, the method will return the appropriate category.
    Here it will be "Obese"
    */

    @Test
    public void testIsObese(){
        double height = 50;
        double weight = 130;

        bmi = new BodyMassIndex(height,weight);

        double score = bmi.calcBmi();

        bmi.printCategoryDeterminer(score);

        String string1 = "Obese";

        assertEquals(string1, bmi.printCategoryDeterminer(score));
    }
    //Testing to make sure that the bmi score is calculated correctly and printed correctly.
    @Test
    public void testPrintBmiScore(){
        double height = 68;
        double weight = 170;

        bmi = new BodyMassIndex(height, weight);
        double score = bmi.calcBmi();

        bmi.printCategoryDeterminer(score);

        assertEquals(25.85,score);
    }
}