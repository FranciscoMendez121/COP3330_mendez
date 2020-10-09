public class Circle extends Shape2D{

    //constructor for Circle which has a specific radius and will be called "circle"
    public Circle(double radius){
        this.name = "circle";
        this.radius = radius;
    }

    //calculating the area of a circle and returning the value
    public double getArea(){
        return Math.PI * radius * radius;
    }


}
