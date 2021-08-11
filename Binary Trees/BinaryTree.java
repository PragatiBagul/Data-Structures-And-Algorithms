import java.io.*;
import java.util.*;
public class BinaryTree 
{
    private class Node
    {
        int data;
        Node left;
        Node right;
    }

    private Node root;
    private int size;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public BinaryTree()throws Exception
    {
        this.root = createTree(null,0);   
    }
    public BinaryTree(int[] preorder,int[] inorder)throws Exception
    {
        this.root = constructTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    public Node createTree(Node parent,int child)throws Exception
    {
        if(parent == null && child == 0)
        {
            System.out.println("Enter the data-value of the root node : ");
        }
        else if(parent!=null && child == 1)
        {
            System.out.println("Enter the data-value of the left child of "+parent.data);
        }
        else if(parent!=null && child == 2)
        {
            System.out.println("Enter the data-value of the right child of "+parent.data);
        }
        int nodeValue = Integer.parseInt(br.readLine());
        Node current = new Node();
        current.data = nodeValue;

        this.size++;

        System.out.println("Does node "+current.data+" have left child ? ");
        String response = br.readLine().toLowerCase();
        if(response.equals("yes") || response.equals("y") || response.equals("true") || response.equals("t"))
        {
            current.left = createTree(current,1);
        }
        System.out.println("Does node "+current.data+" have right child ? ");
        response = br.readLine().toLowerCase();
        if(response.equals("yes") || response.equals("y") || response.equals("true") || response.equals("t"))
        {
            current.right = createTree(current,2);
        }
        return current;
    }

    public void preorder(Node root)
    {
        System.out.println(root.data);
        if(root.left!=null)
        {
            preorder(root.left);
        }
        if(root.right!=null)
        {
            preorder(root.right);
        }
    }

    public void inorder(Node root)
    {
        if(root.left!=null)
        {
            preorder(root.left);
        }
        System.out.println(root.data);
        if(root.right!=null)
        {
            preorder(root.right);
        }
    }

    public void postorder(Node root)
    {
        if(root.left!=null)
        {
            preorder(root.left);
        }
        if(root.right!=null)
        {
            preorder(root.right);
        }
        System.out.println(root.data);
    }

    public Node constructTree(int[] preorder,int[] inorder,int preLow,int preHigh,int inLow,int inHigh)
    {
        if(preLow > preHigh || inLow > inHigh)
        {
            return null;
        }
        Node current = new Node();
        current.data = preorder[preLow];
        int index = -1;
        for(int i=inLow;i<=inHigh;i++)
        {
            if(inorder[i] == current.data)
            {
                index = i;
                break;
            }
        }
        int newLow = index - inLow;
        current.left = constructTree(preorder, inorder, preLow + 1, preLow + newLow, inLow, index - 1);
        current.right = constructTree(preorder, inorder, preLow + newLow + 1, preHigh, index + 1, inHigh);
        return current;
    }

    public int getHeight(Node root)
    {
        if(root == null)
        {
            return -1;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int height = Math.max(leftHeight,rightHeight);
        return height + 1;
    }

    public int getDiameterBruteForce(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int leftDiameter = getDiameterBruteForce(root.left);
        int rightDiameter = getDiameterBruteForce(root.right); 
        int withRoot = getHeight(root.left) + getHeight(root.right) + 2;
        int diameter = Math.max(leftDiameter,Math.max(rightDiameter,withRoot));
        return diameter;
    }
    private class Dipair
    {
        int diameter ;
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

    public boolean isBalancedBruteForce(Node root)
    {
        if(root == null)
        {
            return true;
        }
        if(isBalancedBruteForce(root.left) && isBalancedBruteForce(root.right) && (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    class BalancedPair
    {
        int height;
        boolean balanced;
    }
    public BalancedPair isBalanced(Node root)
    {
        if(root == null)
        {
            BalancedPair nn = new BalancedPair();
            nn.height = -1;
            nn.balanced = true;
            return nn;
        }
        BalancedPair left = isBalanced(root.left);
        BalancedPair right = isBalanced(root.right);
        BalancedPair res = new BalancedPair();
        res.height = Math.max(left.height,right.height) + 1;
        if(left.balanced && right.balanced && (Math.abs(left.height - right.height) <= 1))
        {
            res.balanced = true;
        }
        else
        {
            res.balanced = false;
        }
        return res;
    }

    public void rightView(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        Node n = root;
        q.add(n);
        q.add(null);
        while(!q.isEmpty())
        {
            n = q.remove();
            if(n!=null && n.left!=null)
            {
                q.add(n.left);
            }
            if(n!=null && n.right!=null)
            {
                q.add(n.right);
            }
            if(q.peek() == null && n!=null)
            {
                System.out.print(n.data+" ");
                q.add(null);
                q.remove();
            }
        }
    }

    public void leftView(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        Node node = root;
        q.add(node);
        while(!q.isEmpty())
        {
            int n = q.size();
            System.out.print(q.peek().data);
            for(int i=0;i<n;i++)
            {
                node = q.remove();
                if(node.left!=null)
                {
                    q.add(node.left);
                }
                if(node.right!=null)
                {
                    q.add(node.right);
                }
            }
        }
    }

    public void BFS(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        Node node = root;
        q.add(node);
        while(!q.isEmpty())
        {
            int n = q.size();
            for(int i=0;i<n;i++)
            {
                node = q.remove();
                System.out.print(node.data+" ");
                if(node.left!=null)
                {
                    q.add(node.left);
                }
                if(node.right!=null)
                {
                    q.add(node.right);
                }
            }
        }
    }

    public boolean hasPath(Node root,ArrayList<Integer> path,int value)
    {
        if(root == null)
        {
            return false;
        }
        path.add(root.data);
        if(root.data == value)
        {
            return true;
        }
        if(hasPath(root.left, path, value) || hasPath(root.right, path, value))
        {
            return true;
        }
        path.remove(root.data);
        return false;
    }

    public boolean lowestCommonAncestor(Node root, int p,int q)
    {
        if(root == null)
        {
            return false;
        }
        boolean left = lowestCommonAncestor(root.left, p, q);
        boolean right = lowestCommonAncestor(root.right, p, q);
        boolean self = false;
        if(root.data == p || root.data == q )
        {
            self = true;
        }
        if(left && right || left && self || right && self)
        {
            System.out.println(root.data);
            return true;
        }
        if(left || right || self)
        {
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws Exception
    {
        BinaryTree tree = new BinaryTree();
    }
}