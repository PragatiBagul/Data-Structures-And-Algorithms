//Longest Possible Cycle
import java.io.*;
import java.util.*;
class LargestCycle
{
    private static class Node
    {
        int data;
        Node left;
        Node right;
    }
    private class Dipair
    {
        int diameter;
        int height;
    }
    public Dipair getDiameter(Node root)
    {
        if(root == null)
        {   
            Dipair node = new Dipair();
            node.diameter = 0;
            node.height = -1;
            return node;
        }
        Dipair left = getDiameter(root.left);
        Dipair right = getDiameter(root.right); 
        Dipair res = new Dipair();
        res.height = Math.max(left.height,right.height) + 1;
        int ld = left.diameter;
        int rd = right.diameter;
        int sp = left.height + right.height + 2;
        res.diameter = Math.max(ld,Math.max(rd,sp));
        return res;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Node[] nodes = new Node[N+1];
        for(int i=1;i<=N;i++)
        {
            nodes[i] = new Node();
            nodes[i].data = i;
        }
        for(int i=1;i<N;i++)
        {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            if(nodes[parent].left == null)
            {
                nodes[parent].left = nodes[child];
            }
            else if(nodes[parent].right == null)
            {
                nodes[parent].right = nodes[child];
            }
        }
        Node root = nodes[1];
    }
}