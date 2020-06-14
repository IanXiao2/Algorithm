package class01;

public class Problem09_NumberOf1 {

    public static int NumberOf1(int n) {
        int ans = 0;

        while (n != 0) {
            ans++;
            n = n & (n-1);
        }

        return ans;
    }



    public static void main(String[] args) {

        int n = 10;
        System.out.println(NumberOf1(n));

    }
}
