package cses.dp;

import java.util.Arrays;
import java.util.Scanner;

/*
Consider a money system consisting of n coins. Each coin has a positive integer value.
Your task is to produce a sum of money x using the available coins in such a way that
the number of coins is minimal.

For example, if the coins are {1,5,7} and the desired sum is 11, an optimal solution is 5+5+1 which requires 3 coins.

Input :
The first input line has two integers n and x: the number of coins and the desired sum of money.
The second line has n distinct integers c(1),c(2),..,c(n): the value of each coin.

Output :
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

 */

public class MinimizingCoins1634 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coinsSize = sc.nextInt();
        int target = sc.nextInt();

        int[] coins = new int[coinsSize];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = sc.nextInt();
        }

        int res;
        res = solveUsingDP(coins, target);
        System.out.println(res);
    }

    public static int solveUsingDP(int[] coins, int target){
        // state -> dp[i] = minimum no. of coins need to make the sum i;
        // transition -> dp[i] = 1 + min(dp[i - coins[k]) if i - coins[k]>=0 where k -> 0 <= k < coins.length
        int[] dp = new int[target+1];
        int INF = (int) 1e9;
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int sum = 1; sum <= target; sum++){
            for (int coin : coins) {
                if (sum >= coin) {
                    dp[sum] = Math.min(dp[sum], dp[sum - coin] + 1);
                }
            }
        }

        return dp[target] == INF ? -1 : dp[target];
    }
}
