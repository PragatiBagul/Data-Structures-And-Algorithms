import java.util.*;
public class N_QueensOptimised 
{
    static BitSet columns,leftDiagonals,rightDiagonals;
    static int totalWays = 0;
    public static void arrange(int N,int curr_row) 
    {
        if(curr_row == N)
        {
            ++totalWays;
            return;
        }
        for(int col = 0;col < N;col++)
        {
            if(!columns.get(col) && !leftDiagonals.get(curr_row - col + N - 1) && !rightDiagonals.get(curr_row + col))
            {
                columns.set(col);
                leftDiagonals.set(curr_row - col + N - 1);
                rightDiagonals.set(curr_row + col);
                arrange(N,curr_row+1);
                columns.clear(col);
                leftDiagonals.clear(curr_row - col + N - 1);
                rightDiagonals.clear(curr_row + col);
            }
        }
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        columns = new BitSet(N);
        leftDiagonals = new BitSet(2*N - 1);
        rightDiagonals = new BitSet(2*N - 1);
        arrange(N,0);
        System.out.println(totalWays);
    }
}
