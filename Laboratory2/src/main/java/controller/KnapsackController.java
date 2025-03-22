package controller;

import domain.Item;
import domain.Knapsack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Random;


public class KnapsackController {

    private ObservableList<Item> itemsList = FXCollections.observableArrayList(); // Lista de ítems disponibles
    private ObservableList<Item> solutionList = FXCollections.observableArrayList(); // Lista de ítems en la solución
    @FXML
    private TableView Knap2;
    @FXML
    private ComboBox ComboBoxKnap;
    @FXML
    private TableView Knap1;

    @FXML
    public void initialize() {
        // Configurar las columnas de la tabla de ítems disponibles (Knap1)
        TableColumn<Item, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Item, Double> valueColumn = new TableColumn<>("Value");
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

        TableColumn<Item, Double> weightColumn = new TableColumn<>("Weight");
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));

        Knap1.getColumns().addAll(nameColumn, valueColumn, weightColumn);

        // Configurar las columnas de la tabla de solución (Knap2)
        TableColumn<Item, String> nameColumnSolution = new TableColumn<>("Name");
        nameColumnSolution.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Item, Double> valueColumnSolution = new TableColumn<>("Value");
        valueColumnSolution.setCellValueFactory(new PropertyValueFactory<>("value"));

        TableColumn<Item, Double> weightColumnSolution = new TableColumn<>("Weight");
        weightColumnSolution.setCellValueFactory(new PropertyValueFactory<>("weight"));

        Knap2.getColumns().addAll(nameColumnSolution, valueColumnSolution, weightColumnSolution);

        // Llenar la lista de ítems disponibles
        itemsList.addAll(
                new Item("Smart TV 65 pulg 4k", 1000, 20),
                new Item("PS5", 600, 2),
                new Item("Libro Java", 20, 1),
                new Item("Samsung Galaxy", 700, 0.5),
                new Item("Huawei", 400, 0.5),
                new Item("Libro C++", 25, 0.5),
                new Item("Xbox One", 500, 2.2),
                new Item("Drone", 500, 3),
                new Item("Proyector", 200, 3),
                new Item("LapTop", 800, 3),
                new Item("Impresora 3D", 800, 4),
                new Item("iPhone", 800, 0.5)
        );

        Knap1.setItems(itemsList);

        // Llenar el ComboBox con capacidades aleatorias
//        ComboBoxKnap.getItems().addAll(generateRandomCapacities());

        ObservableList<String> list = FXCollections.observableArrayList("10,21", "22,80","34,78", "40,80","50,39");
        ComboBoxKnap.setItems(list);
    }

//    @FXML
//    public void solveKnapsack() {
//        Double selectedCapacity = ComboBoxKnap.getValue(); // Usa Double, no double
//        if (selectedCapacity != null && selectedCapacity > 0) {
//            // Crear una instancia de Knapsack con la capacidad seleccionada
//            Knapsack knapsack = new Knapsack(itemsList.toArray(new Item[0]), selectedCapacity);
//
//            // Obtener la solución
//            Item[] solution = knapsack.solve();
//
//            // Limpiar la lista de solución y agregar los ítems seleccionados
//            solutionList.clear();
//            for (Item item : solution) {
//                if (item != null) {
//                    solutionList.add(item);
//                }
//            }
//
//            // Mostrar la solución en la tabla Knap2
//            Knap2.setItems(solutionList);
//        }
//    }
//
//    private Double[] generateRandomCapacities() {
//        Random random = new Random();
//        return new Double[]{
//                10 + random.nextDouble() * 5, // Mochila1: entre 10 y 15
//                20 + random.nextDouble() * 5, // Mochila2: entre 20 y 25
//                30 + random.nextDouble() * 5, // Mochila3: entre 30 y 35
//                40 + random.nextDouble() * 5, // Mochila4: entre 40 y 45
//                50 + random.nextDouble() * 5  // Mochila5: entre 50 y 55
//        };
//    }
}
