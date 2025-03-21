package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {

    @Test
    void test(){
        Item items[] = new Item[12];
        items[0] = new Item("Smart TV 65 pulg 4k", 1000, 20);
        items[1] = new Item("PS5", 600, 2);
        items[2] = new Item("Libro Java", 20, 1);
        items[3] = new Item("Samsung Galaxy", 700, 0.5);
        items[4] = new Item("Huawei", 400, 0.5);
        items[5] = new Item("Libro C++", 25, 0.5);
        items[6] = new Item("Xbox One", 500, 2.2);
        items[7] = new Item("Drone", 500, 3);
        items[8] = new Item("Proyector", 200, 3);
        items[9] = new Item("LapTop", 800, 3);
        items[10] = new Item("Impresora 3D", 800, 4);
        items[11] = new Item("iPhone", 800, 0.5);

        System.out.println("KNAPSACK PROBLEM\n" + "ITEMS LIST"
                + "\n----------------------------------------------------"
                + show(items));

        System.out.println("\nKNAPSACK PROBLEM - SOLUTION");
        Knapsack knapsack = new Knapsack(items, 14.5);
        /*
        knapsack.bubbleSort();
        System.out.println("ITEM LIST - SORTED BY BUBBLE");
        System.out.println("KNAPSACK PROBLEM\n" + "ITEMS LIST\n" + show(items));
        */

        System.out.println(knapsack.toString());



    }

    // MÉTODO MOSTRADO EN PANTALLA
    private String show(Item[] items){
        String result = "";
        result+= "\n\t\tName\t\t\t\tValue\t\t\tWeight";

        for (Item item : items){
            if(item == null)
                break;
            result+="\n" + item.toString();
        }
        return  result;
    }


}