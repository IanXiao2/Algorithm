package class06;

import java.util.HashMap;
import java.util.HashSet;

public class Problem04_PreInArrToPostArr {

    public static int[] getPostArr (int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        int N = pre.length;
        int[] pos = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        process(pre, in, pos, map, 0, N-1, 0, N-1, 0, N-1);
        return pos;
    }

    public static void process(int[] pre, int[] in, int[] pos, HashMap<Integer, Integer> map,
                               int prei, int prej, int ini, int inj, int posi, int posj) {
        if (prej < prei) {
            return;
        }
        if (prei == prej) {
            pos[posj] = pre[prei];
            return;
        }
        pos[posj] = pre[prei];
        int find = map.get(pre[prei]);
        process(pre, in, pos, map, prei + 1, prei+ find - ini,
                ini, find - 1, posi, posi + find - ini - 1);
        process(pre, in, pos, map, prei + find - ini + 1, prej,
                find + 1, inj, posi + find -ini, posj - 1);

    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int[] pre = { 1, 2, 4, 5, 3, 6, 7 };
        int[] in = { 4, 2, 5, 1, 6, 3, 7 };
        int[] pos = getPostArr(pre, in);
        printArr(pos);

    }
}
