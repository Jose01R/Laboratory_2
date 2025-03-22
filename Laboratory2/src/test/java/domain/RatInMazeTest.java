package domain;

import org.junit.jupiter.api.Test;


class RatInMazeTest {

    @Test
    void test(){
        RatInMaze rat = new RatInMaze();

        int [][] Maze =new int[4][4];
        for(int i = 0; i< Maze.length; i++){
            int valorAleatorio=(int)(Math.random()*2);
            for(int j = 0; j< Maze.length; j++){
                Maze[i][j]=valorAleatorio;
            }
        }
        System.out.println("\nRat in a maze for 4x4 board");
        System.out.println(printBoard(Maze));
        System.out.println("\nSolution: ");
        System.out.println(rat.printSolution(Maze));
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