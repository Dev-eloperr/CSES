import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String inp1 = br.readLine();
        final int n = Integer.parseInt(inp1.split(" ")[0]);
        final int c = Integer.parseInt(inp1.split(" ")[1]);
        final String[] inp2 = br.readLine().split(" ");
        final ArrayList<Integer> coins = new ArrayList<>();
        Arrays.stream(inp2).forEach(x -> coins.add(Integer.parseInt(x)));

        int[] dp = IntStream.generate(() -> -1).limit(c + 1).toArray();

        for (int i = 1; i <= c; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i - coins.get(j) == 0) {
                    dp[i] = 1;
                    break;
                } else if (i - coins.get(j) > 0 && dp[i - coins.get(j)] != -1) {
                    min = Integer.min(min, dp[i - coins.get(j)] + 1);
                    dp[i] = min;
                }
            }
        }
        System.out.println(dp[c]);
    }
}
