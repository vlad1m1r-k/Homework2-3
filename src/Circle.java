public class Circle extends Shape {
    private Point point1;
    private Point point2;
    private double radius;

    public Circle(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        radius = getDistance(this.point1, this.point2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    private double getDistance(Point point1, Point point2){
        return Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
    }
}
