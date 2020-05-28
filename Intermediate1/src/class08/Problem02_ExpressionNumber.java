package class08;

public class Problem02_ExpressionNumber {


    public static boolean isValid(char[] exp) {
        if ((exp.length & 1) == 0) {
            return false;
        }
        for (int i = 0; i < exp.length; i += 2) {
            if ((exp[i] != '1') && (exp[i] != '0')) {
                return false;
            }
        }

        for (int i = 1; i < exp.length; i += 2) {
            if ((exp[i] != '&') && (exp[i] != '|') && (exp[i] != '^')) {
                return false;
            }
        }

        return true;
    }

    public static int num1(String express, boolean desired) {
        if (express == null || express.equals("")) {
            return 0;
        }
        char[] exp = express.toCharArray();
        if (!isValid(exp)) {
            return 0;
        }
        return process(exp, desired, 0, exp.length - 1);
    }

    public static int process(char[] exp, boolean desired, int L, int R) {
        if (L == R) {
            if (exp[L] == '1') {
                return desired? 1 : 0;
            } else {
                return desired? 0 : 1;
            }
        }
        int res = 0;
        if (desired) {

            for (int i = L + 1; i < R; i += 2) {
                switch (exp[i]) {
                    case '&':
                        res += process(exp, true, L,i - 1) * process(exp, true, i + 1, R);
                        break;
                    case '|':
                        res += process(exp, true, L,i - 1) * process(exp, false, i + 1, R);
                        res += process(exp, false, L,i-1) * process(exp, true, i + 1, R);
                        res += process(exp, true, L,i - 1) * process(exp, true, i + 1, R);
                        break;
                    case '^':
                        res += process(exp, true, L,i - 1) * process(exp, false, i + 1, R);
                        res += process(exp, false, L,i - 1) * process(exp, true, i + 1, R);
                }
            }

        } else {

            for (int i = L + 1; i < R; i += 2) {
                switch (exp[i]) {
                    case  '&':
                        res += process(exp, true, L,i - 1) * process(exp, false, i + 1, R);
                        res += process(exp, false, L,i - 1) * process(exp, true, i + 1, R);
                        res += process(exp, false, L,i - 1) * process(exp, false, i + 1, R);
                        break;
                    case '|':
                        res += process(exp, false, L, i - 1) * process(exp, false, i + 1, R);
                        break;
                    case '^':
                        res += process(exp, true, L, i - 1) * process(exp, true, i + 1, R);
                        res += process(exp, false, L, i - 1) * process(exp, false, i + 1, R);
                        break;
                }
            }

        }
        return res;
    }


    public static int dp(String express, boolean desired) {
        char[] exp = express.toCharArray();
        int N = exp.length;
        int[][] tMap = new int[N][N];
        int[][] fMap = new int[N][N];
        for (int i = 0; i < N; i += 2) {
            tMap[i][i] = exp[i] == '1'? 1 : 0;
            fMap[i][i] = exp[i] == '0'? 1 : 0;
        }
        for (int row = N - 3; row >= 0; row -= 2) {
            for (int col = row + 2; col < N; col += 2) {
                for (int i = row + 1; i < col; i += 2) {
                    switch (exp[i]) {
                        case '&':
                            tMap[row][col] += tMap[row][i - 1] * tMap[i + 1][col];
                            break;
                        case '|':
                            tMap[row][col] += tMap[row][i - 1] * fMap[i + 1][col];
                            tMap[row][col] += fMap[row][i - 1] * tMap[i + 1][col];
                            tMap[row][col] += tMap[row][i - 1] * tMap[i + 1][col];
                            break;
                        case '^':
                            tMap[row][col] += tMap[row][i - 1] * fMap[i + 1][col];
                            tMap[row][col] += fMap[row][i - 1] * tMap[i + 1][col];
                            break;
                    }
                    switch (exp[i]) {
                        case '&':
                            fMap[row][col] += tMap[row][i - 1] * fMap[i + 1][col];
                            fMap[row][col] += fMap[row][i - 1] * tMap[i + 1][col];
                            fMap[row][col] += fMap[row][i - 1] * fMap[i + 1][col];
                            break;
                        case '|':
                            fMap[row][col] += fMap[row][i - 1] * fMap[i + 1][col];
                            break;
                        case '^':
                            fMap[row][col] += tMap[row][i - 1] * tMap[i + 1][col];
                            fMap[row][col] += fMap[row][i - 1] * fMap[i + 1][col];
                            break;
                    }
                }
            }
        }
        return desired? tMap[0][N - 1]: fMap[0][N - 1];
    }


    public static void main(String[] args) {

        String express = "1^0&0|1&1^0&0^1|0|1&1";
        //String express = "1^0|0|1";
        boolean desired = true;
        System.out.println(num1(express, desired));
        System.out.println(dp(express, desired));


    }
}
