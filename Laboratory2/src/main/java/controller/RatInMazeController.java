package controller;
import domain.CellDataRatInMaze;
import domain.RatInMaze;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RatInMazeController {

    @javafx.fxml.FXML
    private ComboBox<String> comboBox;
    @javafx.fxml.FXML
    private TableView<CellDataRatInMaze[]> tableViewInitial;
    @javafx.fxml.FXML
    private TableView<CellDataRatInMaze[]> tableViewSolution;
    @javafx.fxml.FXML
    private TableColumn<CellDataRatInMaze[], Integer> col1Initial, col2Initial, col3Initial, col4Initial, col5Initial, col6Initial, col7Initial, col8Initial;
    @javafx.fxml.FXML
    private TableColumn<CellDataRatInMaze[], Integer> col1Solution, col2Solution, col3Solution, col4Solution, col5Solution, col6Solution, col7Solution, col8Solution;

    private RatInMaze ratInMaze;
    private int[][] maze;
    private int N = 8; // Default size (4x4)

    @javafx.fxml.FXML
    private void initialize() {
        this.ratInMaze = new RatInMaze();
        comboBox.setItems(FXCollections.observableArrayList("maze1", "maze2", "maze3","maze4","maze5"));
        comboBox.getSelectionModel().select("maze1");
        comboBox.setOnAction(event -> updateMazeSize());
        //Valor de columnas iniciales
        col1Initial.setCellValueFactory(data -> data.getValue()[0].cellvalueProperty().asObject());
        col2Initial.setCellValueFactory(data -> data.getValue()[1].cellvalueProperty().asObject());
        col3Initial.setCellValueFactory(data -> data.getValue()[2].cellvalueProperty().asObject());
        col4Initial.setCellValueFactory(data -> data.getValue()[3].cellvalueProperty().asObject());
        //Valor de columnas Solucion
        col1Solution.setCellValueFactory(data -> data.getValue()[0].cellvalueProperty().asObject());
        col2Solution.setCellValueFactory(data -> data.getValue()[1].cellvalueProperty().asObject());
        col3Solution.setCellValueFactory(data -> data.getValue()[2].cellvalueProperty().asObject());
        col4Solution.setCellValueFactory(data -> data.getValue()[3].cellvalueProperty().asObject());


        updateMazeSize();
        tableViewInitial.setItems(RandomMaze(N));
    }

    private void updateMazeSize() {
        String selectedSize = comboBox.getSelectionModel().getSelectedItem();
        switch (selectedSize) {
            case "maze1": N = 4; break;
            case "maze2": N = 8; break;
            case "maze3": N = 10; break;
        }
    }


    //Generar una matriz aleatoria
    private ObservableList<CellDataRatInMaze[]> RandomMaze(int size) {
        int[][] maze = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                maze[i][j] = (int) (Math.random() * 2);
            }
        }
        this.maze = maze;
        return getMazeData(maze);
    }

    private ObservableList<CellDataRatInMaze[]> getMazeData(int[][] maze) {
        ObservableList<CellDataRatInMaze[]> data = FXCollections.observableArrayList();
        for (int i = 0; i < N; i++) {
            CellDataRatInMaze[] row = new CellDataRatInMaze[N];
            for (int j = 0; j < N; j++) {
                row[j] = new CellDataRatInMaze(maze[i][j]);
            }
            data.add(row);
        }
        return data;
    }


}

