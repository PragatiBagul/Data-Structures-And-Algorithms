import java.util.*;
public class DiceMoves
{
    static int moves = 0;
    public static void makeMoves(int N,int i,String path) 
    {
        if(i == N)
        {
            ++moves;
            System.out.println(path+" Reached");
            return;
        }
        if(i > N)
        {
            return;
        }
        makeMoves(N, i+1,path+"1 -> ");
        makeMoves(N, i+2,path+"2 -> ");
        makeMoves(N, i+3,path+"3 -> ");
        makeMoves(N, i+4,path+"4 -> ");
        makeMoves(N, i+5,path+"5 -> ");
        makeMoves(N, i+6,path+"6 -> ");
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        makeMoves(N,0,"");
    }
}