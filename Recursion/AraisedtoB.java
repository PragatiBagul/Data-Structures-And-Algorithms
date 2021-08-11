import java.io.*;
import java.util.*;
public class AraisedtoB
{
    static int count = 0;
    public static int powerOfBruteForce(int a,int b) 
    {
        ++count;
        if(b == 0)
        {
            return 1;
        }    
        if(b == 1)
        {
            return a;
        }
        return a * powerOfBruteForce(a,b-1);
    }
    public static int powerOf(int a,int b) 
    {
        ++count;
        if(b == 0)
        {
            return 1;
        }    
        if(b == 1)
        {
            return a;
        }
        int temp = powerOf(a,b/2);
        if(b%2 == 0)
        {
            return temp * temp;
        }
        else
        {
            return a * temp * temp;
        }
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(powerOfBruteForce(a, b));
        System.out.println("Count : " + count);
        count = 0;
        System.out.println(powerOf(a, b));
        System.out.println("Count : " + count);
    }
}