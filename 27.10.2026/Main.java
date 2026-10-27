abstract class Shape {
    public abstract double getArea();
    public abstract double getPerimeter();
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}


class Triangle extends Shape {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }
}

class ShapeUtils {
    public static double totalArea(Circle circle, Rectangle Rectangle, Triangle triangle) {
        return circle.getArea() + Rectangle.getArea() + triangle.getArea();
    }

    public static double totalPerimeter(Circle circle, Rectangle Rectangle, Triangle triangle) {
        return circle.getPerimeter() + Rectangle.getPerimeter() + triangle.getPerimeter();
    }

    public static double totalArea(Shape[] shapes) {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.getArea();
        }
        return sum;
    }

    public static double totalPerimeter(Shape[] shapes) {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.getPerimeter();
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(3);
        Rectangle rectangle = new Rectangle(4,5);
        Triangle triangle = new Triangle(3, 4, 5);

        System.out.printf("Круг: S = %.2f, P = %.2f\n", circle.getArea(), circle.getPerimeter());
        System.out.printf("Квадрат: S = %.2f, P = %.2f\n", rectangle.getArea(), rectangle.getPerimeter());
        System.out.printf("Треугольник: S = %.2f, P = %.2f\n", triangle.getArea(), triangle.getPerimeter());

        System.out.printf("Сумма S = %.2f, сумма P = %.2f\n", ShapeUtils.totalArea(circle, rectangle, triangle), ShapeUtils.totalPerimeter(circle, rectangle, triangle));

        Shape[] shapes = {circle, rectangle, triangle};
        System.out.printf("Сумма S = %.2f, сумма P = %.2f\n", ShapeUtils.totalArea(shapes), ShapeUtils.totalPerimeter(shapes));
    }
}
