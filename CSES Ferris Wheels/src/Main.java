import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        String[] i1 = bufferedReader.readLine().split(" ");
        String[] i2 = bufferedReader.readLine().split(" ");

        int n = Integer.parseInt(i1[0]);
        int x = Integer.parseInt(i1[1]);

        Integer[] pi = new Integer[n]; //to use merge sort, i.e why Integer

        for (int i=0; i<n; i++)
            pi[i]=Integer.parseInt(i2[i]); //O(n)

        int st=0;
        int la=n-1;
        int count=0;

        Arrays.sort(pi); //O(nlogn)

        while (st < la ){ //O(n)
            if (pi[la]+pi[st]<=x){
                count++;
                st++;
            }else if (pi[la]<=x) {
                count++;
            }
            la--;
        }

        if (st==la)
            count++;
        System.out.println(count);

    }
}
