import java.util.*;
public class AttackingKnights {
    static int totalWays = 0;
    public static boolean isSafe(boolean[][] grid,int row,int col,int N) 
    {
        int[] x = {-2,  -1,  -2, -1};
        int[] y = {1,  2,  -1, -2};
        for(int l=0;l<4;l++)
        {
            if(row+x[l] >= 0 && row+x[l] < N && col+y[l] >= 0 && col+y[l] < N && grid[row+x[l]][col+y[l]])
            {return false;}
        }
        return true;
    }

    public static void arrange(int N,boolean[][] grid,int row,int col,int count) 
    {
        if(count == N)
        {
            ++totalWays;
            display(grid);
            System.out.println();
            return;
        }
        for(int i = row;i<N;i++)
        {
            for(int j = (i==row)?col:0;j<N;j++)
            {
                if(isSafe(grid, i, j, N))
                {
                    grid[i][j] = true;
                    arrange(N, grid, i, j+1, count+1);
                    grid[i][j] = false;
                }
            }
        }    
    }
    public static void display(boolean[][] grid)
    {
        for(int i = 0;i < grid.length;i++)
        {
            for(int j = 0;j < grid.length;j++)
            {
                System.out.print(grid[i][j] ? "K" : "#");
                System.out.print(" ");
            }    
            System.out.println();
        }
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arrange(N, new boolean[N][N], 0, 0, 0);
        System.out.println(totalWays);
    }
}
