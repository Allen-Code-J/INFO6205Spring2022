package midterm;

import java.util.ArrayList;
import java.util.List;

/**
Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: ["2","4->49","51->74","76->99"]
Explanation: The ranges are:
[2,2] --> "2"
[4,49] --> "4->49"
[51,74] --> "51->74"
[76,99] --> "76->99"
 */


public class Question1 {
    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75}; int lower = 0, upper = 99;
        System.out.println(new Solution1().question1(nums,lower,upper));
    }
}

class Solution1{
    public List<String> question1(int[] nums, int lower, int upper){
        List<String> result = new ArrayList<>();
        //nums[0]
        if(nums[0]>lower){
            result.add(lower+"->"+nums[0]);
        }

        //nums[1]~nums[n-2]
        for(int i = 1; i <= nums.length - 2; i++){
            if(nums[i] - nums[i-1] > 1) result.add(nums[i - 1]+"->"+nums[i]);
        }
        //nums[n-1]
        int n = nums.length;
        if(nums[n-1] < upper) result.add(nums[n-1]+"->"+upper);

        return result;

    }
}
