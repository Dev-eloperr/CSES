import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str;
        StringBuffer res = new StringBuffer();
        double a,b;
        for (int i = 0 ; i < n ; i++ ){
            str = br.readLine().split(" ");
            a = Double.parseDouble(str[0]);
            b = Double.parseDouble(str[1]);

            double x = (2*b - a)/3;

            if (!(a > 2*b || b > 2*a) && x == (long)x)
                res.append("YES\n");
            else
                res.append("NO\n");

        }
        System.out.print(res);
    }

}
