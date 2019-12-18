import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapReducer {
    public static HashMap<String, Integer> count(String allFile) { // подсчет кол-ва всех символов в строке
        HashMap<String, Integer> answer = new HashMap<String, Integer>();

        /* решение через регулярные выражения */
        String target = "[а-яА-Яa-zA-Z\\-]+"; // любой символ буквы одни или более раза
        //String target = "[а-яА-Яa-zA-Z]+[-]?[а-яА-Яa-zA-Z]{0,100}"; // любой символ буквы одни или более раза

        Pattern pattern = Pattern.compile(target);
        Matcher matcher = pattern.matcher(allFile);
        while (matcher.find()) { // пока есть совпадение
            int start = matcher.start(); // начальный символ совпадающего слова
            int end = matcher.end(); // конечный символ совпадающего слова
            String word = allFile.substring(start, end); // получаем слово от начального до конечного символа
            //if (word.compareTo("—") == 0 || word.compareTo("") == 0) break;
            answer.merge(word, 1, Integer::sum); // если символа нет, написать 1, если есть, суммирует с его значением
            //answer.put(word, answer.getOrDefault(word, 0) + 1); // тоже самое, что и выше
        }

        /* решение без регулярных выражений */
        /*
        allFile = allFile.replace(",", " ").replace(".", " ");
        allFile = allFile.replace("(", " ").replace(")", " ");
        allFile = allFile.replace("[", " ").replace("]", " ");
        allFile = allFile.replace("!", " ").replace("?", " ");
        allFile = allFile.replace(":", " ").replace(";", " ");
        allFile = allFile.replace("\"", " ").replace("«", " ");
        allFile = allFile.replace("»", " ").replace("…", " ");
        allFile = allFile.replace("\n", " ");
        String[] fileToMass = allFile.split(" ");
        for (String word: fileToMass) {
            word = word.trim();
            if (word.compareTo("—") == 0 || word.compareTo("") == 0) continue;
            answer.put(word, answer.getOrDefault(word, 0) + 1);
        }
        */

        return answer;
    }

    public static ArrayList<String> topValues(HashMap<String, Integer> dict, int n) { // возвращает топ n наиболее частых значений
        /* Решение путем пересатновок в списке ограниченного размера
        * На первом месте всегда слово, которое наиболее часто встречается */
        ArrayList<String> ans = new ArrayList<String>();
        for (String key: dict.keySet()) {
            if (ans.size() < n) { // если меньше n, то заполняем список
                ans.add(key);
            } else { // если список уже полон
                for (int j = 0; j < n; j++) {
                    if (dict.get(key) > dict.get(ans.get(j))) { // если есть значение больше, чем в списке
                        for (int i = n - 1; i > j; i--){ // двигаем все значения вправо от текущего
                            String tmp = ans.get(i - 1);
                            ans.set(i, tmp);
                        }
                        ans.set(j, key); // вставляем в текущее значение новый элемент
                        break;
                    }
                }
            }
        }

        /* Решение при помощи сортировки всего списка слов */
        /*
        ArrayList<String> ans = new ArrayList<String>(dict.keySet());
        Collections.sort(ans, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return (dict.get(word2) - dict.get(word1));
            }
        });
         */

        return ans;
    }

}
