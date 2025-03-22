package controller;

import domain.SudokuSolver;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Arrays;

public class SudokuController {

    private SudokuSolver sud;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TableColumn<int[], Integer> column1;  // Columnas de la TableView
    @FXML
    private TableColumn<int[], Integer> column2;
    @FXML
    private TableColumn<int[], Integer> column3;
    @FXML
    private TableColumn<int[], Integer> column4;
    @FXML
    private TableColumn<int[], Integer> column5;
    @FXML
    private TableColumn<int[], Integer> column6;
    @FXML
    private TableColumn<int[], Integer> column7;
    @FXML
    private TableColumn<int[], Integer> column8;
    @FXML
    private TableColumn<int[], Integer> column9;
    @FXML
    private TableView initialBoardTable;

    @FXML
    public void initialize() {
        this.sud = new SudokuSolver();

        // Agregar opciones al ComboBox
        comboBox.getItems().addAll("Board 1", "Board 2", "Board 3", "Board 4", "Board 5");
        comboBox.setOnAction(event -> loadBoard());

        // Configurar el CellValueFactory para cada columna
        column1.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue()[0]).asObject());
        column2.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue()[1]).asObject());
        column3.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue()[2]).asObject());
        column4.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue()[3]).asObject());
        column5.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue()[4]).asObject());
        column6.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue()[5]).asObject());
        column7.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue()[6]).asObject());
        column8.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue()[7]).asObject());
        column9.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue()[8]).asObject());
    }

    private void loadBoard() {
        String selectedBoard = comboBox.getValue();
        int[][] board = sud.obtenerTableroPredefinido(selectedBoard);

        // Convertir el tablero 2D en una lista de listas
        ObservableList<int[]> boardData = FXCollections.observableArrayList();
        for (int i = 0; i < 9; i++) {
            boardData.add(board[i]);
        }
        initialBoardTable.setItems(boardData);

    }


    @FXML
    public void showSolution(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ucr/lab/solution-popup.fxml"));
            StackPane popupRoot = loader.load();

            // Obtener el controlador del popup
            SolutinPopUpController popupController = loader.getController();

            // Pasar el SudokuSolver al popup
            popupController.setSudokuSolver(sud);

            // Tablero seleccionado al popup
            popupController.setSelectedBoard(comboBox.getValue());

            Stage popupStage = new Stage();
            popupStage.setTitle("Solution");
            popupStage.setScene(new Scene(popupRoot, 300, 200));
            popupStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    }
