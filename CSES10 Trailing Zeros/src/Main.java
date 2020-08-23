import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if (n<5)
            System.out.println(0);
        else{
            int sum=0;
            for (long i=5; i <=n; i = i*5){
                sum += (n/i);
            }
            System.out.println(sum);
        }
    }
}
