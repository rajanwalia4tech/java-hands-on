package test;

import java.util.*;

public class RemovingDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//       System.out.println(solveUsingGreedy(n));
        int memo[] = new int[n + 1];
        int result = solve(n,memo);
         System.out.println(result);
    }

    public static int solveUsingGreedy(int n){
        if(n < 10) return 1;
        int max = getMax(n);
        return solveUsingGreedy(n-max) + 1;

    }

    public static int solve(int n, int[] memo){
        if(n < 10) return 1;


        if(memo[n] != 0) {
            return memo[n];
        }
        Integer[] digits = getUnique(n);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<digits.length;i++){
            if(digits[i] != 0){
//                System.out.print(n - digits[i] + " ");
                min = Math.min(solve(n - digits[i], memo), min);

            }
        }
        memo[n] = min+1;
        return min + 1;
    }

    public static Integer[] getUnique(int n) {
        HashSet<Integer> s = new HashSet<>();

        while (n != 0) {
            int rem = n % 10;
            if(rem != 0)
                s.add(rem);
            n /= 10;
        }

        return s.toArray(new Integer[s.size()]);
    }

    public static int getMax(int n) {
        int max = -1;
        while (n != 0) {
            int rem = n % 10;
            max = Math.max(rem,max);
            n /= 10;
        }
        return max;
    }

}
