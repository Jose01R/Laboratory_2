package domain;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CellDataRatInMaze {

    private IntegerProperty Cellvalue;

    public CellDataRatInMaze(int value) {
        this.Cellvalue = new SimpleIntegerProperty(value);//Convertir un número entero en una propiedad observable más simple
    }

    public IntegerProperty cellvalueProperty() {//Devuelve directamente la propiedad observable del valor de la celda
        return Cellvalue;
    }

    public int getCellvalue() {
        return Cellvalue.get();
    }

    public void setCellvalue(int cellvalue) {
        this.Cellvalue.set(cellvalue);
    }
}


