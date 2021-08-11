import java.io.*;
import java.util.*;
public class PartyPeople
{
    public static int noOfWays(int n)
    {
        if(n<=2)
        {
            return n;
        }
        return noOfWays(n-1) + (n-1)*noOfWays(n - 2);
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(noOfWays(sc.nextInt()));
    }
}