public class Rectangle extends Shape {
    private Point point1;
    private Point point2;
    private double sideA;
    private double sideB;

    public Rectangle(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        sideA = Math.abs(this.point1.getX() - this.point2.getX());
        sideB = Math.abs(this. point1.getY() - this.point2.getY());
    }

    @Override
    public double getPerimeter() {
        return (sideA + sideB) * 2;
    }

    @Override
    public double getArea() {
        return sideA * sideB;
    }
}
