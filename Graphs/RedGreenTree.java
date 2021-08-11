import java.io.*;
import java.util.*;
public class RedGreenTree 
{
    static ArrayList<Integer> adjList[];
    static int countRed = 0,countGreen = 0,ans = 0;
    static char[] colors;
    static class Pair
    {
        int RED,GREEN;
    }
    public static Pair DFS(int src,int parent) 
    {   
        int r=0,g=0;
        if(colors[src] == 'R')
        {
            ++r;
        }
        else if(colors[src] == 'G')
        {
            ++g;
        }
        for(int neighbour : adjList[src])
        {
            if(neighbour!=parent)
            {
                Pair result = DFS(neighbour,src);
                if((result.RED == countRed && result.GREEN == 0)||(result.RED == 0 && result.GREEN == countGreen))
                {
                    ans += 1;
                }
                r += result.RED;
                g += result.GREEN;   
            }
        }
        Pair op = new Pair();
        op.RED = r;
        op.GREEN = g;
        return op;
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        colors = new char[N];
        adjList = new ArrayList[N];
        for(int i=0;i<N;i++)
        {
            System.out.println("Color of node "+ (i+1));
            colors[i] = br.readLine().toCharArray()[0];
            if(colors[i] == 'R')
            {
                ++countRed;
            }
            else if(colors[i] == 'G')
            {
                ++countGreen;
            }
            adjList[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<N-1;i++)
        {
            System.out.println("Enter the two end-points of the edge");
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            adjList[a-1].add(b-1);
            adjList[b-1].add(a-1);
        }

        DFS(0,-1);

        System.out.println(ans);
    }
}
