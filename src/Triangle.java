public class Triangle extends Shape {
    private Point point1;
    private Point point2;
    private Point point3;
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        sideA = getDistance(this.point1, this.point2);
        sideB = getDistance(this.point2, this.point3);
        sideC = getDistance(this.point3, this.point1);
    }

    @Override
    public double getPerimeter() {
        return getDistance(point1, point2) + getDistance(point2, point3) + getDistance(point3, point1);
    }

    @Override
    public double getArea() {
        double halfPerimeter = getPerimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }

    private double getDistance(Point point1, Point point2){
        return Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
    }
}
