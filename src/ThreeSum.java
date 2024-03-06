import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by TanJiaJun on 2021/7/25.
 * 15. 三数之和（3Sum）
 * 难度：中等
 *
 * @see <a href="https://leetcode-cn.com/problems/3sum/">3Sum</a>
 */
class ThreeSum {

    public static void main(String[] args) {
        // 示例一
        System.out.print("示例一：");

        int[] firstNums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(firstNums));

        System.out.print("\n");

        // 示例二
        System.out.print("示例二：");

        int[] secondNums = {};
        System.out.println(threeSum(secondNums));

        System.out.print("\n");

        // 示例三
        System.out.print("示例三：");

        int[] thirdNums = {0};
        System.out.println(threeSum(thirdNums));
    }

    /**
     * 双指针
     * <p>
     * 时间复杂度：O(n^2)，数组遍历为O(n)，双指针遍历为O(n)，总体为O(n)*O(n)=O(n^2)
     * 空间复杂度：O(1)，使用的空间复杂度为常数。
     *
     * @param nums 整型数组
     * @return 结果集合
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            // 如果数组为空或者其长度小于3，就返回空集合
            return result;
        }
        // 将数组进行排序
        Arrays.sort(nums);
        for (int i = 0, length = nums.length; i < length - 2; i++) {
            if (nums[i] > 0) {
                // 如果当前起始元素大于0，由于数组已经进行排序，所以最小的元素都大于0，
                // 证明三数之和肯定大于0，跳出循环，返回空集合
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 去除重复结果：从第二个元素开始，如果当前元素和上一个元素相等，那么会得到相同的结果，跳出当前循环
                continue;
            }
            // 左指针：初始左指针为当前索引的下一个元素
            int left = i + 1;
            // 右指针：初始右指针为数组的最后一个元素
            int right = length - 1;
            // 遍历，使左右指针靠近
            while (left < right) {
                // 将当前元素、左指针对应的元素和右指针对应的元素相加
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    // 如果结果小于0，证明需要更大的元素，左指针往右移动一个元素
                    left++;
                } else if (sum > 0) {
                    // 如果结果大于0，证明需要更小的元素，右指针往左移动一个元素
                    right--;
                } else {
                    // 如果等于0，就把结果放进集合
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        // 去除重复结果：如果当前左指针对应的元素和下一个（右边）元素相等，就把左指针往右边移动多一个元素
                        left++;
                    }
                    // 左指针往右边移动一个元素
                    left++;
                    while (left < right && nums[right] == nums[right - 1]) {
                        // 去除重复结果：如果当前右指针对应的元素和下一个（左边）元素相等，就把右指针往左边移动多一个元素
                        right--;
                    }
                    // 右指针往左边移动一个元素
                    right--;
                }
            }
        }
        return result;
    }

}