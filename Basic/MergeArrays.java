//Merge two arrays
import java.util.*;
public class MergeArrays {
    public static int[] merge(int[] a,int[] b) 
    {
        int i=0,j=0;
        int N = a.length;
        int M = b.length;
        int index = 0;
        int[] ans= new int[N+M];
        while((i<N && j<M)&& index<(N+M))
        {
            if(a[i]<=b[j])
            {
                ans[index] = a[i];
                ++i;
            }
            else 
            {
                ans[index] = b[j];
                ++j;
            }
            ++index;
        }   
        while(i<N)
        {
            ans[index] = a[i];
            ++i;
            ++index;
        }
        while(j<M)
        {
            ans[index] = b[j];
            ++j;
            ++index;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        for(int i=0;i<N;i++)
        {
            arr1[i] = sc.nextInt(); 
        }
        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for(int i=0;i<M;i++)
        {
            arr2[i] = sc.nextInt(); 
        }
        int[] sol = merge(arr1,arr2);
        for(int num : sol)
        {
            System.out.print(num+" ");
        }
    }
}
