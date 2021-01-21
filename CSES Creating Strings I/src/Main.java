import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        String in = new BufferedReader(new InputStreamReader(System.in)).readLine();
        Solver solver = new Solver();
        solver.perm("",in);
        solver.res();

    }
}

class Solver{
    private final StringBuffer res = new StringBuffer();
    //int x=0;
    SortedSet<String> set = new TreeSet<>();

    void perm(String prefix, String str){
        int n = str.length();

        for (int i=0;i<n;i++){
            perm(prefix+str.charAt(i)+"", str.substring(0,i)+str.substring(i+1,n));
        }
        if (n==0) {
            //res.append(prefix).append(str).append("\n");
            set.add(prefix + str);
            //x++;
        }


    }

    public void res() {
        //System.out.println(x);
        //System.out.println(res);

        System.out.println(set.size());
        for (String i : set)
            res.append(i).append("\n");
        System.out.println(res);
    }
}