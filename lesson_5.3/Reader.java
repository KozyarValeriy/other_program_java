/* Класс читатель.
 * Реализует метод получения ФИО */


public class Reader {
    public String FIO;

    Reader (String FIO) {
        this.FIO = FIO;
    }

    public String getFIO() {
        return this.FIO;
    }
}
