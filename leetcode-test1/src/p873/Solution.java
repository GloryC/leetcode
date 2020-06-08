package p873;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/4 17:09
 */
public class Solution {

    public int lenLongestFibSubseq(int[] A) {
        //从i开始，下一个是j
        int max = 2;
        for(int i = 0; i < A.length; i++){
            for(int j = i + 1; j < A.length; j++){
                int tmpI = A[i];
                int tmpJ = A[j];
                int sum = tmpI + tmpJ;
                int cur = 2;
                //存在
                while(Arrays.binarySearch(A, sum) >= 0){
                    tmpI = tmpJ;
                    tmpJ = sum;
                    sum = tmpI + tmpJ;
                    cur++;
                }
                max = Math.max(max, cur);
            }
        }
        return max < 3 ? 0 : max;
    }

}
