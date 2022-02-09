import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class FindPeak {
    public static int findPeak(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        while (start <= end) {
            if ((mid == 0 && arr[mid] > arr[mid + 1]) || (mid == arr.length - 1 && arr[mid - 1] < arr[mid])
                    || (arr[mid] >= arr[mid + 1] && arr[mid] >= arr[mid - 1]))
                return mid;
            if (arr[mid] < arr[mid - 1])
                return findPeak(arr, start, mid);
            return findPeak(arr, mid + 1, end);
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int start = 0, end = arr.length;
        System.out.println(findPeak(arr, start, end));
    }
}
