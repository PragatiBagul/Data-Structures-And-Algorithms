import java.io.*;
import java.util.*;
public class Permutations
{
    public static void generatePermutations(int[] elements,int index) 
    {
        if(index == elements.length)
        {
            for(int i : elements)
            {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        for(int i = index;i < elements.length;i++)
        {
            int temp = elements[i];
            elements[i] = elements[index];
            elements[index] = temp;
            generatePermutations(elements,index+1);
            temp = elements[i];
            elements[i] = elements[index];
            elements[index] = temp;
        }
    }
    public static void main(String[] args) throws Exception
    {
        int[] elements = {1,2,3};
        generatePermutations(elements, 0);
    }
}