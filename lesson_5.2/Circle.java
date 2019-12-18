public class Circle implements Shape{ // реализуем указанный интерфейс
    public String name = "Circle";
    public double radius;

    Circle (double radius) {
        this.radius = radius;
    }

    public Double getSquare() {
        return this.radius * this.radius * 3.14;
    }

    public String getClassName() {
        return "Circle";
    }
}
