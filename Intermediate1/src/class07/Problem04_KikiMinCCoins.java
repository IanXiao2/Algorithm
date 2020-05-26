package class07;

public class Problem04_KikiMinCCoins {


    public static int minCCoins1(int add, int times, int del, int cur, int aim) {
        if (cur > aim) {
            return -1;
        }

        //((aim-cur)/2) * add 平凡解

        return process(0, aim, add, times, del, cur, aim*2, ((aim-cur)/2) * add);
    }


    // preMoney 之前花了多少币     可变
    // aim 目标     可变
    // add, times, del     固定
    // cur 当前来到的人气
    // limitAim 人气大到什么程度不需要再尝试了   固定
    // limitCoin 已经使用的币大到什么程度不需要再尝试了   固定
    // 返回最小币数
    public static int process(int preMoney, int aim, int add, int times, int del, int cur,
                              int limitAim, int limitCoin) {

        if (preMoney > limitCoin) {
            return Integer.MAX_VALUE;
        }
        if (cur < 0) {
            return Integer.MAX_VALUE;
        }
        if (cur > limitAim) {
            return Integer.MAX_VALUE;
        }
        if (cur == aim) {
            return preMoney;
        }
        int min = Integer.MAX_VALUE;
        //让人气+2的方式
        int p1 = process(preMoney+add, aim, add, times, del, cur+2, limitAim, limitCoin);
        if (p1 != Integer.MAX_VALUE) {
            min = p1;
        }
        //让人气*2的方式
        int p2 = process(preMoney+times, aim, add, times, del, cur*2, limitAim, limitCoin);
        if (p2 != Integer.MAX_VALUE) {
            min = Math.min(min, p2);
        }

        //让人气-2的方式
        int p3 = process(preMoney+del, aim, add, times, del, cur-2, limitAim, limitCoin);
        if (p3 != Integer.MAX_VALUE) {
            min = Math.min(min, p3);
        }
        return min;
    }

    public static int minCCoins2(int add, int times, int del, int cur, int end) {
        if (cur > end) {
            return -1;
        }
        int limitCoin = ((end - cur)/2) * add;
        int limitAim = end*2;
        int[][] dp = new int[limitCoin + 1][limitAim + 1];
        for (int pre = 0; pre <= limitCoin; pre++) {
            for (int aim = 0; aim <= limitAim; aim++) {
                if (aim == cur) {
                    dp[pre][aim] = pre;
                } else {
                    dp[pre][aim] = Integer.MAX_VALUE;
                }
            }
        }

        for (int pre = limitCoin; pre >= 0; pre--) {
            for (int aim = 0; aim <= limitAim; aim++) {
                if (aim - 2 >= 0 && pre + add <= limitCoin) {
                    dp[pre][aim] = Math.min(dp[pre][aim], dp[pre + add][aim - 2]);
                }
                if (aim + 2 <= limitAim && pre + del <= limitCoin) {
                    dp[pre][aim] = Math.min(dp[pre][aim], dp[pre + del][aim + 2]);
                }
                if ((aim & 1) == 0) {
                    if (aim /2 >=0 && pre + times <= limitCoin) {
                        dp[pre][aim] = Math.min(dp[pre][aim], dp[pre + times][aim / 2]);
                    }
                }
            }
        }
        return dp[0][end];
    }


    public static void main(String[] args) {

        int add = 6;
        int times = 5;
        int del = 1;
        int start = 10;
        int end = 30;
        System.out.println(minCCoins1(add, times, del, start, end));
        System.out.println(minCCoins2(add, times, del, start, end));

    }
}
