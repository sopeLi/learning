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
    }
}