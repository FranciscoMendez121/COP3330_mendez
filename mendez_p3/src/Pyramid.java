public class Pyramid extends Shape3D {

    //constructor for Pyramid which will have a specific length, width, and height and will be called "pyramid"
    public Pyramid(double length, double width, double height) {
        this.name = "pyramid";
        this.baseLength = length;
        this.height = height;
        this.width = width;
    }

    //Helper method to calculate the area of a pyramid.
    public double pyramidAreaCalculator(double length, double width, double height){
        double firstTerm = length * width;

        //insideFirstSquareRoot is a variable to help shorten the square root in secondTerm
        double insideFirstSquareRoot = (width/2.0) * (width/2) + (height * height);
        double secondTerm = length * Math.sqrt(insideFirstSquareRoot);

        //insideSecondSquareRoot is a variable to help shorten the square root in thirdTerm
        double insideSecondSquareRoot = (length/2.0) * (length/2.0) + (height * height);
        double thirdTerm = width * Math.sqrt(insideSecondSquareRoot);

        //returns the value of all three "terms" combined
        return firstTerm + secondTerm + thirdTerm;
    }

    //calls the helper method pyramidAreaCalculator and passes the given length, width, and height
    public double getArea() {
        return pyramidAreaCalculator(baseLength,width,height);
    }

    //calculating the volume of the pyramid
    public double getVolume() {
        return (height * baseLength * width) / 3;
    }
}
