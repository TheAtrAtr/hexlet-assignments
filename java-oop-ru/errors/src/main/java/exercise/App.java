package exercise;

// BEGIN
class App {
    public static void printSquare(Circle circle) {
        try {
            System.out.printf("%.0f\nВычисление окончено", circle.getSquare());

        } catch (Exception e) {
            System.out.println("Не удалось посчитать площадь\nВычисление окончено");
        }
    }

    public static void main(String[] args) {
        Point point = new Point(5, 7);
        Circle circle = new Circle(point, 5);
        App.printSquare(circle);
// => "50"
// => "Вычисление окончено"

        Circle circle1 = new Circle(point, -2);
        App.printSquare(circle1);
// => "Не удалось посчитать площадь"
// => "Вычисление окончено"
    }
}
// END
