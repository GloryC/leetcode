package p1095;

/**
 * @author Glory
 * @date 2020/4/29 14:54
 */
public class Solution {

    /**
     * 使用二分查找
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();

        int peakIndex = findMountainTop(mountainArr, 0, len - 1);
        if (mountainArr.get(peakIndex) == target) return peakIndex;

        int res = findSortedArray(mountainArr, 0, peakIndex - 1, target);
        if (res != -1) return res;

        return findReverseArray(mountainArr, peakIndex + 1, len - 1, target);
    }

    private int findReverseArray(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            // 防止left+right发生整型溢出
            int mid = left + (right - left + 1) / 2;
            if (mountainArr.get(mid) < target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (mountainArr.get(left) == target) return left;
        else return -1;
    }

    private int findSortedArray(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            // 防止left+right发生整型溢出
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (mountainArr.get(left) == target) return left;
        else return -1;
    }

    private int findMountainTop(MountainArray mountainArr, int left, int right) {
        while (left < right) {
            // 防止left+right发生整型溢出
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
