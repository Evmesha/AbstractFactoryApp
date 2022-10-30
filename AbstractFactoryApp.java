abstract class AbstractFactory {
    abstract Shape getShape(String shape) ;
}
 class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {

        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();

        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }

        return null;
    }
}
class RoundedShapeFactory extends AbstractFactory{
    @Override
    Shape getShape(String form) {
        if (form == null) {
            return null;
        }
        if (form.equalsIgnoreCase("ROUNDED RECTANGLE")) {
            return new RoundedRectangle();

        } else if (form.equalsIgnoreCase("ROUNDED SQUARE")) {
            return new RoundedSquare();
        }

        return null;
    }
}
class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {

        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        }
        else if(choice.equalsIgnoreCase("FORM")){
            return new RoundedShapeFactory();
        }
        return null;
    }
}
interface Shape {
    void draw();
}
class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Draw a Rectangle");
    }
}
class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Draw a Square");
    }
}
 class RoundedRectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Draw a Rounded Rectangle");
    }
}

 class RoundedSquare implements Shape{
    @Override
    public void draw() {
        System.out.println("Draw a Rounded Square");
    }
}

public class AbstractFactoryApp {

    public static void main(String[] args) {

        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        Shape shape1 = shapeFactory.getShape("RECTANGLE");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();

        AbstractFactory formFactory = FactoryProducer.getFactory("FORM");

         Shape shape3 = formFactory.getShape("ROUNDED SQUARE");
        shape3.draw();

        Shape shape4 = formFactory.getShape("Rounded rectangle");
        shape4.draw();
    }
}