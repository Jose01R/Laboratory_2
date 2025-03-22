package domain;

public class SudokuSolver {



    //----------------------------------------------

    public String printSolution(int[][] board){
        String result = "";
        int n = board.length;
        // RESOLVEMOS INICIANDO EN LA POS fila = 0, col = 0
        //FINALIZAMOS EN POS fila = n-1, col = n-1

        if (sudokuSolution(board, 0, 0)){
            for (int i = 0; i < n ; i++) {
                for (int j = 0; j < n; j++) {
                    result += " " + board[i][j];
                }
                result += "\n"; //SALTO A LA SIGUIENTE FILA
            }
        }else{
            result += "Solution doesn't exist";
        }

        return result;
    }

    /*
    public boolean tableroCompleto(int [][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
     */


    // ----- METODO VALIDAR REGLAS -----

    //VERIFICA LA POSICION EN QUE SE COLOCA EL NUMERO
    public static boolean isSafe(int [][] board, int row, int col, int number) {

        //VERIFICACION FILA
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == number) {
                return false;
            }
        }

        //VERIFICACION COLUM
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == number) {
                return false;
            }
        }

        //VERIFICACION SUBGRID
        int subGridRow = (row / 3) * 3;
        int subGridCol = (col / 3) * 3;
        for (int i = subGridRow; i < subGridRow + 3; i++) {
            for (int j = subGridCol; j < subGridCol + 3; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }

        //TRUE = NUM VALIDO EN LA CELDA DESEADA
        return true;
    }

    //AGREGAN SOLUCION
    public static boolean sudokuSolution(int[][] board, int row, int col) {

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                int current = board[i][j];
                if (current == 0) {
                    for (int number = 1; number <= 9; number++) {
                        if (isSafe(board, i, j, number)) {
                            board[i][j] = number;
                            if (sudokuSolution(board, 0, 0)) {
                                return true;
                            }
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    //-----------------------------------------------------------------------

    // Obtener tablero predefinido
    // DEBEN SER 5 TABLEROS - DATOS INICIALES DIFERENTES

    public int[][] obtenerTableroPredefinido(String boardSelected) {
        int[][] firstBoard = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        int[][] secondBoard = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 8, 5},
                {0, 0, 1, 0, 2, 0, 0, 0, 0},
                {0, 0, 0, 5, 0, 7, 0, 0, 0},
                {0, 0, 4, 0, 0, 0, 1, 0, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 0},
                {5, 0, 0, 0, 0, 0, 0, 7, 3},
                {0, 0, 2, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 4, 0, 0, 0, 9}
        };

        int[][] thirdBoard = {
                {0, 0, 3, 0, 0, 0, 0, 0, 0},
                {0, 5, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 4, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 5, 0, 0, 0, 9},
                {0, 0, 0, 0, 0, 0, 0, 8, 0},
                {0, 0, 0, 0, 9, 0, 0, 0, 0},
                {0, 0, 0, 6, 0, 0, 0, 3, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        int[][] fourthBoard = {
                {0, 0, 3, 0, 0, 0, 0, 0, 0},
                {0, 5, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 4, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 5, 0, 0, 0, 9},
                {0, 0, 0, 0, 0, 0, 0, 8, 0},
                {0, 0, 0, 0, 9, 0, 0, 0, 0},
                {0, 0, 0, 6, 0, 0, 0, 3, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        int[][] fifthBoard = {
                {0, 0, 3, 0, 0, 0, 0, 0, 0},
                {0, 5, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 4, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 5, 0, 0, 0, 9},
                {0, 0, 0, 0, 0, 0, 0, 8, 0},
                {0, 0, 0, 0, 9, 0, 0, 0, 0},
                {0, 0, 0, 6, 0, 0, 0, 3, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        switch (boardSelected) {
            case "Board 1":
                return firstBoard;
            case "Board 2":
                return secondBoard;
            case "Board 3":
                return thirdBoard;
            case "Board 4":
                return fourthBoard;

            default:
                return fifthBoard;
        }
    }

}

