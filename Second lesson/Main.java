import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        //**************************************//
        //******** Работа со множеством ********//
        //*************************************//
        /*
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(5); // добавление новых значений
        hs.add(5);
        hs.add(6);
        hs.add(1);

        System.out.println(hs);
        System.out.println(hs.size()); // размер коллекции
        hs.remove(6);  // удалить значение 6

        System.out.println(hs);
        System.out.println(hs.contains(6)); // содержит ли элемент 6
        for (Integer el: hs) { // вывод по одному элементу
            System.out.print(el);
            System.out.print(" - ");
            System.out.println(el.hashCode()); // узнать хэш элемента
        }
        hs.clear(); // очистить множество
        */

        //*******************************************//
        //******** Работа с другими классами ********//
        //*******************************************//
        /*
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(107);
        MyClass mc = new MyClass();
        ArrayList<Integer> out = mc.func1(arr1);
        System.out.println(out);
        */

        //************************//
        //******** Task 1 ********//
        //************************//
        /* получить кол-во уничкальных элементов и сами уникальные элементы в массиве */
        /*
        Random ran = new Random(); // создание экземпляра класса Random
        Integer[] numbers = new Integer[ran.nextInt(10) + 10]; // заполнение массива случайными числами
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = ran.nextInt(10);
        }
        ArrayList<Integer> data = new ArrayList<Integer>(Arrays.asList(numbers)); // преобразование массива в ArrayList
        //for (int el: numbers) { // тоже преобразование массива в ArrayList, но с использованием цикла
        //    data.add(el);
        //}
        Tast1 task = new Tast1(); // создание экземпляра своего класса
        System.out.println(data);
        HashSet<Integer> all = task.checkUnique(data);
        int count = task.countUnique(all);
        System.out.println(count);
        System.out.println(all);
        */

        //************************//
        //******** Task 2 ********//
        //************************//
        /* развернуть входное число без использования строк: in: 123456 out: 654321 */
        /*
        Scanner in = new Scanner(System.in); // создание экземпляра класса для сканирования ввода в консоль
        System.out.println("Введите число: ");
        //int numb = in.nextInt(); // считать из консоли число int
        int numb = 123456;

        // ------ Решение без списка ------ //
        int x = numb;
        int ans = 0;
        while (x >= 10) { // пока число больше 10
            ans = ans * 10 + (x%10); // увеличиваем результат на 10 и добавляем остаток от деления
            x = x / 10; // уменьшаем исходное число
        }
        ans = ans * 10 + x; // добавляем последний остаток от деления на 10
        System.out.println(ans);

        // ------ Решение через список ------ //
        int x2 = numb;
        ArrayList<Integer> ans2 = new ArrayList<Integer>();
        while (x2 >= 10) { // пока число больше 10
            ans2.add(x2%10);
            x2 = x2 / 10; // уменьшаем исходное число
        }
        ans2.add(x);
        int ans3 = 0;
        for (int i = 0; i < ans2.size(); i++) {
            ans3 +=  ans2.get(i) * Math.pow(10, ans2.size() - 1 - i);
        }
        System.out.println(ans3);
         */

        //************************************//
        //******** Работа со строками ********//
        //************************************//
        /*
        String st = "Hello, world";
        System.out.println(st);
        st = "end";         // создается новый объект String
        System.out.println(st);

        st = "Hello, world";
        String st2 = st.substring(7,st.length()); // возарвщвет подстроку
        System.out.println(st2);
        String st3 = st.replace(", ", "-"); // замена первого значения на второе значение в строке
        System.out.println(st3);
        String st4 = st + st; // сложение строк
        System.out.println(st4);
        Integer pos = st.indexOf(","); // поиск подстроки в строке
        System.out.println(pos);
        System.out.println(st.length()); // длина строки


        String[] stList = st.split(", "); // разбиение строки по символу
        for (String el: stList) {
            System.out.print(el);
        }
        */

        //**********************************//
        //******** Работа с файлами ********//
        //**********************************//
        /*
        try {
            String fileName = "C:\\Kozyar_study\\Java_lessons\\file_les_2.txt"; // путь к файлу
            String allFile = new String(Files.readAllBytes(Paths.get(fileName)), "UTF8"); // создать строку из потока байт файла с кодировкой utf-8
                                                                                                      // тение всего файла в одну строку
            System.out.println(allFile);
        } catch (IOException e) { // поймать исключение ошибки ввода/вывода
            System.out.println("Error: " + e);
        }
        */

        //************************//
        //******** Task 3 ********//
        //************************//
        /* инвертировать относительно 9: то есть в сумме должно получиться 999(9) - типа in: 123456, out: 876543 */
        /*
        Scanner in = new Scanner(System.in); // создание экземпляра класса для сканирования ввода в консоль
        System.out.println("Введите число: ");
        int numb = in.nextInt(); // считать из консоли число int
        //int numb = 123456789;

        // ------ С использованием строк ------ //
        String numbStr = Integer.toString(numb);
        int ans = -1;
        ans += Math.pow(10, numbStr.length()); // получаем число на 1 порядок больше минус 1
        ans = ans - numb;
        System.out.println(ans);

        // ------ Без библиотеки Math ------ //
        //int tmp1 = 0;
        //for (int i = 0; i < numbStr.length(); i++) {
        //    tmp1 = tmp1*10 + 9;
        //}
        //tmp1 = tmp1 - numb;
        //System.out.println(tmp1);

        // ------ Без использования строк ------ //
        int tmp = 10;
        while (numb%tmp != numb) { // получаем число на 1 порядок больше
            tmp *= 10;
        }
        tmp -= 1;
        tmp = tmp - numb;
        System.out.println(tmp);
        */

        //************************//
        //******** Task 4 ********//
        //************************//
        /* Создать класс Person с возрастом, зарплатой и именем
         * Создать 5 экземпляров класса
         * отсортировать по атрибуту возраст (age) */

        // создание 5 экземпляров класса
        Person p1 = new Person(25, 50000, "Valeriy");
        Person p2 = new Person(30, 60000, "Petr");
        Person p3 = new Person(20, 20000, "Evgeniy");
        Person p4 = new Person(18, 70000, "Sergey");
        Person p5 = new Person(29, 65000, "Oleg");
        // создание и заполнение списка
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);
        // вывод до сортировки
        System.out.println("Before sorting");
        System.out.printf("| %-10s | %-5s | %-8s |\n", "Name", "Age", "Salary");
        System.out.printf("|-------------------------------|\n");
        for (Person p: people) {
            System.out.printf("| %-10s | %5d | %8d |\n", p.name, p.age, p.salary);
            //System.out.printf("%-10s age: %d, salary: %d\n", p.name, p.age, p.salary);
        }
        System.out.printf("---------------------------------\n");
        // ------ С использованием коллекций ------ //
        // сортировка путем добавления метода сравнения элементов
        Collections.sort(people, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return (p1.age - p2.age);
            }
        });
        // вывод результата после сортировки
        System.out.println("After sorting (age)");
        System.out.printf("| %-10s | %-5s | %-8s |\n", "Name", "Age", "Salary");
        System.out.printf("|-------------------------------|\n");
        for (Person p: people) {
            System.out.printf("| %-10s | %5d | %8d |\n", p.name, p.age, p.salary);
            //System.out.printf("%-10s age: %d, salary: %d\n", p.name, p.age, p.salary);
        }

        // ------ Без использования коллекций ------ //
        /*
        for (int i = 0; i < people.size() - 1; i++) {   // сортировка выбором
            for (int j = i + 1; j < people.size(); j++) {
                if (people.get(i).age > people.get(j).age) {
                    Person tmp = people.get(i);
                    people.set(i, people.get(j));
                    people.set(j, tmp);
                }
            }
        }
        System.out.println("After sorting");
        for (Person p: people) {
            System.out.printf("%-10s age: %d, salary: %d\n", p.name, p.age, p.salary);
        }
        */
    }
}