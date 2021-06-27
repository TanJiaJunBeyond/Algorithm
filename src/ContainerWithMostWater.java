/**
 * Created by TanJiaJun on 2021/6/20.
 * 11. 盛最多水的容器（Container With Most Water）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/container-with-most-water/">Container With Most Water</a>
 */
class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] firstHeight = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(firstHeight));

        int[] secondHeight = {1, 1};
        System.out.println(maxArea(secondHeight));

        int[] thirdHeight = {4, 3, 2, 1, 4};
        System.out.println(maxArea(thirdHeight));

        int[] fourthHeight = {1, 2, 1};
        System.out.println(maxArea(fourthHeight));
    }

    private static int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int result = 0;
        while (left != right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            result = Math.max(result, width * height);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}