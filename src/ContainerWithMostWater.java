/**
 * Created by TanJiaJun on 2021/6/20.
 * 11. 盛最多水的容器（Container With Most Water）
 * 难度：简单
 *
 * @see <a href="https://leetcode-cn.com/problems/container-with-most-water/">Container With Most Water</a>
 */
class ContainerWithMostWater {

    public static void main(String[] args) {
        // 示例一
        System.out.print("示例一：");

        int[] firstHeights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(firstHeights));

        System.out.print("\n");

        // 示例二
        System.out.print("示例二：");

        int[] secondHeights = {1, 1};
        System.out.println(maxArea(secondHeights));

        System.out.print("\n");

        // 示例三
        System.out.print("示例三：");

        int[] thirdHeights = {4, 3, 2, 1, 4};
        System.out.println(maxArea(thirdHeights));

        System.out.print("\n");

        // 示例四
        System.out.print("示例四：");

        int[] fourthHeights = {1, 2, 1};
        System.out.println(maxArea(fourthHeights));
    }

    /**
     * 双指针
     * 时间复杂度：O(N)，其中N是数组heights的大小
     * 空间复杂度：O(1)
     *
     * @param heights 高度数组
     * @return 最大容量
     */
    private static int maxArea(int[] heights) {
        // 将左指针放置在数组的第一个元素
        int left = 0;
        // 将右指针放置在数组的最后一个元素
        int right = heights.length - 1;
        int result = 0;
        // 循环遍历直至左右指针到达同一个位置
        while (left != right) {
            // 宽度的值可以通过右指针的索引减去左指针的索引得到
            int width = right - left;
            // 根据题义可知，要想得到最大的盛水面积，高度就需要取左指针和右指针所在元素的最小值
            int height = Math.min(heights[left], heights[right]);
            // 取最大的面积
            result = Math.max(result, width * height);
            if (heights[left] < heights[right]) {
                // 如果左指针对应的元素小于右指针对应的元素，就将左指针向右移动一格
                left++;
            } else {
                // 如果左指针对应的元素大于右指针对应的元素，就将右指针向左移动一格
                right--;
            }
        }
        return result;
    }
}