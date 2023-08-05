import java.util.Arrays;

public class Main {

    public int solution(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(A, 0, n - 1, 0, dp);
    }

    public int dfs(int[] arr, int i, int j, int prev, int[][] dp) {
        if (i >= j)
            return 0;
        int ans = Integer.MIN_VALUE;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (prev == 0) {
            ans = Math.max(ans, 1 + dfs(arr, i + 1, j - 1, arr[i] + arr[j], dp));
            ans = Math.max(ans, 1 + dfs(arr, i + 2, j, arr[i] + arr[i + 1], dp));
            ans = Math.max(ans, 1 + dfs(arr, i, j - 2, arr[j] + arr[j - 1], dp));
        } else {
            if (arr[i] + arr[j] == prev) {
                ans = Math.max(ans, 1 + dfs(arr, i + 1, j - 1, prev, dp));
            }
            if (arr[i] + arr[i + 1] == prev) {
                ans = Math.max(ans, 1 + dfs(arr, i + 2, j, prev, dp));
            }
            if (arr[j] + arr[j - 1] == prev) {
                ans = Math.max(ans, 1 + dfs(arr, i, j - 2, prev, dp));
            }
        }
        return dp[i][j] = ans;
    }

    public static void main(String[] args) {
        Main solution = new Main();

        int[] arr1 = {3, 1, 5, 3, 3, 4, 2};
        System.out.println(solution.solution(arr1)); // Output: 3

        int[] arr2 = {4, 1, 4, 3, 3, 2, 5, 2};
        System.out.println(solution.solution(arr2)); // Output: 4

        int[] arr3 = {1, 9, 1, 1, 1, 1, 1, 1, 8, 1};
        System.out.println(solution.solution(arr3)); // Output: 1

        int[] arr4 = {1, 9, 8, 9, 5, 1, 2};
        System.out.println(solution.solution(arr4)); // Output: 3

        int[] arr5 = {1, 1, 2, 3, 1, 2, 2, 1, 1, 2};
        System.out.println(solution.solution(arr5)); // Output: 4
    }
}
