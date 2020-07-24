package class08;

public class Problem04_LongestNoRepeatSubstring {

    // 在一个字符串中找到没有重复字符子串中最长的长度
    public static int longestNoRepeatSubstrLen(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        int[] map = new int[256];
        char[] chs = str.toCharArray();
        for (int i=0; i < chs.length; i++) {
            map[chs[i]] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i < chs.length; i++) {
            pre = Math.max(pre, map[chs[i]]);
            cur = i - pre;
            len = Math.max(cur, len);
            map[chs[i]] = i;
        }
        return len;
    }

    public static String longestNoRepeatSubstr(String str) {
        if (str == null || str.length() < 1) {
            return str;
        }
        int[] map = new int[256];
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            map[chs[i]] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur = 0;
        int end = 0;
        for (int i = 0; i < chs.length; i++) {
            pre = Math.max(pre, map[chs[i]]);
            cur = i - pre;
            if (cur > len) {
                len = cur;
                end = i;
            }
            map[chs[i]] = i;
        }
        return str.substring(end - len + 1, end + 1);
    }

    public static String getRandomString(int len) {
        char[] str = new char[len];
        int base = 'a';
        int range = 'z' - 'a' + 1;
        for (int i = 0; i < len; i++) {
            str[i] = (char)((int)(Math.random() * range) + base);
        }
        return String.valueOf(str);
    }

    public static void main(String[] args) {

        String str = getRandomString(20);
        System.out.println(str);
        System.out.println(longestNoRepeatSubstr(str));
        System.out.println(longestNoRepeatSubstrLen(str));
    }
}
