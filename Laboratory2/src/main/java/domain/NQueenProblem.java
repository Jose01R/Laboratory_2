package domain;

import java.util.Random;

public class NQueenProblem {
    private int size;
    private int[] board;
    private Random random;
    private int solutions;


    public NQueenProblem(int size) {
        this.size = size;
        this.board = new int[size]; // Inicializa el tablero
        this.random = new Random(); // Inicializa el generador aleatorio
        this.solutions = 0;
    }

    public int getSolutions() {
        return solutions;
    }

    private boolean esSeguro(int fila, int col) {
        // columna y las diagonales
        for (int i = 0; i < fila; i++) {
            if (board[i] == col || board[i] - i == col - fila || board[i] + i == col + fila) {
                return false;
            }
        }
        return true;
    }

    private void resolver(int fila) {
        if (fila == size) {
            imprimirSolucion();
            solutions++;
            return;
        }

        for (int col = 0; col < size; col++) {
            if (esSeguro(fila, col)) {
                board[fila] = col; // Coloca la reina
                resolver(fila + 1); // Llama recursivamente para la siguiente fila
            }
        }
    }

    private void imprimirSolucion() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i] == j) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public String encontrarSolucionAleatoria() {
        StringBuilder resultado = new StringBuilder();

        // Inicializa el tablero
        for (int i = 0; i < size; i++) {
            board[i] = -1; // -1 indica que no hay reina en la fila
        }

        for (int i = 0; i < size; i++) {
            int col;
            boolean colocado = false;

            // Intenta colocar la reina en una columna aleatoria
            for (int intentos = 0; intentos < size; intentos++) {
                col = random.nextInt(size); // Genera una columna aleatoria
                if (esSeguro(i, col)) { // Verifica si es seguro
                    board[i] = col; // Coloca la reina
                    colocado = true;
                    break; // Sale del bucle si logra colocarla
                }
            }

            // Si no se pudo colocar la reina, reiniciar
            if (!colocado) {
                return encontrarSolucionAleatoria(); // Reinicia el proceso y devuelve la nueva solución
            }
        }

    // Construir el resultado en forma de String
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            if (board[i] == j) {
                resultado.append("1 ");
            } else {
                resultado.append("0 ");
            }
        }
        resultado.append("\n");
    }

    return resultado.toString();
}

    public void encontrarSoluciones() {//esto realmente no se muestra era para confirmar cuando creara las cantidades de soluciones
        // tamaño del tablero
        if (size == 4) {
            System.out.println("Soluciones para un tablero de 4x4:");
        } else if (size == 8) {
            System.out.println("Soluciones para un tablero de 8x8:");
        }
        resolver(0);

        System.out.println("Número de soluciones encontradas: " + solutions);
    }


}
