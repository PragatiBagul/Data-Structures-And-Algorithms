//Merge K sorted arrays into one sorted array
package heap;
import java.util.*;
public class MergeArrays {
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        MaxHeap heap = new MaxHeap(K);
        int[][] arrays = new int[K][N];
        for(int i=0;i<K;i++)
        {
            for(int j=0;j<N;j++)
            {
                arrays[i][j] = sc.nextInt();
            }   
        }
        for(int i=0;i<K;i++)
        {
            heap.insert(arrays[i][0]);
        }
        int[] sol = new int[N*K];
        int index = 0;
        for(int i=0;i<K;i++)
        {
            sol[index] = heap.extractMax();
            for(int j=1;j<N;j++)
            {
                heap.insert(arrays[i][j]);
            }   
        }
        for(int i:sol)
        {
            System.out.print(i+" ");
        }
    }   
}
