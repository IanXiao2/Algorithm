package class08;

public class Problem06_RemoveDuplicateLettersLessLexi {

    /**
     * 给定一个全是小写字母的字符串str，删除多余字符，使得每种字符只保留一个，并让 最终结果字符串的字典序最小
     */

    public static String removeDuplicateLettersLessLexi(String str) {

        if (str == null || str.length() < 1) {
            return str;
        }
        int[] map = new int[256];

        for (int i = 0; i < str.length(); i++) {
            map[str.charAt(i)]++;
        }
        int minACSINdex = 0;
        for (int i = 0; i < str.length(); i++) {

            minACSINdex = str.charAt(i) < str.charAt(minACSINdex)? i:minACSINdex;

            if (-- map[str.charAt(i)] == 0) {
                break;
            }
        }

        return String.valueOf(str.charAt(minACSINdex) +
                            removeDuplicateLettersLessLexi(
                                    str
                                    .substring(minACSINdex+1)
                                    .replaceAll(String.valueOf(str.charAt(minACSINdex)), "")
                            ));
    }

    public static void main(String[] args) {
        String str = "bbfceabcef";
        System.out.println(removeDuplicateLettersLessLexi(str));
    }
}
