import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i=1; i<=n; i++){
            if (i==1){
                System.out.println(0);
            }else if (i==2){
                System.out.println(6);
            }else{
                long sq = i*i;
                long res = ((sq * (sq-1))/2) - 4*(i-2)*(i-1);
                System.out.println( res );
            }
        }

    }
}
