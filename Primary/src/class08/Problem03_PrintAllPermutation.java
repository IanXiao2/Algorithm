package class08;

import java.util.ArrayList;

public class Problem03_PrintAllPermutation {



    public static ArrayList<String> getAllPermutation(String str) {
        ArrayList<String> ans = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return ans;
        }
        char[] chs = str.toCharArray();
        process(chs, 0, ans);
        ans.sort(null);
        return ans;
    }

    public static void process(char[] chs, int i, ArrayList<String> ans) {
        if (i == chs.length) {
            ans.add(String.valueOf(chs));
            return;
        }
        for (int j = i; j < chs.length; j++) {
            swap(chs, i, j);
            process(chs, i + 1, ans);
            swap(chs, i, j);
        }

    }

    public static ArrayList<String> getAllPermutation2(String str) {
        ArrayList<String> ans = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return ans;
        }
        char[] chs = str.toCharArray();
        processNotRepeat(chs, 0 ,ans);
        return ans;
    }

    public static void processNotRepeat(char[] chs, int i, ArrayList<String> ans) {
        if (i == chs.length) {
            ans.add(String.valueOf(chs));
            return;
        }
        boolean[] visited = new boolean[26];
        for (int j = i; j < chs.length; j++) {
            if (!visited[chs[j] - 'a']) {
                visited[chs[j] - 'a'] = true;
                swap(chs, i, j);
                processNotRepeat(chs, i + 1, ans);
                swap(chs, i, j);
            }
        }
    }


    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {

        String test = "abbc";
        ArrayList<String> ans = getAllPermutation(test);

        for(String str: ans) {
            System.out.println(str);
        }
        System.out.println(ans.size());
        System.out.println("-----------");

        ans = getAllPermutation2(test);

        for(String str: ans) {
            System.out.println(str);
        }

        System.out.println(ans.size());
        System.out.println("-----------");

    }
}
