package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTourTest {

    @Test
    void show() {
        KnightTour knightTour=new KnightTour();
        int[][]tablero=knightTour.knightTourSolution();
        System.out.println("\nSolution");
        System.out.println("_________________________________");
        knightTour.printSolution(tablero);
        System.out.println("_________________________________");
    }

  //Todo test cuando falla o no sigue el camino correcto, ademas cuando el tablero es de menor tamaño
}