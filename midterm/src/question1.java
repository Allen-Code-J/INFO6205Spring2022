package midterm.src;//package midterm;

//Question1

import java.util.ArrayList;
import java.util.List;

/**
 * Example 1:
 * Input: nums = [0,1,3,50,75], lower = 0, upper = 99
 * Output: ["2","4->49","51->74","76->99"]
 * Explanation: The ranges are:
 * [2,2] --> "2"
 * [4,49] --> "4->49"
 * [51,74] --> "51->74"
 * [76,99] --> "76->99"
 *
 * Example 2:
 * Input: nums = [-1], lower = -1, upper = -1
 * Output: []
 * Explanation: There are no missing ranges since there are no missing numbers.
 */


public class question1 {
    public static void main(String[] args) {
        int[] nums = {0, 1};
        int lower = 0, upper = 99;
        System.out.println(new Solution1().question1(nums, lower, upper));
        int[] nums2 = {-1};
        int lower2 = -1, upper2 = -1;
        System.out.println(new Solution1().question1(nums2, lower2, upper2));
    }
}

class Solution1 {
    public List<String> question1(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return result;
        if (n == 1 && lower == nums[n - 1] && upper == nums[n - 1]) return result;
        if (n == 1 && (lower < nums[n - 1] || upper > nums[n - 1])){
            if(nums[n-1] - lower != 1) result.add(lower+1+"->"+(nums[n-1]-1));
            if(upper-nums[n-1] != 1) result.add(nums[n-1]+1+"->"+(upper-1));
        }

        if (n > 1) {

            //nums[0]
            if (nums[0] > lower) {
                result.add(lower + "->" + nums[0]);
            }

            //nums[1]~nums[n-2]
            for (int i = 1; i <= nums.length - 2; i++) {
                if (nums[i] - nums[i - 1] > 2) result.add(nums[i - 1] + 1 + "->" + (nums[i] - 1));
                else if (nums[i] - nums[i - 1] == 2) result.add(nums[i - 1] + 1 + "");
            }
            //nums[n-1]int n = nums.length;
            result.add((nums[n - 2] + 1) + "->" + (nums[n - 1] - 1));
            if (nums[n - 1] < upper) result.add(nums[n - 1] + 1 + "->" + upper);
        }


        return result;

    }
}

