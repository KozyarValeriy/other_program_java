import java.util.ArrayList;
import java.util.HashSet;

public class Tast1 {

    public HashSet<Integer> checkUnique(ArrayList<Integer> numbers) { // вернуть уникальные элементы
        HashSet<Integer> res = new HashSet<Integer>();
        for (Integer el: numbers) {
            res.add(el);
        }
        return res;
    }

    public int countUnique(HashSet<Integer> numbers) { // вернуть кол-во уникальных элементов
        /*
        HashSet<Integer> res = new HashSet<Integer>();
        for (Integer el: numbers) {
            res.add(el);
        }
         */
        return numbers.size();
    }
}
