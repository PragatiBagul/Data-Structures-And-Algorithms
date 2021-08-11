//Rat Maze
import java.util.*;
public class RatMaze
{
    static int totalPaths = 0;
    public static boolean safe(int i,int j,int N,boolean[][] visited)
    {
        if(i >=0 && j >=0 && i < N && j< N && !visited[i][j])
        {
            return true;
        }
        return false;
    }
    public static void helper(int N,int i,int j,int[][] maze,boolean[][] visited) 
    {
        if(i == N-1 && j == N-1)
        {
            totalPaths++;
            return;
        }
        if(!safe(i,j,N,visited))
        {
            //pruning
            return;
        }
        visited[i][j] = true;
        //recursion
        if(i+1 < N && maze[i+1][j] == 0) //Down
        {
            helper(N, i+1, j, maze, visited);
        }
        if(j+1 < N && maze[i][j+1] == 0) //Right
        {
            helper(N, i, j+1, maze, visited);
        }
        if(i-1 > -1 && maze[i-1][j] == 0) //Up 
        {
            helper(N, i-1, j, maze, visited);
        }
        if(j-1 > -1 && maze[i][j-1] == 0) //Left
        {
            helper(N, i, j-1, maze, visited);
        }
        visited[i][j] = false;
    }
    public static void findPaths(int N,int[][] maze)
    {
        boolean[][] visited = new boolean[N][N];
        helper(N, 0, 0, maze, visited);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] maze = new int[N][N];
        for(int i = 0;i<N;i++)
        {
            for(int j = 0;j<N;j++)
            {
                maze[i][j] = sc.nextInt();
            }    
        }
        findPaths(N, maze);
        System.out.println(totalPaths);
    }
}