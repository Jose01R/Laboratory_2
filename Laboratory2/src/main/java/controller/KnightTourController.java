package controller;

import domain.CellDataKnight;
import domain.KnightTour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class KnightTourController {

    @javafx.fxml.FXML
    private TextArea textArea;
    private KnightTour knightTour;
    private int[][] board;
    private final int N = 8;
    @javafx.fxml.FXML
    private TableView<CellDataKnight[]> tableView;
    @javafx.fxml.FXML
    private TableColumn<CellDataKnight[], Integer> col1, col2, col3, col4, col5, col6, col7, col8;

    @javafx.fxml.FXML
    private void initialize() {

        this.knightTour = new KnightTour();
        this.board = new int[N][N];
        this.board = knightTour.knightTourInitialization(board);
        this.textArea.setText(knightTourToString());

        //Asignar los valores de cada columna con la clase CellDataKnight
        col1.setCellValueFactory(data -> data.getValue()[0].cellvalueProperty().asObject());
        col2.setCellValueFactory(data -> data.getValue()[1].cellvalueProperty().asObject());
        col3.setCellValueFactory(data -> data.getValue()[2].cellvalueProperty().asObject());
        col4.setCellValueFactory(data -> data.getValue()[3].cellvalueProperty().asObject());
        col5.setCellValueFactory(data -> data.getValue()[4].cellvalueProperty().asObject());
        col6.setCellValueFactory(data -> data.getValue()[5].cellvalueProperty().asObject());
        col7.setCellValueFactory(data -> data.getValue()[6].cellvalueProperty().asObject());
        col8.setCellValueFactory(data -> data.getValue()[7].cellvalueProperty().asObject());

        //Llenar el TableView con la matriz
        tableView.setItems(BoardData());
    }


    //Para el tableView
    //Convertir cada fila de la matriz en un Array de tipo CellDataKnight
    private ObservableList<CellDataKnight[]> BoardData() {
        ObservableList<CellDataKnight[]> data = FXCollections.observableArrayList();
        for (int i = 0; i < N; i++) {
            CellDataKnight[] row = new CellDataKnight[N];
            for (int j = 0; j < N; j++) {
                row[j] = new CellDataKnight(board[i][j]);
            }
            data.add(row);
        }
        return data;
    }

    //Para el textArea
    String knightTourToString(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(String.format("\t%2d\t ", board[i][j])); //Convertir cada número de la matriz en un String
            }
            sb.append("\n"); //Salto de linea después de cada fila
        }
        return sb.toString();
    }

    }

