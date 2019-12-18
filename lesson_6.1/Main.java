import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
		//************************//
        //******** Task 1 ********//
        //************************//
        /* Выполнить уравнение, которое подается на вход. Все числа однозначные */

        String pattern_1 = "\\d+[*]\\d+";
        String pattern_2 = "[-]?\\d+[+|-]\\d+";

        Scanner in = new Scanner(System.in);
        //String equation = in.nextLine(); // уравение
        // String equation = "5+2+6-5*4*5";
        String equation = "5*5*5";
        String forAnswer = equation; // сохраняем начальное уравннеие для ответа
        Pattern pattern = Pattern.compile(pattern_1);
        while (equation.contains("*")) { // пока строка содержит знак *
            Matcher matcher = pattern.matcher(equation);
            while (matcher.find()) {
                String curr = matcher.group(0); // получаем текущее совпадение
                String[] numbers = curr.split("\\*"); // разбиваем по знаку *
                Integer answer = Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]); // выполняем действие
                equation = equation.replace(curr, answer.toString()); // заменяем выражение на ответ в начальное строке
            }
        }
        //System.out.println(equation);
        pattern = Pattern.compile(pattern_2); // получаем новый паттерн
        while (equation.contains("+") || equation.substring(1).contains("-")) { // пока выражение содержит + или - (но не на первой позиции)
            Matcher matcher = pattern.matcher(equation);
            matcher.find();
            String curr = matcher.group(0);
            Integer tmp = 0;
            if (curr.contains("+")) {
                String[] numbers = curr.split("\\+");
                tmp = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
            } else {
                if (curr.startsWith("-")) {
                    String[] numbers = curr.substring(1).split("-");
                    tmp = -Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1]);
                } else {
                    String[] numbers = curr.split("-");
                    tmp = Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1]);
                }
            }

            if ((curr.startsWith("-") && tmp > 0) && (equation.indexOf(curr) > 0)) {
                equation = equation.substring(0, equation.indexOf(curr) - 1) + "+" +
                            equation.substring(equation.indexOf(curr) + curr.length());
               // System.out.println("asdasd");

            } else if ((!curr.startsWith("-") && tmp < 0) && (equation.indexOf(curr) > 0)) {
                equation = equation.substring(0, equation.indexOf(curr) - 1) + "-" +
                        equation.substring(equation.indexOf(curr) + curr.length());
              //  System.out.println("aaaaaaaad");
            }
            //else {
            //    equation = equation.replace(curr, tmp.toString()); // в итоге выражение сводится к одному числу
            //}
            equation = equation.replace(curr, tmp.toString()); // в итоге выражение сводится к одному числу

        }
        System.out.printf("%s = %s", forAnswer, equation);
    }
}
