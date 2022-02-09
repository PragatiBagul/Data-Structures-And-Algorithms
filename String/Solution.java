import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(br.readLine());
            }
            ArrayList<Integer> x = new ArrayList<>();
            int SCORE = Integer.MAX_VALUE;

            for (int k = 0; k < pow(2, 31); k++) {
                int score = 0;
                for (int p = 0; p < arr.length; p++) {
                    score += k ^ arr[p];
                }
                if (SCORE == score) {
                    x.add(k);
                } else if (SCORE > score) {
                    x = new ArrayList<>();
                    x.add(k);
                    SCORE = score;
                }
            }
            System.out.println(SCORE);
            for (int each : x) {
                System.out.println(each);
            }
        }
    }
}
