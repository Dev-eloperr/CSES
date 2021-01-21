import java.io.*;
import java.math.BigInteger;
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(new BigInteger("2").pow(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())).modPow(new BigInteger("1"),new BigInteger("1000000007")));
    }
}
