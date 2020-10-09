public abstract class Shape3D extends Shape {
    //a 3D shape is an extension of the shape class.

    //similar to how I defined the getName() method in the Shape2D class, here I also define it the same way
    public String getName(){
        return name;
    }

    public double getArea(){
        return 0;
    }

    //this method is abstract because we only want to calculate the volume of 3D objects and it depends on the shape
    //it is not in the shape class because 2D shapes cannot have their volumes calculated
    public abstract double getVolume();
}
