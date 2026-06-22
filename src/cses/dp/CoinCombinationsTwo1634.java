//package cses.dp;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;

/*
    Consider a money system consisting of n coins. Each coin has a positive integer value.
    Your task is to calculate the number of distinct ordered ways you can produce a money
    sum x using the available coins.

    For example, if the coins are {2,3,5} and the desired sum is 9, there are 3 ways:
    2+2+5
    3+3+3
    2+2+2+3

    Input:
    The first input line has two integers n and x: the number of coins and the desired sum of money.
    The second line has n distinct integers c1,c2,... c(n): the value of each coin.

    Output:
    Print one integer: the number of ways modulo 10^9+7.

    Constraints:
    1 <= n <= 100
    1 <= x <= 10^6
    1 <= c(i) <= 10^6

    Example:
    Input:
    3 9
    2 3 5

    Output:
    3
*/

public class CoinCombinationsTwo1634 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coinsSize = sc.nextInt();
        int target = sc.nextInt();
        int[] coins = new int[coinsSize];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = sc.nextInt();
        }

        int res;
        ArrayList<Integer> cur = new ArrayList<>();
        List<List<Integer>> out = new ArrayList<>();
        int memo[] = new int[target+1];
        Arrays.fill(memo, -1);
        res = solveUsingRecursion(coins, target, cur, out, memo);
//      System.out.println(res);

//      int []memo = new int[target + 1];
//      res = solveUsingMemoization(coins,target,memo);
//      System.out.println(res);

//        res = solveUsingDP(coins,target);
        System.out.println(res);
    }

    private static int solveUsingRecursion(int[] coins, int target, ArrayList<Integer> cur, List<List<Integer>> out,int[] memo) {
//        System.out.println(cur.toString() +" - "+ target);
        if (target == 0){
            Collections.sort(cur);

            if(!checkInList(cur,out)){

//                System.out.println(cur.toString());
                out.add(new ArrayList<>(cur));
                return 1;
            }
            return 0;
        }

        if(target < 0) return 0;
        if(memo[target] != -1){
            if(memo[target] != 0) {
                cur.add(target);
//                System.out.println(cur.toString() + " -> " + Arrays.toString(memo));
                Collections.sort(cur);
                if (!checkInList(cur, out)) {
//                    System.out.println(cur.toString());
                    out.add(new ArrayList<>(cur));
                }
                cur.remove(cur.size()-1);
            }
            return memo[target];
        }

        int total = 0;
        for (int coin : coins) {
            cur.add(coin);
            total += solveUsingRecursion(coins, target - coin, cur, out, memo);
            cur.remove(cur.size()-1);
//            cur.removeLast();
        }

        memo[target] = total;

        return total;
    }

    public static boolean  checkInList(ArrayList<Integer> cur, List<List<Integer>> out){
        for(List<Integer> list : out ){
            if(list.size() == cur.size()){
                boolean isThere = true;
                int i;
                for(i =0;i<cur.size();i++){
                    if(!Objects.equals(cur.get(i), list.get(i))){
                        isThere = false;
                        break;
                    }
                }
                if(isThere && i == cur.size()){
                    return true;
                }
            }
        }

        return false;
    }


//    private static int solveUsingMemoization(int[] coins, int target, int[] memo) {
//        int MOD = 1_000_000_007;
//        if (target == 0) return 1;
//        if(target < 0) return 0;
//
//        if(memo[target] != 0) return memo[target];
//        int total = 0;
//        for (int coin : coins) {
//            total += solveUsingRecursion(coins, target - coin) % MOD;
//        }
//
//        memo[target] = total;
//        return total;
//    }
//
    public static int solveUsingDP(int[] coins, int target) {
        int MOD = 1_000_000_007;
        int[] dp = new int[target + 1];
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