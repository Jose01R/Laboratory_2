package controller;

import domain.SudokuSolver;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SolutinPopUpController {
    private SudokuSolver sud;
    private String selectedBoard;

    @FXML
    private TableView<int[]> solutionBoardTable;

    @FXML
    private TableColumn<int[], Integer> column1, column2, column3, column4, column5, column6, column7, column8, column9;

    public void setSelectedBoard(String selectedBoard) {
        this.selectedBoard = selectedBoard;
        solveAndDisplaySolution();  // Llamada al método para resolver y mostrar la solución
    }

    public void setSudokuSolver(SudokuSolver sudokuSolver) {
        this.sud = sudokuSolver;
    }

    @FXML
    public void solveAndDisplaySolution() {
        int[][] board = sud.obtenerTableroPredefinido(selectedBoard);
        sud.sudokuSolution(board, 0, 0);  // Resolver el Sudoku

        // Convertir el tablero resuelto en una lista
        ObservableList<int[]> solutionData = FXCollections.observableArrayList();
        for (int i = 0; i < 9; i++) {
            solutionData.add(board[i]);  // Añadir la fila a la lista
        }

        // Mostrar solución en TableView
        solutionBoardTable.setItems(solutionData);
    }

    @FXML
    public void initialize() {
        this.sud = new SudokuSolver();

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

}
