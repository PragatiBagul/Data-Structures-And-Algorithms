import java.io.*;
public class BinaryStringModulo3
{
    static void build(String[] arr,String[] segmentTree,int tidx,int start,int end)
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

    static void update(String[] arr,String[] segmentTree,int tidx,int start,int end,int index,String value)
    {
        if(start == end)
        {
            arr[index] = value;
            segmentTree[tidx] = value;
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

    static String query(String[] tree,int start,int end,int left,int right,int tindex)
    {
        if(start > right || end < left)
        {
            //completely outside
            return "";
        }
        if(start >= left && end <= right)
        {
            //complete overlap
            return tree[tindex];
        }

        int mid = (start + end)/2;
        String l = query(tree, start, mid, left, right, 2*tindex + 1);
        String r = query(tree, mid+1, end, left, right, 2*tindex + 2);
        return l+r;
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i=0;i<N;i++)
        {
            arr[i] = br.readLine(); 
        }

        //Building the tree
        String[] segmentTree = new String[4*N];
        build(arr, segmentTree, 0, 0, N-1);

        for(int i=0;i<4*N;i++)
        {
            System.out.print(segmentTree[i]+" ");
        }
        
        int Q = Integer.parseInt(br.readLine());
        for(int i=0;i<Q;i++)
        {
            int left = Integer.parseInt(br.readLine()); 
            int right = Integer.parseInt(br.readLine()); 
            String value = query(segmentTree, 0, N-1, left, right, 0);
            System.out.println(value);
        }

        update(arr, segmentTree, 0, 0, N-1, 2, "1");


        for(int i=0;i<4*N;i++)
        {
            System.out.print(segmentTree[i]+" ");
        }
        
        Q = Integer.parseInt(br.readLine());
        for(int i=0;i<Q;i++)
        {
            int left = Integer.parseInt(br.readLine()); 
            int right = Integer.parseInt(br.readLine()); 
            String value = query(segmentTree, 0, N-1, left, right, 0);
            System.out.println(value);
        }
    }
}