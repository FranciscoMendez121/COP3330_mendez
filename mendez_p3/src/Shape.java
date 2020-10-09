public abstract class Shape {

    //here I am initializing several variables which all shapes will have
    protected String name;
    protected double height;
    protected double baseLength;
    protected double radius;
    protected double width;

    //Here are the abstract methods of getName() and getArea(). They will differ depending on the shape
    //hence, they are abstract
    public abstract String getName();

    public abstract double getArea();


}