import java.util.Arrays;

/**
 * Created by TanJiaJun on 2021/7/30.
 * 15. 最接近的三数之和（3Sum Closest）
 * 难度：中等
 *
 * @see <a href="https://leetcode-cn.com/problems/3sum-closest/">3Sum Closest</a>
 */
class ThreeSumClosest {

    public static void main(String[] args) {
        int[] firstNums = {-1, 2, 1, -4};
        int firstTarget = 1;
        System.out.println(threeSumClosest(firstNums, firstTarget));
    }

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int right = length - 1;
        int result = nums[0] + nums[1] + nums[right];
        for (int i = 0; i < length; i++) {
            int left = i + 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    result = sum;
                    break;
                }
            }
        }
        return result;
    }

}