package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class RatInMazeTest {

    @Test
    void test(){
        RatInMaze rat = new RatInMaze();

        //VALORES DEBEN SER RANDOM
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        System.out.println("\nRat in a maze for 4x4 board");
        System.out.println(printBoard(maze));
        System.out.println("\nSolution: ");
        System.out.println(rat.printSolution(maze));
    }

    private String printBoard(int[][] maze) {
        String result = "";
        int n = maze.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += maze[i][j] == 0 ? " 0" : " " + maze[i][j];
            }
            result += "\n";

        }
        return  result;
    }

}