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
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(hashTwoSum(numbers, target)));
    }

    /**
     * 方法一：枚举算法
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
