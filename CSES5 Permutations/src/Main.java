import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int n = Integer.parseInt(bufferedReader.readLine());
        Solver solver = new Solver(n);
        solver.solve();
    }

}

class Solver{
    private int n;
    private List<Integer> array = new ArrayList<>();

    Solver(int n){
        this.n = n;
        for (int i = 0; i < n; i++){
            array.add(i+1);
        }
    }



    private boolean checkAdjacent(int iterator) { //Returns true if NOT beautiful
        if(n==1){
            return false;
        }

        if (iterator==0){
            return (array.get(iterator + 1) == array.get(iterator) + 1) || (array.get(iterator + 1) == array.get(iterator) - 1);
        }
        if (iterator==n-1){
            return (array.get(iterator - 1) == array.get(iterator) + 1) || (array.get(iterator - 1) == array.get(iterator) - 1);
        }
        return (array.get(iterator + 1) == array.get(iterator) + 1) || (array.get(iterator + 1) == array.get(iterator) - 1) ||
                (array.get(iterator - 1) == array.get(iterator) + 1) || (array.get(iterator - 1) == array.get(iterator) - 1);
    }
    void solve(){
        int iterator = 0;
        int flag=0;
        int count=0;
        do{
            count++;
            if(checkAdjacent(iterator)){
                if(flag==0){
                    swap0(iterator);
                    flag=1;
                }else{
                    swap1(iterator);
                    flag=0;
                }

            }else iterator++;
        }while(iterator<n && count<=2*n);
        flag=0;
        for (int i=0; i<n; i++){
            if (checkAdjacent(i)){
                System.out.print("NO SOLUTION");
                flag=1;
                break;
            }
        }
        if (flag==0){
            for (int i=0; i<n; i++){

                System.out.print(array.get(i)+" ");
            }
        }

    }

    private void swap1(int iterator) {
        if (iterator+4 <= n) {
            array.add(iterator + 4, array.get(iterator));
            array.remove(iterator);
        }else {
            int index = (iterator+4) - n;
            array.add(index, array.get(iterator));
            array.remove(iterator+1);
        }

        //System.out.println(iterator+" : "+array);
    }

    private void swap0(int iterator) {
        if (iterator+3 <= n){
            array.add(iterator+3,array.get(iterator));
            array.remove(iterator);
        }else {
            int index = (iterator+3) - n;
            array.add(index, array.get(iterator));
            array.remove(iterator+1);
        }


        //System.out.println(iterator+" : "+array);
    }
}