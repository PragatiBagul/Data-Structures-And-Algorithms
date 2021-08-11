package heap;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
//Given an array of size N and an integer K. Find the minimum and maximum cost of dividing the array in K partitions, where cost of each partition[l.r] is defined as A[l]+A[r].
//Total cost = sum of cost of each partition.
public class KPartitions
{
    public static void partitionCost(long[] A,int N,int K) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        
        long maxCost = A[0] + A[N-1];
        long minCost = A[0] + A[N-1];

        for(int i=0;i<N-1;i++)
        {
            maxHeap.add(A[i]+A[i+1]);
            minHeap.add(A[i]+A[i+1]);
        }
        for(int i=0;i<K-1;i++)
        {
            maxCost += maxHeap.poll();
            minCost += minHeap.poll();
        }
        System.out.println(maxCost+" "+minCost);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long[] arr = new long[N];
        for(int i=0;i<N;i++)
        {
            arr[i] = sc.nextLong();
        }
        partitionCost(arr,N,K);
    }
}