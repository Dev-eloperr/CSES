
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int[] input = new int[n+1];
        String str = br.readLine();
        String[] in = str.split("\\s");

        for(int i=0;i<n-1;i++)
            input[Integer.parseInt(in[i])]=1;

        for (int i=1; i<n+1;i++){
            if(input[i]==0)
                System.out.print(i);
        }


    }
}
