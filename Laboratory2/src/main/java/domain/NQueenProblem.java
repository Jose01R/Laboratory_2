package domain;

import java.util.Random;

public class NQueenProblem {
    private int size; // Tamaño del tablero
    private int[] board; // Arreglo que representa el tablero
    private Random random; // Generador de números aleatorios
    private int solutions; // Contador de soluciones


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
        // Verificar la columna y las diagonales
        for (int i = 0; i < fila; i++) {
            if (board[i] == col ||
                    board[i] - i == col - fila ||
                    board[i] + i == col + fila) {
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

    public void encontrarSoluciones() {
        // Mensaje que indica el tamaño del tablero
        if (size == 4) {
            System.out.println("Soluciones para un tablero de 4x4:");
        } else if (size == 8) {
            System.out.println("Soluciones para un tablero de 8x8:");
        }
        resolver(0);

        System.out.println("Número de soluciones encontradas: " + solutions);
    }


}
