package class08;

import java.util.ArrayList;
import java.util.List;

public class Problem02_PrintAllSubsequences {


    public static void printAllSubsequences(String str) {

        char[] chs = str.toCharArray();
        process(chs, 0);

    }

    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        char tmp = chs[i];
        process(chs, i + 1);
        chs[i] = 0;
        process(chs, i + 1);
        chs[i] = tmp;
    }

    public static List<String> getAllSubs(String s){
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process(str, 0, ans, path);
        return ans;
    }

    public static void process(char[] str, int index,
                               List<String> ans, String path) {
        if(index == str.length) {
            ans.add(path);
            return;
        }
        String noPath = path;
        process(str, index+1,ans, noPath);
        String yesPath = path + String.valueOf(str[index]);
        process(str, index+1,ans, yesPath);
    }


    public static void main(String[] args) {
        String test = "abc";
        printAllSubsequences(test);

        List<String> ans = getAllSubs(test);


        for(String str : ans) {
            System.out.println(str);
        }

    }

}
