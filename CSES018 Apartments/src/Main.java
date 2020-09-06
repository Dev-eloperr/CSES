import java.io.*;
import java.util.*;

//int j;
//        for (int i=0;i<n;i++){
//            for (j=i;j<m;j++){
//                if (req_sizes.get(i)-k <= apt_sizes.get(j) &&
//                        req_sizes.get(i)+k >= apt_sizes.get(j)){
//                    apt_sizes.remove(j);
//
//                    m--;
//                    count++;
//                    break;
//                }
//            }
//            req_sizes.remove(i);
//            i--;
//            n--;
//        }

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));



        String[] in_var = bufferedReader.readLine().split(" ");
        String[] in_req_sizes = bufferedReader.readLine().split(" ");
        String[] in_apt_sizes = bufferedReader.readLine().split(" ");


//        String[] in_var = new String[0];
//        String[] in_req_sizes = new String[0];
//        String[] in_apt_sizes = new String[0];
//        try {
//            File myObj = new File("C:\\Users\\devka\\IdeaProjects\\CSES018 Apartments\\src/input.txt");
//            Scanner myReader = new Scanner(myObj);
//            while (myReader.hasNextLine()) {
//                //String data = myReader.nextLine();
//                //System.out.println(data);
//                in_var = myReader.nextLine().split(" ");
//                in_req_sizes = myReader.nextLine().split(" ");
//                in_apt_sizes = myReader.nextLine().split(" ");
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }


        int n = Integer.parseInt(in_var[0]);
        int m = Integer.parseInt(in_var[1]);
        int k = Integer.parseInt(in_var[2]);

        List<Integer> req_sizes = new ArrayList<>();
        List<Integer> apt_sizes = new ArrayList<>();

        //System.out.println(in_req_sizes.length);
        //System.out.println(n+" "+m+" "+k);

        for (int i=0;i<n;i++)
            req_sizes.add(Integer.parseInt(in_req_sizes[i]));

        for (int j=0;j<m;j++)
            apt_sizes.add(Integer.parseInt(in_apt_sizes[j]));

        Solver solver = new Solver();
        System.out.println(solver.solve(req_sizes,apt_sizes,n,m,k));
        //System.out.println(solver.range(8,15,5));
//        System.out.println(n+" "+m+" "+" "+k);
//        System.out.println(req_sizes);
//        System.out.println(apt_sizes);



    }
}

class Solver{
    //HashSet<Integer> index = new HashSet<>();
    int solve(List<Integer> req_sizes, List<Integer> apt_sizes, int n, int m, int k){
        int count=0;
        int mid;
        int key;
        int low;
        int high;
        int range;

        Collections.sort(req_sizes);
        Collections.sort(apt_sizes);
        int i=0,j=0;
        int a,b;
        while(i<n && j<m){
            a=apt_sizes.get(j);
            b=req_sizes.get(i);
            //System.out.println(a+" "+b);
            range=range(a,b,k);
            if (range==0){
                i++;
                j++;
                count++;
            }else if(range==-1){
                i++;
            }else j++;
        }

        //System.out.println(req_sizes);
        //System.out.println(apt_sizes);

//        HashMap<Integer,Integer> apt_sizes_map = new HashMap<>();
//
//        for (int i=0; i<m;i++){
//            apt_sizes_map.put(i,apt_sizes.get(i));
//        }
        //System.out.println(apt_sizes_map);

//        for (int i=0; i<req_sizes.size(); i++){
//            low=0;
//            high= apt_sizes.size()-1;
//            //high = apt_sizes_map.size()-1;
//            key=req_sizes.get(i);
//
//            while(high >= low){
//                mid=low+(high-low)/2;
//
//                range = range(apt_sizes.get(mid),key,k);
//                if (range == 0){
//                    //index.add(mid);
//                    apt_sizes.remove(mid); //PROBLEM
//                    count++;
//                    break;
//                }else if(range == -1){
//                    high=mid-1;
//                }else
//                    low=mid+1;
//            }
//        }

        return count;
    }
    int range(int a, int b, int k){
        //System.out.println(b-k+" "+a+" "+(b+k));
        if (a>=b-k){
            if (a<=b+k)
                return 0;
            else
                return -1;
        }else return 1;
    }
}

class MainTest{
//5 5 0
//        33 121212 323232 323231 3232231
//        121212 33 1 323232 322321 12


}