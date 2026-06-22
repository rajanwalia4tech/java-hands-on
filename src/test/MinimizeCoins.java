package test;

/*
Consider a money system consisting of n coins. Each coin has a positive integer value.
Your task is to produce a sum of money x using the available coins in such a way that the number of coins
is minimal.
For example, if the coins are {1,5,7} and the desired sum is 11, an optimal solution is 5+5+1 which
requires 3 coins.

Input
The first input line has two integers n and x: the number of coins and the desired sum of money.
The second line has n distinct integers c1,c2,...,cn: the value of each coin.

Output
Print one integer: the minimum number of coins. If it is not possible to produce the desired sum, print -1.
Constraints

1 <= n <= 100
1 <= x <= 10^6
1 <= c(i) <= 10^6

Example
Input:
3 11
1 5 7

Output:
3

sum = 11


 */

import java.util.Arrays;
import java.util.Scanner;

public class MinimizeCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfCoins = sc.nextInt();
        int coinsTotal = sc.nextInt();
        int [] coins = new int[noOfCoins];
        for(int i=0;i<coins.length;i++){
            coins[i] = sc.nextInt();
        }
        int result;

        int[] res = new int[1];
        result = solveUsingRecursion(coins, coinsTotal);
//        result = res[0];
        System.out.print(result);
//        System.out.print(Arrays.toString(coins) +" " + noOfCoins + " " +  coinsTotal);
    }

    public static int solveUsingRecursion(int[] coins, int coinsTotal){
        if(coinsTotal == 0){
            return 1;
        }

        if(coinsTotal < 0) return Integer.MAX_VALUE;

        int curMin = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            int res = solveUsingRecursion(coins, coinsTotal-coins[i]);
            curMin = Math.min(res,curMin);
        }

        return curMin + 1;
    }
}
