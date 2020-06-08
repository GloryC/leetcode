package p836;

/**
 * @author Glory
 * @date 2020/3/18 1:04
 */
public class Solution {

    /**
     * 来打卡啦~矩形如果不重叠，在x轴和y轴上看，中间两条线段肯定是不相交的，
     * 也就是说左边的矩形的最右边小于右边矩形的最左边。或镜像，左右矩形位置相反
     * 也就是rec1[2] < rec2[0] || rec2[2] < rec1[0]；y轴同理由，
     * 下面的矩形的最上边小于上面矩形的最下边，
     * 也就是rec1[3] < rec2[1] || rec2[3] < rec1[1]。
     * 因为题目要求重叠算相离，所以加上=，最后取反就行啦~
     *
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // 上下的情况
        if(rec2[1] >= rec1[3] || rec1[1] >= rec2[3]){
            return false;
        }
        // 左右的情况
        if(rec1[0] >= rec2[2] || rec1[2] <= rec2[0]){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] data1 = {0, 0, 2, 2};
        int[] data2 = {1, 1, 3, 3};
        Solution solution = new Solution();
        System.out.println(solution.isRectangleOverlap(data1, data2));
    }

}
