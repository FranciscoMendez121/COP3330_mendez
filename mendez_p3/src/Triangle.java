public class Triangle extends Shape2D {

    //constructor for Triangle which will have a specific height and length and will be called "triangle"
    public Triangle(double height, double length) {
        this.name = "triangle";
        this.baseLength = length;
        this.height = height;
    }

    //here I am returning the area of a triangle
    public double getArea(){
        return height * baseLength / 2;
    }


}
