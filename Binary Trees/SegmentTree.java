import java.io.*;
public class SegmentTree
{
    static void build(int[] arr,int[] segmentTree,int tidx,int start,int end)
    {
        //base case
        if(start == end)
        {
            //leaf node
            segmentTree[tidx] = arr[start];
            return;
        }

        //recursive call
        int mid = (start + end)/2;
        build(arr, segmentTree, 2*tidx + 1, start, mid);
        build(arr, segmentTree, 2*tidx + 2, mid+1, end);

        //self work
        segmentTree[tidx] = segmentTree[2*tidx + 1] + segmentTree[2*tidx + 2];
    }

    static void update(int[] arr,int[] segmentTree,int tidx,int start,int end,int index,int value)
    {
        if(start == end)
        {
            arr[index] = Math.abs(value - 1);
            segmentTree[tidx] = Math.abs(value - 1);
            return;
        }
        int mid = (start + end)/2;
        if(index > mid)
        {
            update(arr, segmentTree, 2*tidx + 2, mid + 1, end, index, value);
        }
        else
        {
            update(arr, segmentTree, 2*tidx + 1, start, mid, index, value);
        }
        segmentTree[tidx] = segmentTree[2*tidx + 1] + segmentTree[2*tidx + 2];
    }

    static int query(int[] tree,int start,int end,int left,int right,int tindex)
    {
        if(start > right || end < left)
        {
            //completely outside
            return 0;
        }
        if(start >= left && end <= right)
        {
            //complete overlap
            return tree[tindex];
        }

        int mid = (start + end)/2;
        int l = query(tree, start, mid, left, right, 2*tindex + 1);
        int r = query(tree, mid+1, end, left, right, 2*tindex + 2);
        return l+r;
    }

    static int answer(int[] tree,int start,int end,int left,int right,int tindex)
    {
        String binaryString = query(tree, start, end, left, right, tindex);
        int value = Integer.parseInt(binaryString,2);  
        return value%3;
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++)
        {
            arr[i] = Integer.parseInt(br.readLine()); 
        }

        //Building the tree
        int[] segmentTree = new int[4*N];
        build(arr, segmentTree, 0, 0, N-1);
    }
}