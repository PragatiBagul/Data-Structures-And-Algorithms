//Undirected Graph

import java.io.*;
import java.util.ArrayList;
public class IsCyclic {
    static ArrayList<Integer> adjList[];
    static boolean[] visited;

    static boolean isCyclic(int src,int parent)
    {
        for(int i : adjList[src])
        {
            if(i!=parent)
            {
                if(visited[i])
                {
                    return true;
                }
                visited[i] = true;
                return isCyclic(i, src);
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N];
        visited = new boolean[N];
        for(int i=0;i<N;i++)
        {
            adjList[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++)
        {
            int from = Integer.parseInt(br.readLine());
            int to = Integer.parseInt(br.readLine());
            adjList[from - 1].add(to - 1);
            adjList[to - 1].add(from - 1);
        }   

        System.out.println(isCyclic(0,-1));
    }   
}
