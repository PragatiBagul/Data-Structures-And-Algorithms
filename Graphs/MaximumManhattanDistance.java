import java.io.*;
import java.util.*;
public class MaximumManhattanDistance {
    private static class Triplet
    {
        int x,y,dist;
        Triplet(int x,int y,int dist)
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static byte[][] grid;
    static boolean[][] visited;

    public static int maxMHDistance(Queue<Triplet> q) 
    {
        int maxDistance = 0 ;
        Triplet deadEnd = new Triplet(-1,-1,-1);
        while(!q.isEmpty())
        {
            Triplet cell = q.remove();
            if(cell.equals(deadEnd))
            {
                if(!q.isEmpty())
                {
                    q.add(deadEnd);
                }
                else
                {
                    break;
                }
            }
            else
            {
                maxDistance = cell.dist;
                int[] r = { -1, 1, 0, 0};
                int[] c = { 0, 0, -1, 1};
                for(int t = 0; t <= 3; t++)
                {
                    int row = cell.x + r[t];
                    int col = cell.y + c[t];
                    if(row  >= 0 && col >= 0 && row < grid.length && col < grid.length)
                    {
                        if(!visited[row][col])
                        {
                            visited[row][col] = true;
                            q.add(new Triplet(row,col,maxDistance + 1));
                        }
                    }
                }
            }
        }
        return maxDistance;
    }
    public static void display(Queue<Triplet> q) 
    {
        Iterator iterator = q.iterator();
  
        while (iterator.hasNext()) 
        {
            Triplet c = (Triplet)iterator.next();
            System.out.print(c.x+ " " +c.y+" "+c.dist);
        }    
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        grid = new byte[N][N];
        visited = new boolean[N][N];
        Queue<Triplet> q = new LinkedList<>();
        for(int i = 0;i < N; i++)
        {
            for(int j = 0;j < N; j++)
            {
                grid[i][j] = Byte.parseByte(br.readLine());
                if(grid[i][j] == 1)
                {
                    q.add(new Triplet(i,j,0));
                    visited[i][j] = true;
                }
            }   
        }
        if(!q.isEmpty())
            q.add(new Triplet(-1,-1,-1));
        
        display(q);
        System.out.println("Maximum Manhattan Distance : "+maxMHDistance(q));
    }  
}
