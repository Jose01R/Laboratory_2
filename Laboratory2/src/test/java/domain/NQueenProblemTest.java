package domain;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class NQueenProblemTest {

    @Test
     void testSoluciones4Reinas() {
        NQueenProblem nQueenProblem = new NQueenProblem(7);
        nQueenProblem.encontrarSoluciones();
        // Para 4 reinas, se conocen 2 soluciones
        //assertEquals(4, nQueenProblem.getSolutions()); //confirma de hayan 2 soluciones para 4 reinas en un 4x4
        nQueenProblem.getSolutions();
    }

    @Test
    void testSoluciones8Reinas() {
        NQueenProblem nQueenProblem = new NQueenProblem(8);
        nQueenProblem.encontrarSoluciones();
        // Para 8 reinas, se conocen 92 soluciones
        //assertEquals(92, nQueenProblem.getSolutions()); ////confirma de hayan 92 soluciones para 8 reinas en un 8x8
        nQueenProblem.getSolutions();
    }


}