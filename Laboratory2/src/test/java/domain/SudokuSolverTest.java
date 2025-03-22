package domain;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SudokuSolverTest {

    @Test
    void test(){
        SudokuSolver sud = new SudokuSolver();

        // Llamamos al método con el nombre del tablero que queremos
        String boardName = "Board 3"; // Puede ser "Board 1", "Board 2", etc.
        int[][] selectedBoard = sud.obtenerTableroPredefinido(boardName);


        System.out.println("\nSudoku for 9x9 board");
        System.out.println(printBoard(selectedBoard));



        System.out.println("\nSolution: ");
        sud.sudokuSolution(selectedBoard, 0, 0);
        System.out.println(printBoard(selectedBoard));

    }


    private String printBoard(int[][] board) {
        String result = "";
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += board[i][j] == 0 ? " 0" : " " + board[i][j];
            }
            result += "\n";

        }
        return  result;
    }

}