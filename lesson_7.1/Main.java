import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //*************************//
        //******** Task_1 ********//
        //*************************//
        /*
        * первая строка - сумма
        * вторая строка - допустимые банкноты
        * Требуется найти наименьшее число банкнот для получения требуемой суммы */

        Scanner in = new Scanner(System.in); // определяем новый сканер для чтения консоли
        System.out.println("Введите число: ");
        //Integer start = in.nextInt();
        Integer start = 1064;

        System.out.println("Введите допустимые банкноты: ");
        in = new Scanner(System.in);
        //String input = in.nextLine();
        //String[] banknotes = input.split(",");
        String[] banknotes = "1,7,9,10,20,40,100,200,250".split(",");

        ArrayList<Integer> banknotesInt = new ArrayList<Integer>(); // все банкноты - целые числа. Переводим в список
        for (String banks: banknotes) {
            banknotesInt.add(Integer.parseInt(banks));
        }

        ArrayList<Integer> answer = calcChanges(start, banknotesInt);
        System.out.println(answer);
        System.out.printf("Sum is: %d, count is: %d\n", answer.stream().mapToInt(x -> x).sum(), answer.size());

    }

    public static ArrayList<Integer> calcChanges(Integer aim, ArrayList<Integer> banknotes) {
        ArrayList<Integer> F = new ArrayList<Integer>(); // минимальное кол-во банкнот для реализации суммы n
        final int INF = 10000000;        // число, которо означает, что данную сумму реализовать нельзя
        F.add(0);                        // нулевой элемент - 0, так как для реализации 0 требуется 0 банкнот
        for (int m = 1; m <= aim; m++) { // перебираем все числа от 1 до требуемого числа
            F.add(INF);                  // сначала предпологаем, что данное число реализовать нельзя
            for (Integer banknote: banknotes) { // проходим по всем банкнотам
                // если число больше текущей банкноты и получение (суммы минус эта банкнота + 1) меньше, чем текущее значение, переписывам
                if ((m >= banknote) && (F.get(m - banknote) + 1 < F.get(m))) {
                    F.set(m, F.get(m - banknote) + 1);
                }
            }
        }
        ArrayList<Integer> answer = new ArrayList<Integer>(); // список требуемых банкнот
        while (aim > 0) { // пока целевое значение больше нуля
            for (Integer banknote : banknotes) { // проходим по всем банкнотам
                // если для получения целевого значения минус текущая банкнота требуется
                // столько же банкнот, как и для текущего целевого значения минус 1, то выбираем эту банкноту
                if (F.get(aim - banknote) == F.get(aim) - 1) {
                    answer.add(banknote);
                    aim -= banknote; // уменьшаем текущее целевое значение
                    break;
                }
            }
        }
        return answer;
    }
}