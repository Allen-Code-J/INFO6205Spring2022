import java.util.ArrayList;
import java.util.List;

public class leetCode229MajorityElement2 {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        Solution229 solution229 = new Solution229();
        System.out.println(solution229.majorityElement(nums));
    }
}
class Solution229 {
    int candidate1;
    int candidate2;
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        //一定先投票，再配对。
        for(int i = 0; i < nums.length; i++){
            if(candidate1 == nums[i] && count1 > 0){
                count1++;
            }
            else if(candidate2 == nums[i] && count2 > 0){
                count2++;
            }
            else if(count1 == 0){
                candidate1 = nums[i];
                count1++;
            }
            else if(count2 == 0){
                candidate2 = nums[i];
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        List<Integer> result = new ArrayList<>();
        count1 = 0; count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(candidate1 == nums[i]) count1++;
            if(candidate2 == nums[i]) count2++;
        }
        if(count1 > nums.length/3 ) result.add(candidate1);
        if(count2 > nums.length/3 && candidate1 != candidate2) result.add(candidate2);

        return result;

    }
}
