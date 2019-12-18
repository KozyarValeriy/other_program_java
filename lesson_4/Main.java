import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) throws IOException {
        //*************************//
        //******** Отладка ********//
        //*************************//

        /* Отладка с выводом в консоль*/
        /*
        String st1 = "string 1";
        String st2 = "string 2";
        Double ff = 123.112233;
        System.out.printf("Text %s and %s\n", st1, st2); // форматирование строк
        System.out.printf("Double %4.3f\n", ff); // вывод не целого числа
        */

        //***************************//
        //******** Коллекции ********//
        //***************************//
        /*
        HashMap<String, Integer> hmBase = new HashMap<String, Integer>();
        // заполеннеи коллекции
        hmBase.put("Key1", 10);
        hmBase.put("Key2", 12);
        hmBase.put("Key3", 13);
        hmBase.put("Key4", 9);
        hmBase.put("Key5", 1);
        // получить элемент коллекции
        Integer value = hmBase.get("Key1");
        System.out.println(value);
        // перебор ключей коллекции
        for (String key: hmBase.keySet()) {
            System.out.printf("Key: %5s, value: %3d\n", key, hmBase.get(key));
        }
        // проверка, есть ли такой ключ
        if (hmBase.containsKey("Key1")) {
            System.out.println("Key1 here");
        }
        System.out.println();
        // удаление по ключу
        hmBase.remove("Key1");
        for (String key: hmBase.keySet()) {
            System.out.printf("Key: %5s, value: %3d\n", key, hmBase.get(key));
        }
        // очистить коллекцию
        // hmBase.clear();
        // увеличить значение в каком то ключе
        System.out.println();
        hmBase.put("Key2", hmBase.get("Key2") + 1); // если значение есть
        hmBase.put("Key8", hmBase.getOrDefault("Key8", 0) + 1); // проверяет, есть ли значение.
                                                                                // Если есть, то берет его значение, а если нет, вернет 0
        for (String key: hmBase.keySet()) {
            System.out.printf("Key: %5s, value: %3d\n", key, hmBase.get(key));
        }
        */

        //************************//
        //******** Task 1 ********//
        //************************//
        // Отсортировать HashMap по возрасту и зп
        /*
        HashMap<String, String> dict = new HashMap<String, String>();
        dict.put("Иванов", "20,5400,Москва");
        dict.put("Петров", "23,7400,Питер");
        dict.put("Сидоров", "30,2400,Киев");
        dict.put("Кузнецов", "19,1400,Москва");
        dict.put("Васнецов", "40,6000,Киев");
        ArrayList<String> sortString = new ArrayList<String>(dict.keySet()); // записываем сразу все ключи
        int m = 0; // 0 - сортировка по возрасту, 1 - по зп

        // сортировка по возрастанию путем перемещения элементов в массиве (хз, не уверен)
        /*
        for (String key: dict.keySet()) {
            Integer mainInt = Integer.valueOf(dict.get(key).split(",")[m]);
            for (int j = 0; j < sortString.size(); j++) {
                Integer currInt = Integer.valueOf(dict.get(sortString.get(j)).split(",")[m]);
                if (currInt > mainInt) {
                    sortString.remove(key);
                    sortString.add(key);
                    for (int i = sortString.size() - 1; i > j; i--){
                        String tmp = sortString.get(i - 1);
                        sortString.set(i, tmp);
                    }
                    sortString.set(j, key);
                }
            }
        }
        */

        /*
        // сортировка методом выбора
        for (int i = 0; i < sortString.size() - 1; i++) {   // сортировка выбором
            for (int j = i + 1; j < sortString.size(); j++) {
                if (Integer.parseInt(dict.get(sortString.get(i)).split(",")[m]) >
                        Integer.parseInt(dict.get(sortString.get(j)).split(",")[m])) {
                    String tmp = sortString.get(i);
                    sortString.set(i, sortString.get(j));
                    sortString.set(j, tmp);
                }
            }
        }
        */

        // сортировка через переопределение метода сравнения
        /*
        sortString.sort(new Comparator<String>() {
            public int compare(String word1, String word2) {
                return (Integer.parseInt(dict.get(word1).split(",")[m]) -
                            Integer.parseInt(dict.get(word2).split(",")[m]));
            }
        });

        System.out.printf("| %-8s | %-15s |\n", "Key", "Value");
        System.out.printf("|%-10s|%-17s|\n", "----------", "-----------------");
        for (String key: sortString) {
            //System.out.printf("Key: %8s, value: %-15s\n", key, dict.get(key));
            System.out.printf("| %-8s | %-15s |\n", key, dict.get(key));
        }
        */

        // решение преподавателя: добавление минимального элемента в список из оставшегося
        /*
        HashMap<String, String> dict2 = new HashMap<String, String>(dict); // создаем копию HashMap
        ArrayList<String> result = new ArrayList<String>();
        Integer myMin = null;
        String personMinAge = "";

        while (!dict2.isEmpty()) {
            for (String key : dict2.keySet()) {
                String[] splited = dict2.get(key).split(","); // массив по значению, разбитому по запятой
                Integer age = Integer.parseInt(splited[0]); // принимаем первое значение и преобразуем в число
                if ((myMin == null) || (myMin > age)) {
                    myMin = age;
                    personMinAge = key;
                }
            }
            result.add(personMinAge);
            dict2.remove(personMinAge);
            myMin = null;
        }

        System.out.printf("| %-8s | %-4s | %-7s | %-8s |\n", "Key", "Age", "Salary", "City");
        //System.out.printf("| %-8s | %-15s |\n", "Key", "Value");
        System.out.printf("|%-10s|%-6s|%-9s|%-10s|\n", "----------", "------", "---------", "----------");
        for (String key: result) {
            String[] splited = dict.get(key).split(",");
            System.out.printf("| %-8s | %4s | %7s | %8s |\n", key, splited[0], splited[1], splited[2]);
        }
        //        Output:
        //        | Key      | Age  | Salary  | City     |
        //        |----------|------|---------|----------|
        //        | Кузнецов |   19 |    1400 |   Москва |
        //        | Иванов   |   20 |    5400 |   Москва |
        //        | Петров   |   23 |    7400 |    Питер |
        //        | Сидоров  |   30 |    2400 |     Киев |
        //        | Васнецов |   40 |    6000 |     Киев |
        */

        //**************************************//
        //******** Регулярные выражения ********//
        //**************************************//
        String fileName = "C:\\Kozyar_study\\Java_lessons\\file_les_4.txt"; // путь к файлу
        String allFile = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);

        //String target = "[-]?[0-9]+\\.[0-9]+"; // любое дробное число с точкой и, если есть, знак -
        String target = "[-]?[\\d]+\\.[\\d]+"; // любое дробное число с точкой и, если есть, знак -

        final Pattern pattern = Pattern.compile(target, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(allFile);

        while (matcher.find()) {
            //System.out.println("Full match: " + matcher.group(0));
            System.out.printf("Full match: %10s\n", matcher.group(0));
        }


    }
}
