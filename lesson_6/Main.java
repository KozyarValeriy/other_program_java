import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //************************//
        //******** Task 1 ********//
        //************************//
        /* Умножить большое число (большое для Integer и Long) на однозначное*/

        /* Начальные условия */
        /*
        Scanner in = new Scanner(System.in); // определяем новый сканер для чтения консоли
        System.out.println("Input first number: "); // Большое число
        String longNumber = in.nextLine();
        System.out.println("Input second number: "); // однозначное число
        Integer shortNumber = in.nextInt();

        StringBuilder answer = new StringBuilder();
        Integer toNext = 0;
        */
        /* Решение без использования коллекции */
        /*
        for (int i = longNumber.length() - 1; i >= 0; i--) {
            Integer currInt = Integer.parseInt(String.valueOf(longNumber.charAt(i)));
            currInt = currInt * shortNumber; // умножение на требуемое число
            currInt += toNext; // добавление остатка от предыдущего числа
            toNext = currInt / 10;  // получение нового остатка для следующей итерации
            currInt = currInt % 10; // получаем текущее число для ответа
            answer.append(currInt.toString()); // добавление в строку (строка в обратном порядке)
        }
        if (toNext > 0) {
            answer.append(toNext.toString()); // добавление остатка, если он есть
        }
        answer = answer.reverse(); // разворачиваем строку, так как запись была в обратном порядке.
        System.out.println(answer);
        */

        /* Решение через коллекции */
        /*
        ArrayList<Integer> input = new ArrayList<Integer>();

        for (int i = 0; i < longNumber.length(); i++) {
            input.add(Integer.parseInt(String.valueOf(longNumber.charAt(i))));
        }

        for (int i = input.size() - 1; i >= 0; i--) {
            Integer currInt = input.get(i) * shortNumber; // умножение на требуемое число
            currInt += toNext; // добавление остатка от предыдущего числа
            toNext = currInt / 10;  // получение нового остатка для следующей итерации
            currInt = currInt % 10; // получаем текущее число для ответа
            answer.append(currInt.toString()); // добавление в строку (строка в обратном порядке)
        }
        if (toNext > 0) {
            answer.append(toNext.toString()); // добавление остатка, если он есть
        }
        answer = answer.reverse(); // разворачиваем строку, так как запись была в обратном порядке.
        System.out.println(answer);
        */

        //******************************************//
        //******** Стримы (Stream) и лямбда ********//
        //******************************************//
        //HashMap<Integer, String> hm = new HashMap<Integer, String>();
        /*
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.add(5);
        al.add(7);
        al.add(8);
        al.add(11);

        Stream<Integer> streamFromArrayList = al.stream(); // получение стрима
        System.out.println(streamFromArrayList.collect(Collectors.toList())); // вывод на печать

        Long count = al.stream().filter(x -> x%2 != 0).count(); // кол-во нечетных элементов
        al.forEach(x -> System.out.printf("| %s |", x)); // выполнение для каждого элемента
        System.out.println();

        List<Integer> ans = al.stream().filter(x -> x%2 != 0).limit(2).collect(Collectors.toList()); // получение первых двух нечетных элементов
        System.out.println(ans);
        Integer max = al.stream().max((x1, x2) -> x1 - x2).get(); // получение максимума
        System.out.printf("Max: %d\n", max);

        Integer sample = al.stream().skip(2).findFirst().orElse(1);
        System.out.println(sample);

        Stream<Integer> sample2 = al.stream().parallel().map(x -> x * 2); // увеличение всех элементов в 2 раза
        System.out.println(sample2.collect(Collectors.toList()));

        List<Integer> ans2  = al.stream().parallel().map(x -> x * 2).peek((e) -> System.out.print("," + e)).collect(Collectors.toList());
        System.out.println();

        System.out.println(al.stream().filter(x -> x%2 == 0).mapToInt(x -> x).sum()); // сумма четных элементов

        System.out.println(al.stream().filter(x -> x>10 && x%2 != 0).collect(Collectors.toList())); // получить все нечетные элементы больше 10

        String h = "abcdr";
        System.out.println(h.substring(1));

        Integer sum = al.stream().reduce((s1, s2) -> s1 + s2).orElse(0); // получение суммы всех элементов или ноль
        // или
        sum = al.stream().reduce(Integer::sum).orElse(-1); // получение суммы всех элементов или -1
        System.out.println(sum);

        // разделить на четные и нечетные числа
        Map<Boolean, List<Integer>> sample3 = al.stream().collect(Collectors.partitioningBy(p -> p%2 == 0));
        for (boolean key: sample3.keySet()) {
            System.out.printf("Key: %s, value: %s\n", key, sample3.get(key).toString());
        }
        */

        //************************//
        //******** Task 2 ********//
        //************************//
        /*  */




    }
}
