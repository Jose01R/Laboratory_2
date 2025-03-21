package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTourTest {

    @Test
    void printBoard() {
        KnightTour knightTour=new KnightTour();
        int[][]tablero= new int[8][8];
        knightTour.knightTourSolution(tablero);
        System.out.println("\nSolution");
        System.out.println("_________________________________");
        knightTour.printSolution(tablero);
        System.out.println("_________________________________");
    }

  //Todo test cuando falla o no sigue el camino correcto, ademas cuando el tablero es de menor tamaño
  @Test
  void testIsSafe() {
      int[][] tablero = new int[8][8];
      assertFalse(KnightTour.isSafe(tablero, -1, 0));//Comprobar si el metodo isSafe funciona correctamente la pasar un valor fuera del rango
      assertFalse(KnightTour.isSafe(tablero, 8, 8));
  }


}