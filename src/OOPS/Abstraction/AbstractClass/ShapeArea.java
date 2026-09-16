package OOPS.Abstraction.AbstractClass;

/*
 =========================================================================
 PRACTICE PROBLEM 1  --  SHAPE AREA
 =========================================================================

 Rewrite OOPS/Polymorphism/ShapesExample.java properly.

 The old one looks like this:

     public class ShapesExample {
         void area(){
             System.out.println("This is the shape class example");
         }
     }

     class Circle extends ShapesExample{
         void area(){
             System.out.println("Circle area is 3.14*r*r");
         }
     }

 Three things are wrong with it:

   1. ShapesExample.area() has a body that is not an area. You only wrote
      it because Java forced you to write something. That is a workaround,
      and `abstract` is the feature that removes the need for it.

   2. main() contains  new ShapesExample()  -- a shape that is not any
      shape. It compiles. It should not be able to.

   3. area() PRINTS a sentence about a formula instead of RETURNING a
      number. Nothing can be summed, sorted or compared. Same mistake as
      a getter that prints -- Encapsulation/Notes PART 5.


 THE CONTRACT -- the sentence that must always be true:

     "every Shape can tell you its area and its perimeter as a number,
      and there is no such thing as a plain Shape"

 Your job is to make the second half of that sentence enforced by the
 compiler, not by good manners.


 WRITE THE CLASSES

   1. abstract class Shape
        FIELD      private final String name
        CONSTRUCTOR Shape(String name)
        CONCRETE   String getName()        -> returns name
        CONCRETE   void display()          -> prints
                                              "<name> | area: <a> | perimeter: <p>"
                                              formatted to 2 decimals, using
                                              String.format("%.2f", ...)
        ABSTRACT   double area()           -> no body
        ABSTRACT   double perimeter()      -> no body

      Note that display() CALLS the two abstract methods. It has no idea
      what they will do. That is abstraction: the parent writes the shared
      logic, the child supplies the details.

   2. class Circle extends Shape
        private final double radius
        area      -> Math.PI * radius * radius
        perimeter -> 2 * Math.PI * radius

   3. class Rectangle extends Shape
        private final double length, breadth
        area      -> length * breadth
        perimeter -> 2 * (length + breadth)

   4. class Square extends Rectangle          <- note: extends Rectangle,
        constructor takes one side               NOT Shape
        implements NOTHING new                   A square IS-A rectangle
                                                 with equal sides, so it
                                                 inherits both methods.


 CONSTRAINTS
     - Shape must be abstract, and area()/perimeter() must be abstract
     - @Override on every implemented method
     - the two methods RETURN a double. Nothing in Shape, Circle or
       Rectangle prints except display()
     - keep every field private final


 TEST IN MAIN

     Shape[] shapes = { new Circle("Circle", 5),
                        new Rectangle("Rectangle", 4, 6),
                        new Square("Square", 3) };

     double total = 0;
     for (Shape s : shapes) {
         s.display();
         total += s.area();
     }
     System.out.println("Total area: " + String.format("%.2f", total));


 EXPECTED OUTPUT

     Circle | area: 78.54 | perimeter: 31.42
     Rectangle | area: 24.00 | perimeter: 20.00
     Square | area: 9.00 | perimeter: 12.00
     Total area: 111.54

 That last line is the payoff. You could not have written it against the
 old version, because area() returned nothing to add up.


 AFTER IT WORKS -- FOUR THINGS TO TRY

   A) Add  Shape s = new Shape("Generic");  to main. It must NOT compile.
      Read the error. Compare it to  new ShapesExample()  in the old file,
      which compiled happily. That difference is the entire lesson.

   B) Add a  class Triangle extends Shape  and implement NEITHER method.
      Read the error, and note that it names the exact methods you missed.
      Now fix it by making Triangle abstract instead -- also legal.
      AbstractClass/Notes PART 4.

   C) In Circle, rename the method to  Area()  with a capital A but leave
      @Override on it. Read that error. Then remove @Override -- now it
      compiles as far as that line, but Circle stops compiling for a
      different reason. Work out why. (Notes PART 4, last paragraph.)

   D) Square extends Rectangle and writes no methods at all. Prove it
      still satisfies the Shape contract by calling square.area(). Then
      explain in one sentence where that implementation came from.

 =========================================================================
*/

public class ShapeArea {

    public static void main(String[] args) {


         Shape[] shapes = { new Circle("Circle", 5),
                            new Rectangle("Rectangle", 4, 6),
                            new Square("Square", 3) };

         double total = 0;
         for (Shape s : shapes) {
             s.display();
             total += s.area();
         }
         System.out.println("Total area: " + String.format("%.2f", total));
    }
}


abstract class Shape {

    private final String name;

    Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void display() {

        System.out.println("Name : "+name+" Area : "+String.format("%.2f", area())+" Perimeter : "+String.format("%.2f", perimeter()));

    }

          abstract double area();
          abstract double perimeter();
}


class Circle extends Shape {

    private final double radius;

    Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI*radius*radius;
    }

    @Override
    double perimeter() {
        return 2*Math.PI*radius;
    }
}


class Rectangle extends Shape {

    private final double length;
    private final double breadth;

    Rectangle(String name, double length, double breadth) {
        super(name);
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    double area() {
        return length*breadth;
    }

    @Override
    double perimeter() {
        return 2*(length+breadth);
    }
}


class Square extends Rectangle {

    Square(String name, double side) {
        super(name, side, side);        // a square IS-A rectangle with
    }// equal sides -- nothing else to do

}
