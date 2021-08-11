import java.io.*;
import java.util.*;
public class CoinBoxes
{
    public static int[] getSolution(int[] S,int[] E,int N,int Q)
    {
        int[] coinBoxes = new int[N];
        int[] coins = new int[Q+1]; 
        coinBoxes[0] = S[0];
        coins[coinBoxes[0]]++;
        for(int i=1;i<N;i++)
        {
            coinBoxes[i] = coinBoxes[i-1] + S[i] - E[i-1];
            coins[coinBoxes[i]]++;
        }
        for(int i=Q;i>0;i--)
        {
            coins[i-1]+=coins[i];
        }
        return coins;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] S = new int[N];
        int[] E = new int[N];
        while(M!=0)
        {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            S[l]++;
            E[r]++;
            --M;
        }
        int Q = sc.nextInt();
        int[] solutions = getSolution(S,E,N,Q);
        while(Q!=0)
        {
            int q = sc.nextInt();
            try
            {
                System.out.println("Answer is : "+solutions[q]);
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Answer is : "+0);
            }
            --Q;
        }
    }
}
