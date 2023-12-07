import java.awt.*;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Line line1 = new Line("Red", 5.0);
        Line line2 = new Line("Blue", 5.0);

        Rectangle rectangle1 = new Rectangle("Green", 4.0, 3.0);
        Rectangle rectangle2 = new Rectangle("Yellow", 4.0, 3.0);

        Dot dot1 = new Dot(0,0);
        Dot dot2 = new Dot(3,4);

        Circle circle1 = new Circle(0, 0, 5.0, "Red");
        Circle circle2 = new Circle(8, 0, 4.0, "Blue");


        //lines
        System.out.println("Comparing lines:");
        System.out.println("line1 and line2 are equal: " + line1.compare(line2));

        System.out.println("\nComparing rectangles:");
        System.out.println("rectangle1 and rectangle2 are equal: " + rectangle1.compare(rectangle2));

        //rectangle
        System.out.println("\nCalculating areas and perimeters:");
        System.out.println("Area of rectangle1: " + rectangle1.area());
        System.out.println("Perimeter of rectangle2: " + rectangle2.perimeter());

        //dots
        System.out.println("\ndot1=>" +dot1);
        System.out.println("dot2=>" +dot2);
        System.out.println("equals=>" +dot1.equals(dot2));
        System.out.println("distances=>" +dot1.distance(dot2));

        //circles
        System.out.println("Comparing circles:");
        System.out.println("circle1 and circle2 are equal: " + circle1.compare(circle2));

        System.out.println("\nCalculating areas and perimeters:");
        System.out.println("Area of circle1: " + circle1.area());
        System.out.println("Perimeter of circle2: " + circle2.perimeter());

        System.out.println("\nChecking intersection:");
        System.out.println("Circle1 and circle2 intersect: " + circle1.intersection(circle2));

    }
}
