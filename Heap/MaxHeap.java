package heap;
import java.util.Arrays;
public class MaxHeap
{
    int capacity,currSize;
    int[] heap; // l.O.T.

    public MaxHeap(int capacity)
    {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.currSize = 0;
    }

    public int left(int i)
    {
        return 2*i + 1;
    }
    public int right(int i)
    {
        return 2*i + 2;
    }
    public int parent(int i)
    {
        return (i-1)/2;
    }
    public int getMax()throws Exception
    {
        if(this.currSize == 0) throw new Exception("Heap is empty");
        return heap[0];
    }
    public int  extractMax()throws Exception
    {
        if(this.currSize == 0) throw new Exception("Heap is empty");
        if(this.currSize == 1)
        {
            this.currSize--;
            return this.heap[0]; 
        } 

        int maxValue = this.heap[0];
        heap[0] = heap[currSize - 1]; //copies value from root node
        currSize--; //removes the leaf
        heapify(0);
        return maxValue;
    }
    public void heapify(int root)
    {
        int i = root;
        //Finding index with max  value
        if(left(root) < currSize && heap[left(root)] > heap[i])
        {
            i = left(root);
        }
        if(right(root) < currSize && heap[right(root)] > heap[i])
        {
            i = right(root);
        }
        if(root != i)
        {
            swap(heap,i,root);
            heapify(i); 
        }
    }
    public void swap(int[] heap,int i,int root)
    {
        int temp = heap[i];
        heap[i] = heap[root];
        heap[root] = temp; 
    }

    public void insert(int key)throws Exception
    {
        if(this.currSize == this.capacity)
        { 
            throw new Exception("Heap is full");
        }
        this.currSize++;
        this.heap[currSize - 1] = key;
        
        int index = currSize - 1;
        while(index!=0 && this.heap[parent(index)] < this.heap[index])
        {
            swap(heap,index,parent(index));
            index = parent(index);
        }
    }
    public static void main(String[] args) throws Exception
    {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(1);
        maxHeap.insert(10);
        maxHeap.insert(7);
        maxHeap.insert(8);
        maxHeap.insert(9);

        System.out.println(maxHeap.getMax());
        System.out.println(maxHeap.extractMax());
        System.out.println(maxHeap.extractMax());
        System.out.println(maxHeap.extractMax());
        System.out.println(maxHeap.extractMax());
        System.out.println(maxHeap.extractMax());
        System.out.println(maxHeap.extractMax());
    }
}