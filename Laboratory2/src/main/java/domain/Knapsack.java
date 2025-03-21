package domain;

import util.Utility;

import java.util.Arrays;

public class Knapsack {

    private Item[] list; //lista de objetos candidatos para la mochila
    private double capacity; //capacidad máxima en la mochila

    public Knapsack(Item[] list, double capacity) {
        this.list = list;
        this.capacity = capacity;
    }

    // Método que resuelve el problema
    // Devuelve la lista de los objetos agregados a la mochila
    public Item[] solve(){
        bubbleSort(); // PRIMERO ORDENO LA LISTA DE ITEMS -> Value/Weight

        Item[] knapsackList = new Item[this.list.length];
        int i  = 0;
        int n = list.length;
        int pos = 0;
        double totalWeight = 0; // PARA LLEVAR EL PESO TOTAL
        while (totalWeight <= this.capacity && i < n){
            if(totalWeight + list[i].getWeight() <= capacity){
                // SUMO PESO DEL ELEMENTO A CARGAR
                totalWeight += list[i].getWeight();
                // AGREGO ELEMENTO A SOLUCION
                knapsackList[pos++] = list[i];
            }
            i++; // SE AGREGUE O NO EL ELEMENTO SE INCREMENTA INDEX
        }
        return knapsackList;
    }

    // An optimized version of Bubble Sort
    private void bubbleSort(){
        boolean swapped;
        int n = this.list.length;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                //if (arr[j] > arr[j + 1]) {
                if(list[j].getValueWeight() < list[j+1].getValueWeight()){
                    // Swap arr[j] and arr[j+1]
                    Item temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }

    @Override
    public String toString() {
        double totalWeight = 0;
        double totalValue = 0;
        Item[] solution = solve();
        String result = "KNAPSACK PROBLEM" + "\n----------------------------------------------------"
                + "\nMax Weight: " + this.capacity + "\nItems List Added: " +
                "\n\t\tName\t\t\t\tValue\t\t\tWeight";

        int i = 1;
        for (Item item: solution){
            if (item == null)
                break;

            if (item == null)// SI ES NULL ES PORQUE NO HAY MAS ELEMENTOS
                break;

            totalWeight += item.getWeight();
            totalValue += item.getValue();
            result += "\n(" + (i++) +")" + item.toString();
        }

        result += "\n----------------------------------------------------";
        result += String.format("\nTOTALS: \t\t\t\t\t\t" + util.Utility.$format(totalValue));
        result += String.format("\t\t\t" + util.Utility.format(totalWeight));

        return result;
    }
}
