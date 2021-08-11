import java.io.*;
import java.util.*;
public class Flowers
{
    public static int getSolution(int k,int a,int b)
    {
        int ways = 1;
        int[] dp = new int[b+1];
        dp[0] = 1;
        for(int i=1;i<=b;i++)
        {
            if(i<k)
            {
                dp[i] = dp[i-1];
            }
            else
            {
                dp[i] = dp[i-1] + dp[i-k];
            }
        }
        for(int i=1;i<=b;i++)
        {
            dp[i] = dp[i-1] + dp[i];
        }
        ways = dp[b] - dp[a-1];
        return ways;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int K = sc.nextInt();
        for(int t=0;t<T;t++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(getSolution(K,a,b));
        }
    }
}