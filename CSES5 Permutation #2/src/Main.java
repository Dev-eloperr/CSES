import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int i;
        StringBuilder s = new StringBuilder();
        if(n<=3){
            if(n==1){
                System.out.print(1);
            }
            else System.out.print("NO SOLUTION");
        }else{
            for ( i= 1; i <= n/2; i++){
                //System.out.print(2*i+" ");
                s.append(2*i);
                s.append(" ");
            }
            for ( i = 0; i <= n/2; i++){
                //System.out.print(2*i+1+" ");
                s.append(2*i+1);
                s.append(" ");
            }
        }
        //System.out.print(s.toString());

        try {
            BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
            log.write(s.toString());
            log.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
