import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
		//************************//
        //******** Task 1 ********//
        //************************//
        /* Выполнить уравнение, которое подается на вход. Все числа однозначные 
			Решение №2
		*/
        String equation = "3-5*6+1";
        ArrayList<String> numbers = new ArrayList<String>(Arrays.asList(equation.split("")));
        System.out.println(numbers);
        //System.out.println(solver(numbers, 3));
        String[] operators = {"*", "-", "+"};

        for (String oper: operators) {
            while (numbers.contains(oper)) {
                numbers = solver(numbers, numbers.indexOf(oper));
            }
        }
        System.out.println(numbers);
    }

    public static ArrayList<String> solver (ArrayList<String> input_list, int pos) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < pos - 1; i++){
            result.add(input_list.get(i));
        }
        Integer x1 = Integer.parseInt(input_list.get(pos - 1));
        Integer x2 = Integer.parseInt(input_list.get(pos + 1));
        if (input_list.get(pos).equals("*")) {
            result.add(String.valueOf(x1 * x2));
        } else if (input_list.get(pos).equals("+")) {
            result.add(String.valueOf(x1 + x2));
        } else {
            result.add(String.valueOf(x1 - x2));
        }
        for (int i = pos + 2; i < input_list.size(); i++){
            result.add(input_list.get(i));
        }
        return result;
    }
}
