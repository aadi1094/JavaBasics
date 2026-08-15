package OOPS.Polymorphism;

public class ShapesExample {
    void area(){
        System.out.println("This is the shape class example");
    }
}

 class Square extends ShapesExample{
    void area(){
        System.out.println("Square area is side*side");
    }
}

class Circle extends ShapesExample{
    void area(){
        System.out.println("Circle area is 3.14*r*r");
    }
}

class Rectangle extends ShapesExample{
    void area(){
        System.out.println("Rectangle area is l*b");
    }

    public static void main(String[] args) {
        ShapesExample shape = new ShapesExample();
        shape.area();

        Circle circle = new Circle();
        circle.area();

        Square square = new Square();
        square.area();

        Rectangle rectangle= new Rectangle();
        rectangle.area();

        ShapesExample shape1= new Circle();
        shape1.area();
    }
}



