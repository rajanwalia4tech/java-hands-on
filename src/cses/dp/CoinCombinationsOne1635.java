//package cses.dp;

import java.util.Scanner;

/*

    https://cses.fi/problemset/task/1635

    Consider a money system consisting of n coins. Each coin has a positive integer value. Your task is to calculate the number of distinct ways you can produce a money sum x using the available coins.
    For example, if the coins are \{2,3,5\} and the desired sum is 9, there are 8 ways:

    2+2+5
    2+5+2
    5+2+2
    3+3+3
    2+2+2+3
    2+2+3+2
    2+3+2+2
    3+2+2+2

    Input
    The first input line has two integers n and x: the number of coins and the desired sum of money.
    The second line has n distinct integers c_1,c_2,\dots,c_n: the value of each coin.
    Output
    Print one integer: the number of ways modulo 10^9+7.
    Constraints

    1 \le n \le 100
    1 \le x \le 10^6
    1 \le c_i \le 10^6

    Example
    Input:
    3 9
    2 3 5

    Output:
    8


 */

public class CoinCombinationsOne1635 {
    final static int MOD = 1_000_000_007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coinsSize = sc.nextInt();
        int target = sc.nextInt();
        int[] coins = new int[coinsSize];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = sc.nextInt();
        }

        long res;
//      res = solveUsingRecursion(coins, target);
//      System.out.println(res);
//
//      int []memo = new int[target + 1];
//      res = solveUsingMemoization(coins,target,memo);
//      System.out.println(res);

        res = solveUsingDP(coins,target);
        System.out.println(res);
    }

    private static int solveUsingRecursion(int[] coins, int target) {
        if (target == 0) return 1;
        if(target < 0) return 0;

        int total = 0;
        for (int coin : coins) {
            total = (total + solveUsingRecursion(coins, target - coin));
        }
        return total;
    }

    private static int solveUsingMemoization(int[] coins, int target, int[] memo) {
        int MOD = 1_000_000_007;
        if (target == 0) return 1;
        if(target < 0) return 0;

        if(memo[target] != 0) return memo[target];
        int total = 0;
        for (int coin : coins) {
            total += solveUsingRecursion(coins, target - coin) % MOD;
        }

        memo[target] = total;
        return total;
    }

    public static long solveUsingDP(int[] coins, int target) {
        long[] dp = new long[target + 1];
        dp[0] = 1;

        for(int i = 1; i <= target; i++){
            for (int coin : coins) {
                if (i - coin >= 0)
                    dp[i] = (dp[i - coin] + dp[i]) % MOD;
            }
        }

        return dp[target];
    }
}
