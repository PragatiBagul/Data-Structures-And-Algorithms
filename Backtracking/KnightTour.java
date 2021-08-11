import java.util.Scanner;
public class KnightTour 
{
    static long totalTours = 0;
    public static boolean isSafe(int[][] grid,int row,int column,int N)
    {
        return (row >= 0) && (column >= 0) && (row < N) && (column < N) && (grid[row][column] == -1);
    }
    public static void knightTour(int[][] grid,int row,int column, int visitedCells,int N)
    {
        if(visitedCells == N * N)
        {
            ++totalTours;
            return;
        }
        if(visitedCells > N*N)
        {
            return;
        }
        int[] x = {-2,  -1, 1,  2,  -2, -1, 1,  2};
        int[] y = {1,  2,  2,  1,  -1, -2, -2, -1};
        grid[row][column] = visitedCells;
        for(int l=0;l<8;l++)
        {
            if(isSafe(grid,row + x[l],column+y[l],N))
            {
                knightTour(grid, row + x[l], column + y[l], visitedCells + 1, N);
            }
        }
        grid[row][column] = -1;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] grid = new int[N][N];        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                grid[i][j] = -1;
            }    
        }
        knightTour(grid,0,0,1,N);
        System.out.println(totalTours);
    }
}
