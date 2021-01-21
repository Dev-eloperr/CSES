import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> charCount = new HashMap<>();
        String[] input = new BufferedReader(new InputStreamReader(System.in)).readLine().split("");
        int size=input.length;
        for (String s : input) {
            if (charCount.containsKey(s)) {
                charCount.put(s, charCount.get(s) + 1);
            } else {
                charCount.put(s, 1);
            }
        }
        int flag=0;
        int oddflag=0;
        StringBuffer res = new StringBuffer();

        StringBuffer center=new StringBuffer();
        for (HashMap.Entry<String,Integer> set : charCount.entrySet()){
            int val = set.getValue() % 2;

            if (val!=0){
                if (size%2==0 || oddflag==1){
                    flag=1;
                    break;
                }
                for (int l = 0 ; l<set.getValue(); l++)
                    center.append(set.getKey());
                oddflag++;

            }else {
                for (int k = 0; k < set.getValue()/2; k++)
                    res.append(set.getKey());
            }
        }

        if (flag==0){
            System.out.print(res);
            System.out.print(center);
            res.reverse();
            System.out.print(res);
        }else System.out.println("NO SOLUTION");

    }
}
