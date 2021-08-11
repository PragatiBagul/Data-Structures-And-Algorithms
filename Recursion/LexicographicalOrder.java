import java.util.*;
public class LexicographicalOrder
{
    public static void lexico(int N,int i)
    {
        if(N < i)
        {
            return;
        }
        System.out.println(i);
        for(int j = (i == 0)?1:0;j<=9;j++)
        {
            lexico(N, 10*i+j);
        }
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        lexico(N,0);
    }
}