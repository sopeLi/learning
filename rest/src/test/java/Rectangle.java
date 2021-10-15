import java.util.stream.IntStream;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2.0;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5.2, 6.5);
        System.out.println("面积：" + rectangle.getArea());
        System.out.println("周长：" + rectangle.getPerimeter());
        IntStream.range(-15, 15).map(y -> -y).forEach(y -> IntStream.range(-30, 30).forEach(x -> System.out.print(Math.pow(Math.pow((x * 0.05), 2) + Math.pow((y * 0.1), 2) - 1, 3) - Math.pow(x * 0.05, 2) * Math.pow(y * 0.1, 3) <= 0 ? "love".charAt(Math.abs((y - x) % 4)) : " " + (x == 29 ? "\n" : ""))));

    }
}