import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jxiao on 2015/11/2.
 * 
 * dfs 求全排列，时间复杂度 O(n!)
 */
public class Permutation {

    public static void perm(String s, List<Character> chars) {
        if (chars.size() == 1) {
            System.out.println(s + chars.get(0));
            return;
        }

        for (int i = 0; i < chars.size(); i++) {
            List<Character> newChars = new LinkedList<>(chars);
            Character c = newChars.remove(i);
            perm(s + c, newChars);
        }
    }

    public static void main(String[] args) {
        List<Character> chars = new LinkedList<Character>(Arrays.asList('a', 'b', 'c', 'd'));
        perm("", chars);
    }
}
