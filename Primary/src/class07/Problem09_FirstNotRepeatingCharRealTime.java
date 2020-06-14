package class07;

import java.util.LinkedList;
import java.util.Queue;

public class Problem09_FirstNotRepeatingCharRealTime {

    //找出字符流中第一个只出现一次的字符

    //Insert one char from stringstream
    static int[] charCnt = new int[256];
    static Queue<Character> queue = new LinkedList<>();
    public static void Insert(char ch)
    {
        if (charCnt[ch]++ == 0) {
            queue.add(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        while (!queue.isEmpty()) {
            char ch = queue.peek();
            if (charCnt[ch] == 1) {
                return ch;
            } else {
                queue.poll();
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        Insert('g');
        Insert('o');
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('g');
        System.out.println(FirstAppearingOnce());
        Insert('l');
        Insert('e');
        System.out.println(FirstAppearingOnce());
    }
}
