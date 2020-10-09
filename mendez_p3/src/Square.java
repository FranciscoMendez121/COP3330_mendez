public class Square extends Shape2D {

    //constructor for Square which will have a specific length and will be called "square"
    public Square(double length){
        this.name = "square";
        this.baseLength = length;
    }

    //the area of the square is the baseLength squared, thus getArea will return just that
    public double getArea(){
        return baseLength * baseLength;
    }


}
