package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTourTest {

    @Test
    void printBoard() {
        KnightTour knightTour=new KnightTour();
        int[][] board = new int[8][8];
        knightTour.knightTourInitialization(board);
        System.out.println("\nSolution");
        System.out.println("_________________________________");
        knightTour.printSolution(board);
        System.out.println("_________________________________");
    }

  @Test
  void testIsSafe() {
      int[][] board = new int[8][8];
      assertFalse(KnightTour.isSafe(board, -1, 0));//Comprobar si el metodo isSafe funciona correctamente la pasar un valor fuera del rango
      assertFalse(KnightTour.isSafe(board, 8, 8));
  }
 @Test
    void testSmallerBoard(){
        KnightTour knightTour= new KnightTour();
        int [][]board= new int[4][4];
        knightTour.knightTourInitialization(board);
        knightTour.printSolution(board);
 }

}