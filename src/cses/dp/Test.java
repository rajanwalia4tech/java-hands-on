import java.io.*;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.MOD;

public class Test {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;

            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int num = 0;
            while (c > ' ') {
                num = num * 10 + (c - '0');
                c = read();
            }

            return num * sign;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();

        int coinsSize = fs.nextInt();
        int target = fs.nextInt();

        int[] coins = new int[coinsSize];

        for (int i = 0; i < coinsSize; i++) {
            coins[i] = fs.nextInt();
        }

        System.out.println(solveUsingDP(coins, target));
    }

    public static long solveUsingDP(int[] coins, int target) {
        long[] dp = new long[target + 1];
        dp[0] = 1;

        for (int sum = 1; sum <= target; sum++) {
            for (int coin : coins) {
                if (sum >= coin) {
                    dp[sum] = (dp[sum] + dp[sum - coin]) % MOD;
                }
            }
        }

        return dp[target];
    }
}