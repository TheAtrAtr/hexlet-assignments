package exercise;

// BEGIN
class Segment{
    private Point BeginPoint;
    private Point EndPoint;

    public Segment(Point beginPoint, Point endPoint) {
        BeginPoint = beginPoint;
        EndPoint = endPoint;
    }

    public Point getBeginPoint() {
        return BeginPoint;
    }

    public Point getEndPoint() {
        return EndPoint;
    }

    public Point getMidPoint() {
        Point point1 = getBeginPoint();
        Point point2 = getEndPoint();
        int x = (point1.getX() + point2.getX())/2;
        int y = (point1.getY() + point2.getY())/2;
        return new Point(x, y);
    }
}
// END
