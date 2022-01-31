import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetCode1636SortArrayByIncreasingFrequency {
}

/*
【排序】

*/
class Solution1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        int n = nums.length;
        int[][] data = new int[hashMap.size()][2];
        int i = 0;
        for (int key : hashMap.keySet()) data[i++] = new int[]{key, hashMap.get(key)};
        Arrays.sort(data, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });
        i = 0;
        for (int[] d : data) {
            for (int j = 0; j < d[1]; j++) nums[i++] = d[0];
        }
        return nums;
    }
}

