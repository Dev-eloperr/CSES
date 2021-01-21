import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double an = Integer.parseInt(bufferedReader.readLine());
        double div = an/4;

        if(div == (int)div || (div+0.25) == (int)(div+0.25)){
            int s1 = (int)div;
            int s2 = (int)Math.ceil(div);
            StringBuilder l1 = new StringBuilder();
            StringBuilder l2 = new StringBuilder();
            int i,j,k;
            for (i=1,j=(int)an;i < s1+1; i++,j--) l1.append(i).append(" ").append(j).append(" ");
            int size = s1+s2;
            int size2 = s1+s2;
            for (k=s1+1;k<=size+s1;k++) l2.append(k).append(" ");
            if (s2!=s1){
                l1.append(j);
                l2.append(k);
                size2++;
            }
            System.out.println("YES"+"\n"+size+"\n"+l1+"\n"+size2+"\n"+l2);
        }else System.out.println("NO");

    }
}

