import java.io.*;
import java.util.*;
public class NoOfIslands 
{
    static byte[][] grid;
    public static void DFS(int i,int j) 
    {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
        {
            return;
        }
        if(grid[i][j] == 0 || grid[i][j] == 2)
        {
            return;
        }
        if(grid[i][j] == 1)
        {
            grid[i][j] = 2;
        }
        int row[] = { -1, 1, 0, 0};
        int col[] = { 0, 0, 1, -1};
        for(int cell = 0;cell<=3;cell++)
        {
            DFS(i+row[cell],j+col[cell]);
        }
    }
    public static int noOfIslands() 
    {
        int result = 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 1)
                {
                    DFS(i,j);
                    ++result;
                }
            }
        }
        return result;    
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        grid = new byte[M][N];
        for(int i=0;i<M;i++)
        {
            for(int j=0;j<N;j++)
            {
                grid[i][j] = Byte.parseByte(br.readLine());
            }   
        }

        System.out.println(noOfIslands());
    }
}
