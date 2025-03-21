package controller;

import domain.KnightTour;
import javafx.scene.control.TextArea;

public class KnightTourController {

    @javafx.fxml.FXML
    TextArea textArea;
    private KnightTour knightTour;
    private int [][]board;
    private final int N=8;
    private int [][]result;
    @javafx.fxml.FXML
    private void initialize(){

        this.knightTour= new KnightTour();
        this.board=new int[N][N];
        this.result= knightTour.knightTourSolution(board);
        this.textArea.setText(knightTour());


    }

    String knightTour(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(String.format("\t%2d\t ", result[i][j])); // Espaciado uniforme
            }
            sb.append("\n"); // Salto de línea después de cada fila
        }
        return sb.toString();
    }

    }


