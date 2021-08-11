/*
Given a number N = 5, print the pattern : 
* * * * *
* * * *
* * *
* *
*
*/
import java.util.*;
public class Patterns
{
    public static void printPattern(int N) 
    {
        if(N == 0)
        {
            return;
        }    
        for(int i = 0;i<N;i++)
        {
            System.out.print("*");
        }
        System.out.println();
        printPattern(N - 1);
    }
    public static void printPattern(int N,int l,int i)
    {
        if(l == 0)
        {
            return;
        }
        if(i < l)
        {
            System.out.print("*");
            printPattern(N,l,i+1);
        }
        else
        {
            System.out.println();
            printPattern(N,l-1,0);
        }

    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        printPattern(N,N,0);
    }
}