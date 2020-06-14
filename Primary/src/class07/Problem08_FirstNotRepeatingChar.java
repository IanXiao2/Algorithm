package class07;

public class Problem08_FirstNotRepeatingChar {

    //在一个字符串中找到第一个只出现一次的字符


    public static int firstNotRepeatingChar(String str) {
        int res = -1;
        if (str == null || str.length() < 1) {
            return res;
        }
        int[] map = new int[128];
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            map[chs[i]]++;
        }

        for (int i = 0; i <chs.length; i++) {
            if (map[chs[i]] == 1) {
                return i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "google";
        System.out.println(firstNotRepeatingChar(str));

    }
}
