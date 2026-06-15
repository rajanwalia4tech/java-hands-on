package cses.dp;
import java.util.Scanner;

/*
Problem Link : https://cses.fi/problemset/task/1633/

Description :

Your task is to count the number of ways to construct sum n by throwing a dice one or more times.
Each throw produces an outcome between 1 and 6.

For example, if n=3, there are 4 ways :

1+1+1
1+2
2+1
3

Input
The only input line has an integer n.

Output
Print the number of ways modulo 10^9+7.

Constraints
1 <= n <= 10^6

Example
Input:
3

Output:
4

*/

public class DiceCombinations1633 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int res;
        res = diceCombinationsWithRecursion(num);
        System.out.print(res);
        System.out.println();

        int[] memo = new int[num + 1];
        res = diceCombinationsWithMemoization(num,memo);
        System.out.print(res);
        System.out.println();
        res = diceCombinationWithDP(num);
        System.out.print(res);
    }

    public static int diceCombinationsWithRecursion(int n){
        if(n == 0) return 1;
        if(n<0) return 0;

        int res = 0;
        for(int i=1;i<=6;i++){
           res+= diceCombinationsWithRecursion(n-i);
        }

        return res;
    }


    public static int diceCombinationsWithMemoization(int n, int[] memo){
        if(n == 0) return 1;
        if(n<0) return 0;

        if(memo[n]!=0) return memo[n];

        int res = 0;
        for(int i=1;i<=6;i++){
            res+= diceCombinationsWithRecursion(n-i);
        }

        memo[n] = res;
        return res;
    }

    public static int diceCombinationWithDP(int n){
        int MOD = 1_000_000_007;
        int []dp = new int[n+1];
        dp[0] = 1; // if we roll the dice 0th time that is only 1 way

        for(int i=1;i<=n;i++){
            for(int j=1;j<=6;j++){
                if(i-j >=0){
                    dp[i] =(dp[i] + dp[i-j])%MOD;
                }
            }
        }
        return dp[n];
    }

}
