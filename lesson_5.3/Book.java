/* Класс книга.
 * Реализуем методы добавления и удаления читателя, а также
 * получения списка всех читателей. */


import java.util.ArrayList;

public class Book {
    public String name;
    public ArrayList<Reader> readers;
    public static int counter = 0; // счетчик всех книг

    Book (String name) {
        this.name = name;
        this.readers = new ArrayList<Reader>();
        counter += 1; // увеличение счетчика книг
    }

    public ArrayList<Reader> getReaders(){
        return readers;
    }

    public void setReaders(Reader reader){
        this.readers.add(reader);
    }

    public void delReaders(Reader reader){
        this.readers.remove(reader);
    }

}
