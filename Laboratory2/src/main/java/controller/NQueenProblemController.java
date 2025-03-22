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
    private ComboBox<String> ComboBoxNQueens;

    @FXML
    private TableView<String[]> TableViewNQueens;

    @FXML
    private TableColumn<String[], String> col1, col2, col3, col4, col5, col6, col7, col8; // Columnas del TableView

    private ObservableList<String[]> solutionsList;

    @FXML
    public void initialize() {
        // Inicializa el ComboBox con las opciones de 4x4 y 8x8
        ComboBoxNQueens.getItems().addAll("4x4", "8x8");
        ComboBoxNQueens.setValue("4x4"); // Establece un valor por defecto

        // Inicializa la lista observable
        solutionsList = FXCollections.observableArrayList();

        // Configura las columnas del TableView
        configureTableView();
    }

    private void configureTableView() {
        // Vincula las columnas a los índices del arreglo de Strings
        col1.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()[0]));
        col2.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()[1]));
        col3.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()[2]));
        col4.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()[3]));
        col5.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()[4]));
        col6.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()[5]));
        col7.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()[6]));
        col8.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()[7]));

        // Asocia la lista observable al TableView
        TableViewNQueens.setItems(solutionsList);
    }

    @FXML
    private void Select(ActionEvent actionEvent) {
        String selectedSize = ComboBoxNQueens.getValue();

        if (selectedSize.equals("4x4")) {
            solucionAleatoria4x4();
        } else if (selectedSize.equals("8x8")) {
            solucionAleatoria8x8();
        }
    }

    private void solucionAleatoria4x4() {
        NQueenProblem nQueenProblem = new NQueenProblem(4);
        String solution = nQueenProblem.encontrarSolucionAleatoria();

        String[] solutionArray = convertirSolucionATabla(solution);

        solutionsList.clear();
        solutionsList.add(solutionArray);
    }

    private void solucionAleatoria8x8() {
        NQueenProblem nQueenProblem = new NQueenProblem(8);
        String solution = nQueenProblem.encontrarSolucionAleatoria();

        String[] solutionArray = convertirSolucionATabla(solution);

        solutionsList.clear();
        solutionsList.add(solutionArray);
    }

    private String[] convertirSolucionATabla(String solution) {
        String[] filas = solution.split("\n");

        for (int i = 0; i < filas.length; i++) {
            filas[i] = filas[i].trim();
        }

        return filas;
    }
}
