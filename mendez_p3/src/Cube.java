public class Cube extends Shape3D {

    //constructor for Cube which will have a specific length and name
    public Cube(double length){
        this.name = "cube";
        this.baseLength = length;
    }

    //calculating the area of a cube and returning the value
    public double getArea(){
        return 6.0 * baseLength * baseLength;
    }

    //calculating the volume of a cube and returning the value
    public double getVolume() {
        return baseLength * baseLength * baseLength;
    }
}
