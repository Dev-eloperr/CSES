import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        comb(new Scanner(System.in).nextInt());
    }
    static void comb(int n){
        long[] dp = new long[n+7];
        dp[1]=1;
        for (int i = 2; i <= n; i++)
            if (i<7) dp[i] = 2*dp[i-1];
            else dp[i] = (dp[i-1]+dp[i-2]+dp[i-3]+dp[i-4]+dp[i-5]+dp[i-6])%(1000000007);
        System.out.println(dp[n]%(1000000007));

    }
}
