public class IncreasingSubsequencesOfLengthK {
    public static void main(String[] args) {
        int[] arr = { 12, 8, 11, 13, 10, 15, 14, 16, 20 };
        System.out.println(getTotalIncreasingSequences(arr,4));
    }

    public static int getTotalIncreasingSequences(int[] arr,int k) 
    {
        int n = arr.length;
        int[][] dp = new int[k + 1][arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            dp[0][i] = 1;
        }
        for (int l = 1; l < k; l++) {
            for (int i = l; i < n; i++) {
                for (int j = l - 1; j < i; j++) {
                    if (arr[j] < arr[i]) {
                        dp[l][i] += dp[l - 1][j];
                    }
                }
            }
        }
        int sum = 0;
        for (int i = k - 1; i < n; i++) {
            sum += dp[k - 1][i];
        }
        return sum;
    }
}
