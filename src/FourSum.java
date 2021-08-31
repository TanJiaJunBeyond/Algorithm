import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by TanJiaJun on 2021/9/1.
 * 18. 四数之和（4Sum）
 * 难度：中等
 *
 * @see <a href="https://leetcode-cn.com/problems/4sum/">4Sum</a>
 */
class FourSum {

    public static void main(String[] args) {
        int[] firstNums = {1, 0, -1, 0, -2, 2};
        int firstTarget = 0;
        System.out.println(fourSum(firstNums, firstTarget));

        int[] secondNums = {2, 2, 2, 2, 2};
        int secondTarget = 8;
        System.out.println(fourSum(secondNums, secondTarget));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0, length = nums.length; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    }
                }
            }
        }
        return result;
    }

}