import java.io.*;
import java.util.*;
public class MCOINS
{
    public static boolean[] getSolution(int K,int L) 
    {
        boolean[] dp = new boolean[1000006];
        dp[1] = true;
        dp[K] = true;
        dp[L] = true;
        for(int i=2;i<1000006;i++)
        {
            if(i == L || i == K) continue;
            if(!dp[i-1]) dp[i] = true;
            if(!dp[i-K]) dp[i] = true;
            if(!dp[i-L]) dp[i] = true;
        }
        return dp;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int L = sc.nextInt();
        boolean[] solutions = getSolution(K,L);
        int M = sc.nextInt();
        int[] m = new int[M];
        for(int i=0;i<M;i++)
        {
            m[i] = sc.nextInt();
            if(solutions[m[i]])
            {
                System.out.print("A");
            }
            else
            {
                System.out.print("B");
            }
        }
    }
}