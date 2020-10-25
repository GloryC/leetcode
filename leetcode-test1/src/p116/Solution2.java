package p116;

/**
 * @author Glory
 * @date 2020/3/17 0:29
 */
public class Solution2 {

    public int countCharacters(String[] words, String chars) {
        int[] charData = new int[30];
        char[] ch = chars.toCharArray();
        for (char c : ch) {
            charData[c - 97]++;
        }
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            char[] charWords = words[i].toCharArray();
            int[] charData2 = new int[30];
            for (char c : charWords) {
                charData2[c - 97]++;
            }
            boolean flag = true;
            for (int j = 0; j < charWords.length; j++) {
                if (charData[charWords[j] - 97] < charData2[charWords[j] - 97]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count += charWords.length;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words = {"hello", "world", "leetcode"};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.countCharacters(words, "welldonehoneyr"));
    }

}
