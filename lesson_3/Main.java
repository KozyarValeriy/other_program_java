import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        //**************************************//
        //******** Работа с ислючениями ********//
        //**************************************//
        /* Считать 10 чисел в список. При вводе символа не числа
         * поймать исключение и требовать дальнейшего ввода,
         * пока не будет введено 10 чисел */
        /*
        int n = 10; // количество чисел в вводе
        ArrayList<Integer> myList = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in); // определяем новый сканер для чтения консоли
        System.out.println("Введите число: ");
        //int numb = 0;
        while (myList.size() < n) {
            try {
                int numb = in.nextInt(); // получить число со ввода
                myList.add(numb);
            } catch (InputMismatchException e) {
                //System.out.println(e);
                System.out.println("Вводите только число!");
                in.nextLine(); // считать ввод и не сохрянять никуда
                //in = new Scanner(System.in); // или переопределяем сканер, так как на входе предыдещго есть не числовой символ
            }
        }
        System.out.println(myList);
        */

        //************************//
        //******** Task 1 ********//
        //************************//
        //* посчитать для каждого слова его кол-во в произведении Война и Мир и вывести топ 50 слов *//
        try {
            //MapReducer mrc = new MapReducer();
            String fileName = "C:\\Kozyar_study\\Java_lessons\\WaP.txt"; // путь к файлу
            String allFile = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
            HashMap<String, Integer> answer = MapReducer.count(allFile);
            ArrayList<String> top20 = MapReducer.topValues(answer, 5);
            System.out.printf("| %-12s | %-6s |\n", "Word", "Count");
            System.out.printf("|%-14s|%-8s|\n", "--------------", "--------");
            for (String word: top20) {
                System.out.printf("| %-12s | %6d |\n", word, answer.get(word));
            }
            System.out.printf("|%-14s|%-8s|\n", "--------------", "--------");
            System.out.printf("| %-12s | %6d |\n", "что-то", answer.get("что-то"));
            System.out.printf("| %-12s | %6d |\n", "как-то", answer.get("как-то"));
            System.out.printf("| %-12s | %6d |\n", "как-нибудь", answer.get("как-нибудь"));
        } catch (IOException e) { // поймать исключение ошибки ввода/вывода
            System.out.println("Error: " + e);
        }



//        LinkedHashMap<String, Integer> abc = new LinkedHashMap<String, Integer>();
//        abc.put("aaa", 10);
//        abc.put("ccc", 8);
//        abc.put("vvv", 4);

        //String abc = "aaa bbb ccc";
        //System.out.println(abc.substring(0,3));


    }
}
