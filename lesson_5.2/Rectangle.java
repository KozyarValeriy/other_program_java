public class Rectangle implements Shape{ // реализуем указанный интерфейс
    public String name = "Rectangle";
    public double side1;
    public double side2;

    Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public Double getSquare() {
        return this.side1 * this.side2;
    }

    public String getClassName() {
        return "Rectangle";
    }
}
