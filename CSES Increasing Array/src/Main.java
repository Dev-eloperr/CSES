import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] str = bufferedReader.readLine().split(" ");
        //long[] array = new long[n];
        long res=0,curr,prev;
        for(int i=1; i<n;i++){
            curr = Long.parseLong(str[i]);
            prev = Long.parseLong(str[i-1]);
            if(curr < prev){
                res = res + (prev - curr);
                str[i] = str[i-1];
            }
            //array[i] = Long.parseLong(str[i]);
        }
        System.out.println(res);
    }
}
