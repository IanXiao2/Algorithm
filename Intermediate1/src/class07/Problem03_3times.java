package class07;

public class Problem03_3times {


    public static int getNum(int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++) {
            long tmp = (long) (i + 1) * (long) i / 2L;
            if (tmp % 3 == 0) {
                sum++;
            }
        }
        return sum;
    }

    public static int getNum2(int l ,int r) {

        int res = 0;
        int sum = 0;
        for (int k = 1; k <= l-1; k++) {
            sum += k;
        }
        for (int i = l; i <= r; i++) {
            sum += i;
            if (sum % 3 == 0) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int l = 20;
        int r = 50;
        System.out.println(getNum(l, r));
        System.out.println(getNum(l, r));

    }
}
