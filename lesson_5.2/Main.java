import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //**************************************//
        //******** Работа с интерфейсом ********//
        //**************************************//

        // создаем список с типом интерфейса, чтобы вписать туда все объекты
        ArrayList<Shape> shape = new ArrayList<Shape> ();
        Circle circle1 = new Circle(10);
        Circle circle2 = new Circle(8);
        Circle circle3 = new Circle(12);
        Rectangle rec1 = new Rectangle(8, 12);
        Rectangle rec2 = new Rectangle(6, 13);

        // можем добавлять только объекты, которые реализую интерфейс Shape
        shape.add(circle1);
        shape.add(circle2);
        shape.add(circle3);
        shape.add(rec1);
        shape.add(rec2);

        //System.out.printf("Sum square: %6.3f\n", getSquare(shape)); // суммарная площадь фигур

        getInfo(shape); // получение статискити по фигурам в списке

    }

    public static Double getSquare(ArrayList<Shape>  allShape) {
        //******************************************************//
        //******** Вывести суммарную площадь всех фигур ********//
        //******************************************************//
        Double answer = 0.0;
        for (Shape fig: allShape){
            answer += fig.getSquare();
        }
        return answer;
    }

    public static void getInfo(ArrayList<Shape>  allShape) {
        //********************************************************//
        //******** Вывести статистику по классам в списке ********//
        //********************************************************//

        HashMap<String, Integer> stat = new HashMap<String, Integer>();
        for (Shape fig: allShape){
            //String key = fig.getClass().toString().split(" ")[1];     // получаем имя класса
            String key = fig.getClassName();                            // получаем имя класса через интерфейс
            stat.put(key, stat.getOrDefault(key, 0) + 1);   // записать (текущее значение или 0) + 1
        }

        System.out.printf("| %-10s | %-5s |\n","Shape", "Count");       // вывод шапки
        System.out.printf("|%-12s|%-7s|\n","------------", "-------");
        for (String key: stat.keySet()) {
            System.out.printf("| %-10s | %5s |\n",key, stat.get(key));
        }
    }
}
