public class Sphere extends Shape3D{
    //constructor for Sphere which will have a specific radius and will be called "sphere"
    public Sphere(double radius){
        this.name = "sphere";
        this.radius = radius;
    }

    //calculating the area of a sphere
    public double getArea() {
        return 4.0 * Math.PI * radius * radius;
    }

    //calculating the volume of a sphere
    public double getVolume(){
        return (4.0/3.0) * Math.PI * radius * radius * radius;
    }
}
