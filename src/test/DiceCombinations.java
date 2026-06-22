package test;

import java.util.Scanner;

/*
n = 3, ans = 4

Following are the number of ways
1 + 1 + 1
1 + 2
2 + 1
3

4 = (1,1,1,1), (1,2,1), (1,1,2), (2,1,1), (2,2), (1,3),(3,1), (4)
5 = (1,1,1,1,1), (1,1,1,2),(1,1,2,1),(1,2,1,1),(2,1,1,1),(2,2,1),(1,2,2),(2,1,2),(3,1,1),(1,3,1),(1,1,3),
(2,3),(3,2),(1,4),(4,1),(5)

State = dp[i] -> represent for number i, it is the number of ways to roll the dice combinations
 0, 1, 1, 3, 4, 5
[1, 1, 2, 4, 8, 16, 32, 63, 125]


Transition = sum of last 6 states where i>=0
 */


public class DiceCombinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result;

//        int res[] = new int[1];
//        solveUsingRecursion(num,res);
//        result = res[0];

        result = solveUsingDP(num);

        System.out.print(result);
    }

    static void solveUsingRecursion(int num, int[] res){
        if(num == 0){
            res[0]++;
            return;
        }

        if(num < 0) return;

        for(int i=1;i<=6;i++){
            solveUsingRecursion(num-i,res);
        }
        return ;
    }

    public static int solveUsingDP(int num){
        int dp[] = new int[num+1];

        dp[0] = 1; // for rolling no dice there is still a way.

        for(int i = 1;i<=num;i++){
            for(int j=1; j<=6; j++){
                if(i-j>=0)
                    dp[i] += dp[i-j];
            }
        }

        return dp[num];
    }
}
