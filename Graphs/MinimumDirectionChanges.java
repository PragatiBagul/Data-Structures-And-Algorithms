import java.io.*;
import java.util.Deque;
import java.util.ArrayDeque;
public class MinimumDirectionChanges {
    private static class Triplet
    {
        int row,col,cost;
        Triplet(int row,int col,int cost)
        {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    //addFirst()
    //addLast()
    //pollFirst()
    //pollLast()
    public static int minReplacement(char[][] grid) 
    {
        int M = grid.length;
        int N = grid[0].length;
        Deque<Triplet> dq = new ArrayDeque<Triplet>();
        boolean[][] visited = new boolean[M][N];
        int[] r = { -1, 1, 0, 0};
        int[] c = { 0, 0, 1, -1};
        dq.addFirst(new Triplet(0,0,0));
        while(!dq.isEmpty())
        {
            Triplet cute = dq.pollFirst();
            visited[cute.row][cute.col] = true;
            if(cute.row == M-1 && cute.col == N-1)
            {
                return cute.cost;
            }
            for(int cell = 0;cell <= 3;cell++)
            {
                int x = cute.row + r[cell];
                int y = cute.col + c[cell];

                if(x < 0 || y < 0 || x >= M || y >= N)
                {
                    continue;
                }
                if(visited[x][y])
                {
                    continue;
                }
                int cost;
                if(grid[cute.row][cute.col] == 'U' && r[cell] == -1 && c[cell] == 0) cost = 0;
                else if(grid[cute.row][cute.col] == 'D' && r[cell] == 1 && c[cell] == 0) cost = 0;
                else if(grid[cute.row][cute.col] == 'L' && r[cell] == 0 && c[cell] == -1) cost = 0;
                else if(grid[cute.row][cute.col] == 'R' && r[cell] == 0 && c[cell] == 1) cost = 0;
                else cost = 1;
                if(cost == 1)
                {
                    dq.addLast(new Triplet(x,y,cute.cost + cost));
                }
                else
                {
                    dq.addFirst(new Triplet(x,y,cute.cost + cost));
                }
            }
        }   
        return -1;
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        char[][] grid = new char[N][M];
        for(int i=0;i<M;i++)
        {
            for(int j=0;j<N;j++)
            {
                grid[i][j] = br.readLine().charAt(0);
            }   
        }
        System.out.println("\n\n"+minReplacement(grid));
    }
}
