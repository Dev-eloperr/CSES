import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());

        while(n!=1){
            System.out.print(n+" ");
            if(n%2==0){
                n=n/2;

            }else{
                n=n*3+1;
            }
        }
        System.out.print(n);
    }
}