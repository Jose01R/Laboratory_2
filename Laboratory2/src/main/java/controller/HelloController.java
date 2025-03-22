package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import ucr.lab.HelloApplication;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import ucr.lab.HelloApplication;

import java.io.IOException;

public class HelloController {

    @FXML
    private Text txtMessage;
    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;

    private int n;
    private int m;
    private int[] a;
    private  int[] b;

    private void load(String form){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(form));
        try {
            this.bp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void Knapsack(ActionEvent actionEvent) {
        load("knapsack.fxml");
    }

    @FXML
    public void NQueen(ActionEvent actionEvent) {load("nqueen.fxml");
    }

    @FXML
    public void KnightTour(ActionEvent actionEvent) {load("knighttour.fxml");
    }

    @FXML
    public void RatinaMaze(ActionEvent actionEvent) {
        load("ratinamaze.fxml");
    }

    @FXML
    public void SudokuSolver(ActionEvent actionEvent) {
        load("sudokusolver.fxml");
    }


    @FXML
    public void Home(ActionEvent actionEvent) {
        this.txtMessage.setText("Laboratory 2");
        this.bp.setCenter(ap);
    }

    @FXML
    public void Exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    public void exampleOnMousePressed(Event event) {
    }

//    @FXML
//    public void exampleOnMousePressed(Event event) {
//        this.txtMessage.setText("Loading Example. Please wait!!!");
//
//    }
}