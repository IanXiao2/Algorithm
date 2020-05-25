package class07;

public class Problem07_LengthOfLIS {


    public static int lengthOfLIS1(int[] arr) {
        int N = arr.length;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < j; i++) {
                if(arr[i] < arr[j]) {
                    dp[j] = Math.max(dp[j], dp[i]+1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int lengthOfLIS2(int[] arr) {
        int N = arr.length;

        int[] ends = new int[N];
        int end = 0;
        ends[0] = arr[0];

        int index;
        for (int i = 1; i < N; i++) {
            if(arr[i] > ends[end]) {
                end++;
                ends[end] = arr[i];

            } else {
                index = farLeftIndex(ends, end, arr[i]);
                ends[index] = arr[i];
            }
        }
        return end + 1;
    }

    public static int farLeftIndex(int[] arr, int R, int num) {
        int L = 0;

        int index = R;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= num) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        int[] arr = {2,1,5,3,6,4,8,9,7};
        System.out.println(lengthOfLIS1(arr));
        System.out.println(lengthOfLIS2(arr));
    }
}
