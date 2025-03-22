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


public class KnapsackController {

    private ObservableList<Item> itemsList = FXCollections.observableArrayList(); // Lista de ítems disponibles
    private ObservableList<Item> solutionList = FXCollections.observableArrayList(); // Lista de ítems en la solución

    @FXML
    private TableView<Item> knap2;
    @FXML
    private TableColumn<Item, String> columnName2; // Nueva columna para la solución
    @FXML
    private TableColumn<Item, Double> columnValue2; // Nueva columna para la solución
    @FXML
    private TableColumn<Item, Double> columnWeight2; // Nueva columna para la solución
    @FXML
    private TableColumn<Item, Double> columnValueWeight2;

    @FXML
    private ComboBox ComboBoxKnap;

    @FXML
    private TableView<Item> knap1;
    @FXML
    private TableColumn<Item, String> columnName;
    @FXML
    private TableColumn<Item, Double> columnValue;
    @FXML
    private TableColumn<Item, Double> columnWeight;
    @FXML
    private TableColumn<Item, Double> columnValueWeight;




    @FXML
    public void initialize() {
        // Configuración columnas para knap1
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnValue.setCellValueFactory(new PropertyValueFactory<>("value"));
        columnWeight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        columnValueWeight.setCellValueFactory(new PropertyValueFactory<>("valueWeight"));

        // Configuración columnas para knap2
        columnName2.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnValue2.setCellValueFactory(new PropertyValueFactory<>("value"));
        columnWeight2.setCellValueFactory(new PropertyValueFactory<>("weight"));
        columnValueWeight2.setCellValueFactory(new PropertyValueFactory<>("valueWeight"));



        // Add items to the ObservableList
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

        // Assign list to TableView
        knap1.setItems(itemsList);

        ObservableList<String> list = FXCollections.observableArrayList("10,21", "22,80","34,78", "40,80","50,39");
        ComboBoxKnap.setItems(list);

        ComboBoxKnap.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Solo llamar a la función cuando el valor seleccionado no sea nulo
            if (newValue != null) {
                System.out.println("Capacidad seleccionada: " + newValue);
                solveKnapsack(newValue);
            }
        });

        //System.out.println("Mostrando solución en knap2...");
        knap2.setItems(solutionList);


    }


    @FXML
    public void solveKnapsack(Object selectedObject) {
        // Convertir el valor seleccionado a texto y parsearlo
        String selectedCapacityText = selectedObject.toString();

        String[] capacityValues = selectedCapacityText.split(",");
        if (capacityValues.length > 1) {
            try {
                double selectedCapacity = Double.parseDouble(capacityValues[1]); // Tomar la segunda parte como capacidad

                // Crear una instancia con la capacidad seleccionada
                Knapsack knapsack = new Knapsack(itemsList.toArray(new Item[0]), selectedCapacity);

                // Obtener la solución
                Item[] solution = knapsack.solve();

                // Limpiar la lista de solución y agregar los ítems seleccionados
                solutionList.clear();
                for (Item item : solution) {
                    if (item != null) {
                        solutionList.add(item);
                    }
                }

                // Mostrar la solución en el TableView knap2
                knap2.setItems(solutionList);

            } catch (NumberFormatException e) {
                System.out.println("Error: No se pudo convertir la capacidad seleccionada a un número.");
            }
        } else {
            System.out.println("Error: Formato de capacidad inválido.");
        }
    }


}
