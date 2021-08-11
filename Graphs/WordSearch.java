import java.io.*;
public class WordSearch 
{
    public static boolean recurse(char[][] grid,char[] word,int n,int i,int r,int c) 
    {
        //base case
        if(r < 0 || c < 0 || r >= n || c >= n)  return false;

        //base case
        if(i > word.length) return false;

        //base case
        if(i == word.length) return true;

        //base case MAIN
        if(grid[r][c] != word[i]) return false;

        System.out.println("grid["+r+"]["+c+"] = "+grid[r][c]);
        //recursive intuition
        boolean retval = false;

        int[] rows = {-1,1,0,0};
        int[] cols = {0,0,-1,1};

        grid[r][c] = '$';

        for(int cell = 0;cell<=3;cell++)
        {
            retval = recurse(grid,word,n,i+1,r+rows[cell],c+cols[cell]);
            if(retval)
            {
                break;
            }
        }

        grid[r][c] = word[i];
        return retval;
    }
    public static boolean find(char[][] grid,char[] word,int n) 
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(word[0] == grid[i][j])
                {
                    //Found first letter of the word.
                    if(recurse(grid,word,n,0,i,j))
                    {
                        return true;
                    }
                }
            }   
        }    
        return false;
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] grid = new char[N][N];

        for(int i=0;i<N;i++)
        {
            grid[i] = br.readLine().toCharArray();
        }

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Enter the word : ");
        String s = br.readLine();
        char[] word = s.toCharArray();

        System.out.println(find(grid,word,N));
    }    
}
