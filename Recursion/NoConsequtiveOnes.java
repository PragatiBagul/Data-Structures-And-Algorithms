import java.io.*;
import java.util.*;
/*How many no. of binary strings can be created of length N, with no consequtive ones. */
public class NoConsequtiveOnes
{
    public static int count(int n)
    {
        if(n == 1)
        {
            return 2;
        }
        if(n == 2)
        {
            return 3;
        }
        return count(n - 1) + count(n - 2);
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(count(N));
    }
}