import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solver{
    final private int n;
    int count;

    Solver(int n){
        this.n=n;
        count=0;
    }
    int res(int[][] board){
        solve(0, board);
        return count;
    }

    void solve(int col, int[][] board){

        for (int i=0; i < n; i++) {
            if (valid_pos(i, col, board) && board[i][col]!=2){
                board[i][col]=1;
                solve(col+1, board);
                board[i][col]=0;
                if(col == n-1) {
                    count++;
                    //print(board);
                }

            }

        }


    }
    void print(int[][] board){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }


    boolean valid_pos(int x, int y,int[][] board){

        for (int i = 0; i < y; i++) { //Columns before that
            if (board[x][i]==1)
                return false;

        }
        for (int a=x,b=y; a<n && b>=0 ;a++,b--) { //Diagonal top
            if (board[a][b]==1)
                return false;
        }
        for (int i = Integer.min(x,y)-1; i >= 0; i--) { //Diagonal below
            if (board[--x][--y]==1){
                return false;
            }
        }

        return true;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=8;
        int[][] board = new int[n][n];
        Solver solver = new Solver(n);

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
               if (str.charAt(j)=='.'){
                    board[i][j]=0;
               }
               else board[i][j]=2;
            }
        }

        System.out.println(solver.res(board));
    }

}
