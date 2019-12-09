import java.util.ArrayList;
import java.util.Random;

public class First {
    public static void main (String args[]) {

        ArrayList<Integer> myList = new ArrayList<Integer>();
        final Random random = new Random();
        for (int i = 0; i < random.nextInt(10) + 10; i++) {
            myList.add(random.nextInt(500));
        }
        System.out.println(myList);
        minMax(myList);

        System.out.println("Second task");
        int[] numbers = new int[10];
        numbers[0] = 1; // 1, 2, 3, 5, 6, 9
        numbers[1] = 5;
        numbers[2] = 6;
        numbers[3] = 1;
        numbers[4] = 2;
        numbers[5] = 3;
        numbers[6] = 5;
        numbers[7] = 6;
        numbers[8] = 9;
        numbers[9] = 1;
        int answer = checkUnique(numbers);
        System.out.println(answer);
        
        //Integer a = 22;
        //Integer b = 7;
        //double ans = a.doubleValue() / b.doubleValue();
        //System.out.println();
        //System.out.println(ans);
    }

    public static void minMax(ArrayList<Integer> newList) {
        Integer minValue = newList.get(0);
        Integer maxValue = newList.get(0);
        for (Integer numb: newList) {
            if (numb > maxValue) {
                maxValue = numb;
            }
            if (numb < minValue) {
                minValue = numb;
            }
        }
        System.out.println("Min: " + minValue.toString());
        System.out.println("Max: " + maxValue.toString());
    }


    public static int checkUnique(int[] numbers) {
        /*
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }

        for (int numb: numbers) {
            System.out.print(numb);
            System.out.print(" ");
        }
        System.out.println();

        int answer = numbers.length;
        int[] tmp = new int[numbers.length];

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if ((numbers[i] == numbers[j])) {
                    if (i > 0) {
                        if (numbers[i] > numbers[i - 1]) {
                            answer--;
                        }
                    } else {
                        answer--;
                    }
                }
            }
        }
        return answer;
        
        int answer = 0;
        int[] tmp = new int[10];

        for (int i = 0; i < numbers.length ; i++) {
            tmp[numbers[i] - 1] = 1;
        }
        for (int i = 0; i < tmp.length ; i++) {
            answer = answer + tmp[i];
        }
        */
        int answer = 0;
        boolean flag = true;
        for (int i = 0; i < numbers.length; i++) {
            flag = true;
            for (int j = i + 1; j < numbers.length; j++) {
                if ((numbers[i] == numbers[j])) {
                    flag = false;
                }
            }
            if (flag) {
                answer++;
            }
        }
        return answer;
    }

    public void printNumbers(int x) {
        for (int i = 1; i <= x; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println("Hello world");
            } else if (i % 3 == 0) {
                System.out.println("Hello");
            } else if (i % 5 == 0) {
                System.out.println("world");
            } else {
                System.out.println(i);
            }

            //switch (i%3) {
            //    case 0:
            //        System.out.println("QWE");
            //        break;
            //}
        }
    }
}

