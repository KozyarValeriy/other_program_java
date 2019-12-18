//****************************************//
//******** Определение интерфейса ********//
//****************************************//

public interface Shape {
    public Double getSquare();
    public default String getClassName() {
        return "";
    }
}
