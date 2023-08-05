import java.util.HashMap;
import java.util.Map;

public class MainAns {

    public int solution(int[] A) {
        int n = A.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                int prevLength = dp[j].getOrDefault(diff, 1);
                int currentLength = dp[i].getOrDefault(diff, 1);
                dp[i].put(diff, Math.max(currentLength, prevLength + 1));
                maxLength = Math.max(maxLength, dp[i].get(diff));
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        MainAns solution = new MainAns();

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
