import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    private BodyMassIndex bmi;

    @Test
    public void testCalcBmi(){
        double height = 68;
        double weight = 170;

        bmi = new BodyMassIndex(height, weight);
        double score = bmi.calcBmi();

        assertEquals(25.85,score);
    }

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