import java.util.*;
public class NoConsequtiveHouses
{
    public static int getSolution(int[] houses)
    {
        int[] gain = new int[houses.length];
        gain[0] = houses[0];
        gain[1] = Math.max(houses[0],houses[1]);
        for(int i=2;i<houses.length;i++)
        {
            gain[i] = Math.max(houses[i] + gain[i-2],gain[i-1]);
        }
        return gain[houses.length-1];
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] houses = new int[N];
        for(int i=0;i<N;i++)
        {
            houses[i] = sc.nextInt();
        }
        System.out.println("Maximum amount robbed : "+getSolution(houses));
    }
}