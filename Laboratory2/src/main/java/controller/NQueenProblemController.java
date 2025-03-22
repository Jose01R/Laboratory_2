package controller;

import domain.NQueenProblem;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import ucr.lab.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;

public class NQueenProblemController {

    @FXML
    private TableView<ObservableList<String>> TableViewNQueens;
    @FXML
    private ComboBox<String> ComboBoxNQueens;

    @FXML
    public void Select(ActionEvent actionEvent) {
        String seleccion = ComboBoxNQueens.getSelectionModel().getSelectedItem();
        if (seleccion != null) {
            int size;
            if (seleccion.equals("4x4")) {
                size = 4;
            } else {
                size = 8;
            }
            configureTableColumns(size);

            String solucion = seleccion.equals("4x4") ? solucionAleatoria4x4() : solucionAleatoria8x8();
            TableViewNQueens.getItems().clear();

            // Dividir la solución en filas
            String[] filas = solucion.split("\n");
            for (String fila : filas) {
                // Dividir cada fila en caracteres individuales
                String[] valores = fila.split("");
                ObservableList<String> row = FXCollections.observableArrayList(valores);
                TableViewNQueens.getItems().add(row);
            }
        }
    }

    @FXML
    public void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("4x4", "8x8");
        ComboBoxNQueens.setItems(list);
    }

    private void configureTableColumns(int size) {
        TableViewNQueens.getColumns().clear();
        for (int i = 0; i < size; i++) {
            TableColumn<ObservableList<String>, String> column = new TableColumn<>("Col " + (i + 1));
            final int columnIndex = i;

            // Seteamos el valor de la celda con una validación del índice
            column.setCellValueFactory(data -> {
                ObservableList<String> row = data.getValue();
                // Verificamos si el índice es válido para esta fila
                if (columnIndex >= 0 && columnIndex < row.size()) {
                    return new SimpleStringProperty(row.get(columnIndex));
                } else {
                    return new SimpleStringProperty(""); // Si el índice no es válido, devolvemos un valor vacío
                }
            });

            TableViewNQueens.getColumns().add(column);
        }
    }

    public String solucionAleatoria4x4() {
        NQueenProblem nQueenProblem = new NQueenProblem(4);
        return nQueenProblem.encontrarSolucionAleatoria();
    }

    public String solucionAleatoria8x8() {
        NQueenProblem nQueenProblem = new NQueenProblem(8);
        return nQueenProblem.encontrarSolucionAleatoria();
    }
}