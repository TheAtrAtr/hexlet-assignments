package exercise;

// BEGIN
class Circle {
    Point point;
    int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0)
            throw new NegativeRadiusException("");
        else
            return 3.14159 * radius * radius;
    }
}
// END
