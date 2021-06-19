import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TanJiaJun on 2021/6/4.
 * 1. 两数之和（Two Sum）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/two-sum/">Two Sum</a>
 */
class TwoSum {

    public static void main(String[] args) {
        // 示例一
        System.out.println("示例一");

        int[] firstNumbers = {2, 7, 11, 15};
        int firstTarget = 9;
        System.out.println(Arrays.toString(hashTwoSum(firstNumbers, firstTarget)));

        System.out.print("\n");

        // 示例二
        System.out.println("示例二");

        int[] secondNumbers = {3, 2, 4};
        int secondTarget = 6;
        System.out.println(Arrays.toString(hashTwoSum(secondNumbers, secondTarget)));

        System.out.print("\n");

        // 示例三
        System.out.println("示例三");
        int[] thirdNumbers = {3, 3};
        int thirdTarget = 6;
        System.out.println(Arrays.toString(hashTwoSum(thirdNumbers, thirdTarget)));
    }

    /**
     * 方法一：枚举
     * 时间复杂度：O(N^2)，其中N是数组的元素数量
     * 空间复杂度：O(1)
     *
     * @param numbers int类型的数组
     * @param target  目标值
     * @return 结果
     */
    private static int[] twoSum(int[] numbers, int target) {
        for (int i = 0, length = numbers.length; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 方法二：哈希表
     * 时间复杂度：O(N)，其中N是数组的元素数量
     * 空间复杂度：O(N)，其中N是数组的元素数量
     *
     * @param numbers int类型的数组
     * @param target  目标值
     * @return 结果
     */
    private static int[] hashTwoSum(int[] numbers, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0, length = numbers.length; i < length; i++) {
            int other = target - numbers[i];
            if (hashMap.containsKey(other)) {
                return new int[]{hashMap.get(other), i};
            }
            hashMap.put(numbers[i], i);
        }
        return new int[0];
    }

}
