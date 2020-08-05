package class07;

import java.util.*;

public class Problem06_MaxRevenue {

    // 能获得的最大奖励，以及需要的最少时长

    // 请保证只有唯一的最后节点, 没有环
    // dependents[i][j] == 0 认为i项目和j项目没关系，不直接相连
    // dependents[i][j] == 1 认为j项目是i项目的其中一个后续
    public static int[] maxRevenue(int allTime, int[] revenues, int[] times, int[][] dependents) {

        int size = revenues.length;
        HashMap<Integer, ArrayList<Integer>> parents = new HashMap<>();
        for (int i = 0; i < dependents.length; i++) {
            parents.put(i, new ArrayList<>());
        }
        int end = -1;
        for (int i = 0; i < dependents.length; i++) {
            boolean allZero = true;
            for (int j = 0; j < dependents[0].length; j++) {
                if (dependents[i][j] != 0) {
                    allZero = false;
                    parents.get(j).add(i);
                }
            }
            if (allZero) {
                end = i;
            }
        }
        HashMap<Integer, TreeMap<Integer, Integer>> nodeCostRevenMap = new HashMap<>();
        for (int i = 0; i < dependents.length; i++) {
            nodeCostRevenMap.put(i, new TreeMap<>());
        }
        nodeCostRevenMap.get(end).put(times[end], revenues[end]);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(end);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Integer last:parents.get(cur)) {
                for (Map.Entry<Integer, Integer> entry:nodeCostRevenMap.get(cur).entrySet()) {
                    int lastCost = entry.getKey() + times[last];
                    int lastReven = entry.getValue() + revenues[last];
                    TreeMap<Integer, Integer> lastMap = nodeCostRevenMap.get(last);
                    if (lastMap.floorKey(lastCost) == null
                            || lastMap.get(lastMap.floorKey(lastCost)) < lastReven) {
                        lastMap.put(lastCost, lastReven);
                    }
                }
                queue.add(last);
            }
        }
        TreeMap<Integer, Integer> allMap = new TreeMap<>();
        for (TreeMap<Integer, Integer> curMap:nodeCostRevenMap.values()) {
            for (Map.Entry<Integer, Integer> entry:curMap.entrySet()) {
                int cost = entry.getKey();
                int reven = entry.getValue();
                if (allMap.floorKey(cost) == null||allMap.get(allMap.floorKey(cost)) < reven) {
                    allMap.put(cost, reven);
                }
            }
        }
        return new int[] {allMap.floorKey(allTime), allMap.get(allMap.floorKey(allTime))};

    }


    public static void main(String[] args) {

        int allTime = 10;
        int[] revenues = { 2000, 4000, 2500, 1600, 3800, 2600, 4000, 3500 };
        int[] times = { 3, 3, 2, 1, 4, 2, 4, 3 };
        int[][] dependents = {
                { 0, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0 } };


        int[] res = maxRevenue(allTime, revenues, times, dependents);
        System.out.println(res[0] + " , " + res[1]);

    }
}
