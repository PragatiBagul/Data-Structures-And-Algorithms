import java.io.*;
import java.util.*;
public class Graph {
    private class Vertex
    {
        HashMap<String,Integer> neighbours = new HashMap<String,Integer>();
    }

    HashMap<String,Vertex> vertices = new HashMap<>();

    HashMap<String,Boolean> visited = new HashMap<>();
    public void addVertex(String vname)
    {
        vertices.put(vname,new Vertex());
    }

    public void addEdge(String vname1,String vname2,int cost) 
    {
        Vertex v1 = vertices.get(vname1);
        Vertex v2 = vertices.get(vname2);

        if(v1 == null || v2 == null || v1.neighbours.containsKey(vname2) || v2.neighbours.containsKey(vname1))
        {
            return;
        }

        v1.neighbours.put(vname2,cost);
        v2.neighbours.put(vname1,cost);
    }

    public int totalVertices()
    {
        return vertices.size();
    }

    public void DFS(String vertex)
    {
        if(!visited.containsKey(vertex) || !visited.get(vertex))
        {
            visited.put(vertex,true);
            Vertex v = vertices.get(vertex);
            System.out.println(vertex);
            for(String n : v.neighbours.keySet())
            {
                DFS(n);
            }
        }
    }

    public void DFSStack(String vertex) 
    {
        Stack<String> stack = new Stack<>();
        stack.push(vertex);
        visited.put(vertex,true);
        while(!stack.isEmpty())
        {
            String v = stack.pop();
            System.out.println(v);
            Vertex vtx = vertices.get(v);
            for(String n : vtx.neighbours.keySet())
            {
                if(!visited.containsKey(n) || !visited.get(n))
                {
                    visited.put(n,true);
                    stack.push(n);
                }
            }
        }
    }
    public void BFSQueue(String vertex)
    {
        Queue<String> q = new LinkedList<>();
        q.add(vertex);
        visited.put(vertex,true);
        while(!q.isEmpty())
        {
            String v = q.remove();
            System.out.println(v);
            Vertex vtx = vertices.get(v);
            for(String n : vtx.neighbours.keySet())
            {
                if(!visited.containsKey(n) || !visited.get(n))
                {
                    visited.put(n,true);
                    q.add(n);
                }
            }
        }
    }

    HashMap<String,String> colors = new HashMap<>();

    public boolean isBipartite(String vname) 
    {
        Queue<String> q = new LinkedList<>();
        q.add(vname);
        colors.put(vname,"RED");
        while(!q.isEmpty())
        {
            String v = q.remove();
            String color = colors.get(v);
            Vertex vtx = vertices.get(v);
            for(String n : vtx.neighbours.keySet())
            {
                if(!colors.containsKey(n))
                {
                    if(color == "RED")
                    {
                        colors.put(n,"BLUE");
                    }
                    else 
                    {
                        colors.put(n,"RED");
                    }
                }
                else if(colors.containsKey(n))
                {
                    if(color.equals(colors.get(n)))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void display() {
        System.out.println("-------------------------------------------------------------------------");
        ArrayList<String> keys = new ArrayList(vertices.keySet());
        for(String key : keys)
        {
            Vertex vtx = vertices.get(key);
            String str = key + " => " + vtx.neighbours;
            System.out.println(str);
        }
        System.out.println("-------------------------------------------------------------------------");
    }


    public static void main(String[] args) 
    {
        Graph g = new Graph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");

        g.addEdge("A","B",0);
        g.addEdge("B","C",0);
        g.addEdge("C","D",0);
        g.addEdge("D","E",0);
        g.addEdge("E","A",0);

        g.display();

        System.out.println(g.isBipartite("A"));
    }   
}
