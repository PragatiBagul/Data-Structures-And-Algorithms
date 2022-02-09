import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class TopologicalSort{

    static HashMap<Integer,ArrayList<Integer>> adjList = new HashMap<Integer,ArrayList<Integer>>();
    static HashMap<Integer,Boolean> visited = new HashMap<>();
    static HashMap<Integer,Integer> indegree = new HashMap<>();
    static ArrayList<Integer> T = new ArrayList<>();
    public static void display()
    {
        System.out.println("Indegree  : ");
        for(Map.Entry entry : indegree.entrySet())
        {
            System.out.println((Integer)entry.getKey()+" "+(Integer)entry.getValue());
        }  

        System.out.println("Adjacency List");
        for(Map.Entry entry : adjList.entrySet())
        {
            System.out.println((Integer)entry.getKey()+" "+(ArrayList<Integer>)entry.getValue());
        }  
    }
    public static void topologicalSort() 
    {
        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry entry : indegree.entrySet())
        {
            if((Integer)entry.getValue() == Integer.parseInt("0"))
            {
                q.add((Integer)entry.getKey());

                System.out.println("Added to queue : "+(Integer)entry.getKey());
                visited.put((Integer)entry.getKey(),true);
            }
        }  
        while(!q.isEmpty())
        {
            int vertex = q.remove();
            T.add(vertex);
            ArrayList<Integer> neighbors = adjList.get(vertex);
            for(int n : neighbors)
            {
                if(!visited.get(n))
                {
                    int indg = indegree.get(n) - 1;
                    indegree.put(n,indg);
                    if(indg == 0)
                    {
                        q.add((Integer)n);
                        System.out.println("Added to queue : "+(Integer)n);
                        visited.put((Integer)n,true);
                    }
                }
            }
        }  
    }
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        for(int i = 0;i < M; i++)
        {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            if(!adjList.containsKey(src))
            {
                adjList.put(src,new ArrayList<Integer>());
            }
            if(!adjList.containsKey(dest))
            {
                adjList.put(dest,new ArrayList<Integer>());
            }
            if(!indegree.containsKey(src))
            {
                indegree.put(src,0);
            }
            if(!indegree.containsKey(dest))
            {
                indegree.put(dest,0);
            }
            if(!visited.containsKey(src))
            {
                visited.put(src,false);
            }
            if(!visited.containsKey(dest))
            {
                visited.put(dest,false);
            }
            int indg = indegree.get(dest);
            indegree.put(dest,indg + 1);
            ArrayList<Integer> neighbors = adjList.get(src);
            neighbors.add(dest);
            adjList.put(src,neighbors);
        }
        display();
        topologicalSort();
        System.out.println(T);
    }
}