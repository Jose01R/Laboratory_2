package domain;

public class RatInMaze {

    /**
     * 0 significa hay una pared, no hay paso
     * 1 significa una ruta valida, si hay paso
     * 2 significa el camino correcto, ruta de escape del laberinto
     */

    public String printSolution(int[][] maze){
        String result = "";
        int n = maze.length;
        // RESOLVEMOS INICIANDO EN LA POS fila = 0, col = 0
        //FINALIZAMOS EN POS fila = n-1, col = n-1

        if (solverRatInMaze(maze, 0, 0, n)){
            for (int i = 0; i < n ; i++) {
                for (int j = 0; j < n; j++) {
                    result += " " + maze[i][j];
                }
                result += "\n"; //SALTO A LA SIGUIENTE FILA
            }
        }else{
            result += "Solution doesn't exist";
        }

        return result;
    }

    private boolean solverRatInMaze(int[][] maze, int i, int j, int n) {
        //SI HEMOS LLEGADO A LA POS FINAL, ENTONCES ENCONTRAMOS SOLUCION
        if (i == n-1 && j == n-1){
            maze[i][j] = 2; //MARCAMOS ULTIMA POS COMO RUTA VALIDA
            return true;
        }
        if (isSafe(maze, i, j, maze.length)){
            maze[i][j] = 2; //MARCAMOS LA RUTA
            if (solverRatInMaze(maze, i+1, j, n))
                return true;
            if (solverRatInMaze(maze, i, j+1, n))
                return true;

            //BACKTRACK: Desmarca (i, j) como parte de la ruta seleccionada
            maze[i][j] = 1; // DESMARCAMOS LA RUTA

        }
        return false;
    }

    private boolean isSafe(int[][] maze, int i, int j, int n) {
        return i >= 0 && i < n && j >= 0 && j < n && maze[i][j] == 1;
    }



}
