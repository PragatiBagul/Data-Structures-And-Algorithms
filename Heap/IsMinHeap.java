//There is a complete binary tree of N nodes. You have been provided with the Level Order Traversal.Can you tell me if this binary tree is also a min heap?
import java.util.*;
public class IsMinHeap
{
    public static int left(int i)
    {
        return 2*i+1;
    }
    public static int right(int i)
    {
        return 2*i+2;
    } 
    public static boolean isMinHeap(int[] L,int N)
    {
        for(int i=0;i<=N/2-1;i++)
        {
            if(left(i) < N && right(i)<N && (L[left(i)]<L[i] || L[right(i)]<L[i]))
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] L = new int[N];
        for(int i=0;i<N;i++)
        {
            L[i] = sc.nextInt();
        }
        System.out.println(isMinHeap(L, N));
    }
}