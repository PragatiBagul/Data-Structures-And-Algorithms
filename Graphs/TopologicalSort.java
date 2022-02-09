import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class TopologicalSort{
    static HashMap<Integer,ArrayList<Integer>> adjList = new HashMap<Integer,ArrayList<Integer>>();
    public static void topologicalSortUtil(int v,Stack stack,boolean[] visited)
    {
          visited[v] = true;
          for(int i : adjList.get(v))
          {
              if(!visited[i])
              {
                  topologicalSortUtil(i, stack, visited);
              }
          }
          stack.push(v);
    }
    public static void topologicalSort(int N) 
    {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N];
        for(int i=0;i<N;i++)
        {
            if(!visited[i])
                topologicalSortUtil(i,stack,visited);
        }
        while(!stack.isEmpty())
        {
            System.out.println(stack.pop()+" ");
        }
    }
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        for(int i = 0;i < M; i++)
        {
            int src = sc.nextInt() - 1;
            int dest = sc.nextInt() - 1;
            if(!adjList.containsKey(src))
            {
                adjList.put(src,new ArrayList<Integer>());
            }
            if(!adjList.containsKey(dest))
            {
                adjList.put(dest,new ArrayList<Integer>());
            }
            adjList.get(src).add(dest);
        }
        topologicalSort(N);
    }
}