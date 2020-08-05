package class08;

import java.util.*;

public class Problem07_WordMinPaths {
    /*
    给定两个字符串，记为start和to，再给定一个字符串列表list，list中一定包含to list中没有重复字符串，所有的字符串都是小写的。
    规定: start每次只能改变一个字符，最终的目标是彻底变成to，但是每次变成的新字符串必须在list 中存在。
    请返回所有最短的变换路径。
    */
    public static List<List<String>> findMinPaths(String start, String to, List<String> words) {
        words.add(start);
        HashMap<String, ArrayList<String>> nexts = new HashMap<>();
        nexts = getNexts(words);
        HashMap<String, Integer> dist = getDistances(nexts, start);
        LinkedList<String> path = new LinkedList<>();
        List<List<String>> res = new ArrayList<>();
        getShortestPaths(start, to, nexts, dist, path, res);
        return res;
    }

    // 获取邻接表
    public static HashMap<String, ArrayList<String>> getNexts(List<String> words) {
        Set<String> dict = new HashSet<>(words);
        HashMap<String, ArrayList<String>> nexts = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            nexts.put(words.get(i), getNext(words.get(i), dict));
        }
        return nexts;
    }
    public static ArrayList<String> getNext(String word, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char[] chs = word.toCharArray();
        for (char cur = 'a'; cur <= 'z'; cur++) {
            for (int i = 0;i < chs.length; i++) {
                if(chs[i] != cur) {
                    char tmp = chs[i];
                    chs[i] = cur;
                    if (dict.contains(String.valueOf(chs))) {
                        res.add(String.valueOf(chs));
                    }
                    chs[i] = tmp;
                }
            }
        }
        return res;
    }

    // bfs，获取list中每个字符串到start的最短距离
    public static HashMap<String, Integer> getDistances(HashMap<String, ArrayList<String>> nexts, String start) {
        HashMap<String, Integer> dist = new HashMap<>();
        dist.put(start, 0);
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        HashSet<String> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for(String next: nexts.get(cur)) {
                if (!visited.contains(next)) {

                    dist.put(next, dist.get(cur) + 1);

                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return dist;
    }

    // dfs，获取to到start的最短路径
    public static void getShortestPaths(String cur, String to,
                                        HashMap<String, ArrayList<String>> nexts,
                                        HashMap<String, Integer> dist,
                                        LinkedList<String> path,
                                        List<List<String>> res) {
        path.add(cur);
        if (to.equals(cur)) {
            res.add(new ArrayList<>(path));
        } else {
            for (String next:nexts.get(cur)) {
                if (dist.get(next) == dist.get(cur) + 1) {
                    getShortestPaths(next, to, nexts, dist, path, res);
                }
            }
        }
        path.pollLast();
    }


    public static void main(String[] args) {

        String start = "abc";
        String end = "cab";
        String[] test = { "abc", "cab", "acc", "cbc", "ccc", "cac", "cbb",
                "aab", "abb" };
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < test.length; i++) {
            list.add(test[i]);
        }
        List<List<String>> res = findMinPaths(start, end, list);
        for (List<String> obj : res) {
            for (String str : obj) {
                System.out.print(str + " -> ");
            }
            System.out.println();
        }

    }
}
