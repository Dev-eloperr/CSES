import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String string = bufferedReader.readLine();
        String[] strings = string.split("");
        int temp=1, result=1;
        String prev = strings[0];
        for (int i=1; i < strings.length;i++){

            if (strings[i].equals(prev)){
                temp++;
            }else{
                temp=1;
                prev=strings[i];
            }
            if(temp>result)
                result=temp;
        }
        System.out.println(result);

    }
}
