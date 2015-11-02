import java.util.Arrays;
import java.util.List;

/**
 * Created by jxiao on 2015/11/2.
 */
public class Group {

    public static void group(List<Character> chars) {
        int max = 1 << chars.size();
        for (int i = 1; i < max; i++) {
            int k = i;
            for (int j = 0; j < chars.size(); j++) {
                if (k % 2 == 1)
                    System.out.print(chars.get(j));
                k /= 2;
            }
            System.out.print('\n');
        }
    }

    public static void main(String[] args) {
        List<Character> chars = Arrays.asList('a', 'b', 'c', 'd');
        group(chars);
    }
}
