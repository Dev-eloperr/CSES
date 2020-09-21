import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input;

        Map<Integer,Integer> map = new TreeMap<>();

        while (n-- > 0){
            input = br.readLine().split(" ");

            map.put(Integer.parseInt(input[0]),1);
            map.put(Integer.parseInt(input[1]),-1);
        }
        int sum=0;
        int res=0;

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            sum+=entry.getValue();
            if (res < sum)
                res = sum;
        }

        System.out.println(res);
    }
}
