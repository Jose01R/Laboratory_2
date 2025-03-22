package domain;


    public class KnightTour {

        private int[] moveX = new int[]{2, 1, -1, -2, -2, -1, 1, 2};//Movimientos posibles en Horizontal
        private int[] moveY = new int[]{1, 2, 2, 1, -1, -2, -2, -1};//Movimientos posibles en vertical


        public KnightTour() {
        }

        public static boolean isSafe(int[][] board, int x, int y) {
            //Verificar que cumple los requisitos
            return x >= 0 && x < 8 && y >= 0 && y < 8 && board[x][y] == -1;
        }

        public int[][] knightTourInitialization(int [][] board) {
            for(int i = 0; i < 8; ++i) {
                for(int j = 0; j < 8; ++j) {
                    board[i][j] = -1;//Llena el tablero con -1 para indicar las casillas no visitadas
                }
            }

            board[0][0] = 0;//Marca donde inicia el caballo

            if (this.solve(0, 0, 1, board)) {
                return board;
            } else {
                return null;
            }
        }

        private boolean solve(int x, int y, int moveCount, int[][] board) {
            if (moveCount == 64) {//Caso base, si moveCount llega a 64, recorrio todas las casillas correctamente
                return true;
            } else {
                for(int i = 0; i < 8; ++i) {
                    //Siguientes movimientos
                    int nextX = x + this.moveX[i];
                    int nextY = y + this.moveY[i];
                    //Comprobamos que sean seguros, si es asi los marcamos con el moveCount
                    if (isSafe(board, nextX, nextY)) {
                        board[nextX][nextY] = moveCount;
                        //llamado recursivo con los nuevos movimientos
                        if (solve(nextX, nextY, moveCount + 1, board)) {
                            return true;
                        }

                        board[nextX][nextY] = -1;//Backtracking
                    }
                }

                return false;//Si ninguno de los caminos funcionó se retorna falso
            }
        }

        public void printSolution(int[][] board) {
            if (board == null || board.length != 8) System.out.println("Solution doesn't exist");

            for(int i = 0; i < 8; ++i) {
                    for(int j = 0; j < 8; ++j) {
                        System.out.printf("%2d ", board[i][j]);
                    }
                    System.out.println();//Salto de linea
                }

            }
        }



