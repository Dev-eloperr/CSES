import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

  1,  2,  9, 10, 25, 26, 49,
  4,  3,  8, 11, 24, 27, 48,
  5,  6,  7, 12, 23, 28, 47,
 16, 15, 14, 13, 22, 29, 46,
 17, 18, 19, 20, 21, 30, 45,
 36, 35, 34, 33, 32, 31, 44,
 37, 38, 39, 40, 41, 42, 43,

DON'T USE Math.pow or Double

 */
public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int t = Integer.parseInt(bufferedReader.readLine());
        while (t>0){
            String[] input = bufferedReader.readLine().split(" ");
            valueFinder(Long.parseLong(input[0]),Long.parseLong(input[1]));

            t--;
        }


    }

    private static void valueFinder(long x, long y) {
        long val;
        if ( y > x){
            val = y % 2 == 0 ? ((y-1)*(y-1))+1+(x-1)       : (y*y)-(x-1);
        }else {
            val = x % 2 == 0 ? ((x-1)*(x-1))+1+(x-1)+(x-y) : (x*x)-(x-1)-(x-y);
        }
        System.out.println(val);
    }

}
