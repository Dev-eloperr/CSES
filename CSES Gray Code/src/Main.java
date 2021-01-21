import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> prev = new ArrayList<>();
        prev.add(0 + "");
        prev.add(1 + "");
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            ArrayList<String> curr = new ArrayList<>();
            for (int j = 0; j < prev.size(); j++) {
                curr.add(0 + prev.get(j));
            }
            for (int j = prev.size() - 1; j >= 0; j--) {
                curr.add(1 + prev.get(j));
            }
            prev.clear();
            prev.addAll(curr);
        }
        for (String s : prev) {
            System.out.println(s);
        }
    }
}
