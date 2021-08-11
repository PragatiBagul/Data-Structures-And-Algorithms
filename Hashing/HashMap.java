import java.io.*;
import java.util.LinkedList;
public class HashMap<K,V>
{
    private class HMNode
    {
        K key;
        V value;
        public HMNode(K key,V value)
        {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString()
        {
            return this.key + " => "+this.value;
        }
    }

    private LinkedList<HMNode>[] bucketArray;
    private int size;
    
    public HashMap()
    {
        this(5);
    }
    public HashMap(int cap)
    {
        this.bucketArray = (LinkedList<HMNode>[])new LinkedList[cap];
        this.size = 0;

        for(int i=0;i<bucketArray.length;i++)
        {
            bucketArray[i] = new LinkedList<HMNode>();
        }
    }

    public void put(K key,V value)
    {
        int bi = hashFunction(key);
        LinkedList<HMNode> bucket = bucketArray[bi];
        //Check if the value is present in the hashmap
        int fi = findInBucket(bucket, key);
        if (fi == -1) {
            HMNode nn = new HMNode(key, value);
            this.size++;
            //adding the node in the end of the linked list
            bucket.addLast(nn);
        } else {
            //Fetching the node
            HMNode ntbu = bucket.get(fi);
            //updating the node value
            ntbu.value = value;
        }

        //Calculate the load factor again. 
        //If it is greater than 1 then do rehashing here.
        //Load factor denotes the ratio of the no. of elements in the hashmap divided by size of hashmap;

        double loadFactor = (double) (this.size / this.bucketArray.length);
        if (loadFactor > 1) {
            //then rehash
            rehash();
        }
    }
    
    public void rehash()
    {
        //Store the previous array first
        LinkedList<HMNode>[] oba = this.bucketArray;

        //Create a new array of double size.
        this.bucketArray = (LinkedList<HMNode>[]) new LinkedList[2 * oba.length];
        
        //Size of the new array is currently zero
        this.size = 0;

        for(int i=0;i<bucketArray.length;i++)
        {
            bucketArray[i] = new LinkedList<HMNode>();
        }

        //Put all the previous values in the new Array
        for(int i=0;i<oba.length;i++)
        {
            LinkedList<HMNode> bucket = oba[i];
            for(int j=0;j<bucket.size();j++)
            {
                HMNode node = bucket.get(j);
                put(node.key, node.value);
            }
        }
    }
    private int hashFunction(K key)
    {
        int hc = key.hashCode();
        int bi = Math.abs(hc) % bucketArray.length;
        return bi;
    }

    private int findInBucket(LinkedList<HMNode> bucket,K key)
    {
        for (int i = 0; i < bucket.size(); i++)
        {
            HMNode pn = bucket.get(i);
            if (pn.key.equals(key)) {
                return i;
            }
        }
        return -1;   
    }
    public static void main(String[] args) 
    {
        
    }
}