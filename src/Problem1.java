import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 */
public class Problem1 {

    public static void main(String[] args) {
        System.out.println(solution2(new int[]{10, 15, 3, 7}, 17)); //true
        System.out.println(solution2(new int[]{10, 15, 3, 7}, 1700)); //false
    }

    private static boolean solution(int[] arr, int k) { // O(n2)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean solution2(int[] arr, int k) { // O(n) + extra memory
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i]))
                return true;
            set.add(k - arr[i]);
        }
        return false;
    }
}
