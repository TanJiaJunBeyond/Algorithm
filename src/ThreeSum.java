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
        int[] firstNums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(firstNums));

        int[] secondNums = {};
        System.out.println(threeSum(secondNums));

        int[] thirdNums = {0};
        System.out.println(threeSum(thirdNums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0, length = nums.length; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

}