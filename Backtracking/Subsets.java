import java.io.*;
import java.util.*;
public class Subsets
{
    public static void generateSubsets(int[] arr,int index,ArrayList<Integer> ans) 
    {
        if(index == arr.length)
        {
            for(int x: ans)
            {
                System.out.print(x);
            }
            System.out.println();
        }    
        else
        {
            ans.add(arr[index]);
            generateSubsets(arr,index + 1,ans);
    
            ans.remove(ans.size() - 1);
            generateSubsets(arr,index + 1,ans);
        }
    }
    public static void main(String[] args) throws Exception
    {
        int[] arr = {1,2,3,4};
        ArrayList<Integer> ans = new ArrayList<>();
        generateSubsets(arr, 0, ans);
    }
}