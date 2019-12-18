import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //**********************************//
        //******** Связь ManyToMany ********//
        //**********************************//
        /* Есть книги и люди, которые их читают. Надо вывести статискитику по книгам, кто сейчас их читает
         * Одну книгу могут читать много людей (много экземпляров).
         */
        // определяем экземпляры книг и читателей
        Book book1 = new Book("Война и мир");
        Book book2 = new Book("Мастер и Маргарита");
        Book book3 = new Book("12 стульев");
        Book book4 = new Book("Человек неведимка");

        Reader re1 = new Reader("АБВ");
        Reader re2 = new Reader("РЕА");
        Reader re3 = new Reader("ЗАР");

        /* Решение 1. Использовать словарь - ключи это книги, значения - читатели, которую ее читают */
        /*
        HashMap<Book, ArrayList<Reader>> stat = new HashMap<Book, ArrayList<Reader>>();

        stat.put(book1, new ArrayList<Reader>()); // изначально  записываем все книги и пустыми списками (никто не читает)
        stat.put(book2, new ArrayList<Reader>());
        stat.put(book3, new ArrayList<Reader>());
        stat.put(book4, new ArrayList<Reader>());

        stat.get(book1).add(re1); // добавляем по ключю книги в ее список читателей
        stat.get(book2).add(re1);
        stat.get(book2).add(re3);

        getInfo(stat);
        */

        /* Решение 2. Сделать в классе книга переменную - список читателей. Добавить методы записи нового читателя и
         * получения всех текущих читателей */
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        // указание связей книг
        book1.setReaders(re1);
        book2.setReaders(re1);
        book2.setReaders(re3);

        getInfo2(books);
        // удаления одного читателя из списка конкретной книги
        System.out.println();
        book2.delReaders(re1);
        getInfo2(books);

        System.out.printf("Count of all books: %s", Book.counter);

    }

    public static void getInfo(HashMap<Book, ArrayList<Reader>> result) {
        /* Вывод статистики по книгам на основе словаря */
        for (Book bk: result.keySet()) {
            if (result.get(bk).size() == 0) {
                System.out.printf("%-20s -> %s\n", bk.name, "");
            } else {
                String readers = result.get(bk).get(0).FIO;
                for (int i = 1; i < result.get(bk).size(); i++) {
                    readers = readers + ", " + result.get(bk).get(i).FIO;
                }
                System.out.printf("%-20s -> %s\n", bk.name, readers);
            }
        }
    }

    public static void getInfo2(ArrayList<Book> books) {
        /* Вывод статистики по книгам на основе метода в классе книга */
        for (Book bk: books) {
            if (bk.getReaders().size() == 0) {
                System.out.printf("%-20s -> %s\n", bk.name, "");
            } else {
                String readers = bk.getReaders().get(0).getFIO();
                for (int i = 1; i < bk.getReaders().size(); i++) {
                    readers = readers + ", " + bk.getReaders().get(i).getFIO();
                }
                System.out.printf("%-20s -> %s\n", bk.name, readers);
            }
        }
    }

}
