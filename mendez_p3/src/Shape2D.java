public abstract class Shape2D extends Shape {

   //all 2D shapes will have the getName method and getArea method
   //I have to define them in this class due to them being abstract in the class Shape
   public String getName(){
      return name;
   }

   //getArea() will actually differ depending on the shape. But I still need to define it
   //hence, it returns 0
   public double getArea() {
      return 0.0;
   }


}
