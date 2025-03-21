package domain;


    public class KnightTour {

        private int[] moveX = new int[]{2, 1, -1, -2, -2, -1, 1, 2};//Movimientos posibles en Horizontal
        private int[] moveY = new int[]{1, 2, 2, 1, -1, -2, -2, -1};//Movimientos posibles en vertical


        public KnightTour() {
        }

        public static boolean isSafe(int[][] tablero, int x, int y) {
            //Verificar que cumple los requisitos
            return x >= 0 && x < 8 && y >= 0 && y < 8 && tablero[x][y] == -1;
        }

        public int[][] knightTourSolution(int [][]tablero) {
            for(int i = 0; i < 8; ++i) {
                for(int j = 0; j < 8; ++j) {
                    tablero[i][j] = -1;//Llena el tablero con -1 para indicar las casillas no visitadas
                }
            }

            tablero[0][0] = 0;//Marca donde inicia el caballo

            if (this.solve(0, 0, 1, tablero)) {
                return tablero;
            } else {
                return null;
            }
        }

        private boolean solve(int x, int y, int moveCount, int[][] tablero) {
            if (moveCount == 64) {//Caso base, si moveCount llega a 64, recorrio todas las casillas correctamente
                return true;
            } else {
                for(int i = 0; i < 8; ++i) {
                    //Siguientes movimientos
                    int nextX = x + this.moveX[i];
                    int nextY = y + this.moveY[i];
                    //Comprobamos que sean seguros, si es asi los marcamos con el moveCount
                    if (isSafe(tablero, nextX, nextY)) {
                        tablero[nextX][nextY] = moveCount;
                        //llamado recursivo con los nuevos movimientos
                        if (solve(nextX, nextY, moveCount + 1, tablero)) {
                            return true;
                        }

                        tablero[nextX][nextY] = -1;//Backtracking
                    }
                }

                return false;//Si ninguno de los caminos funcionó se retorna falso
            }
        }

        public void printSolution(int[][] tablero) {
            if (tablero == null) System.out.println("Solution doesn't exist");

            for(int i = 0; i < 8; ++i) {
                    for(int j = 0; j < 8; ++j) {
                        System.out.printf("%2d ", tablero[i][j]);
                    }
                    System.out.println();//Salto de linea
                }

            }
        }



