import java.util.*;
public class NextLargestElement
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++)
        {
            arr[i] = sc.nextInt();
        } 
        Stack<Integer> stack= new Stack<>();  
        stack.push(arr[0]);
        for(int i=1;i<N;i++)
        {
            if(stack.isEmpty())
            {
                stack.push(arr[i]);
                continue;
            }
            while(!stack.isEmpty() && stack.peek() < arr[i])
            {
                System.out.println(stack.peek()+" -> "+arr[i]);
                stack.pop();
            }
            stack.push(arr[i]);
        }
        while(!stack.isEmpty())
        {
            System.out.println(stack.peek()+" -> -1");
            stack.pop();
        }
    }
}