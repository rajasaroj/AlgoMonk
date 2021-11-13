package algomonk.geekforgeek.greedyApproach;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * 242 Fractional Knapsack Problem
 *
 *
 * Greedy Approach used to solve this problem:
 *
 * 1) Derive Profit Per Weight (mean what is profit profit for x kg weight, derived by formula=profit/weight) and save it in 2d array with corresponding index
 * 2) sort the 2d array by Profit Per Weight
 * 3) iterate the arrays in reverse order (so that you can pick the elements with maximum profit per weight) and keep on updating the updatedWeight(Weight remaining to be filled) and update the totalProfit
 * 4) if the currentWeight > updatedWeight,
 *      now we need to fill the remaining weight (updatedWeight) with profit of the element according to updatedWeight.
 *      hence we use this formula= (updatedWeight/currentWeight) * currentElementProfit
 *      and update the totalProfit
 *
 *
 *
 *
 * https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
 *
 */
public class FractionalKnapSack {
    public static void main(String[] args) {

        int[] profits = {10, 5, 15, 7, 6, 18, 3};
        int[] weights = {2, 3, 5, 7, 1, 4, 1};
        int w = 15;

//        int[] profits = {60,100,120};
//        int[] weights = {10,20,30};
//        int w = 50;

//        int[] profits = {60,100};
//        int[] weights = {10,20};
//        int w = 50;



        Item[] profitPerWeight = new Item[profits.length];
        IntStream.range(0, profits.length).forEach(i -> profitPerWeight[i] = new Item(profits[i],weights[i]));

        fractionalKnapsack(w, profitPerWeight, profitPerWeight.length);
    }

    static double fractionalKnapsack(int W, Item arr[], int n)
    {
        int updatedWeight = W;
        double[] selectionArr = new double[arr.length];
        double totalProfit = 0;

        // Your code here
        double[][] profitPerWeight = new double[arr.length][2];
        IntStream.range(0, arr.length).forEach(i -> {
            profitPerWeight[i][0] = i;
            profitPerWeight[i][1] = (float)arr[i].value/arr[i].weight;
        });

        Arrays.sort(profitPerWeight, Comparator.comparingDouble(x -> x[1]));

        for (int i = profitPerWeight.length-1; i >= 0; i--) {
            if ( arr[(int) profitPerWeight[i][0]].weight  < updatedWeight) {
                updatedWeight -= arr[(int) profitPerWeight[i][0]].weight;
                selectionArr[(int) profitPerWeight[i][0]] = 1;
                totalProfit += arr[(int) profitPerWeight[i][0]].value;


            } else {
                selectionArr[(int) profitPerWeight[i][0]] = (double) updatedWeight/arr[(int) profitPerWeight[i][0]].weight;
                totalProfit = totalProfit +  (selectionArr[(int) profitPerWeight[i][0]] * arr[(int) profitPerWeight[i][0]].value);
                break;
            }
        }

        return totalProfit;
    }
}

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
