// N Queens Problem
/*The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively. */
import java.io.*;
public class N_Queens
{
    static int ways = 0;
    public static boolean isSafe(boolean[][] grid,int row,int column,int N)
    {
        //same column
        for(int i=0;i<N;i++)
        {
            if(grid[row][i])
            {
                return false;
            }
        }
        //same row
        for(int i=0;i<N;i++)
        {
            if(grid[i][column])
            {
                return false;
            }
        }
        //upper left diagonal
        for(int i = row,j = column;i >= 0 && j >= 0;i--,j--)
        {
            if(grid[i][j])
            {
                return false;
            }
        }
        //upper right diagonal
        for(int i = row,j = column;i >= 0 && j < N;i--,j++)
        {
            if(grid[i][j])
            {
                return false;
            }
        }
        //lower left diagonal
        for(int i = row,j = column;i < N && j >= 0;i++,j--)
        {
            if(grid[i][j])
            {
                return false;
            }
        }
        //lower right diagonal
        for(int i = row,j = column;i < N && j < N;i++,j++)
        {
            if(grid[i][j])
            {
                return false;
            }
        }
        return true;
    }
    public static void arrange(boolean[][] grid,int curr_row,int N)
    {
        if(curr_row == N)
        {
            ++ways;
            display(grid);
            System.out.println();
            return;
        }
        for(int col=0;col<N;col++)
        {
            if(isSafe(grid,curr_row,col,N))
            {
                grid[curr_row][col] = true;
                arrange(grid, curr_row + 1, N);
                grid[curr_row][col] = false;
            }
        }
    }
    public static void display(boolean[][] grid)
    {
        for(int i = 0;i < grid.length;i++)
        {
            for(int j = 0;j < grid.length;j++)
            {
                System.out.print(grid[i][j] ? "Q" : "#");
                System.out.print(" ");
            }    
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] grid = new boolean[N][N];
        arrange(grid, 0, N);
        System.out.println("Total no. of ways : "+ways);
        
    }
}