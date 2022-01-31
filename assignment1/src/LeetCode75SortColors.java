

import java.util.Arrays;

public class LeetCode75SortColors {
    public static void main(String[] args) {
        int[] nums = {1,2,0,2,1,0,2,1};
        Solution75 solution75 = new Solution75();
        solution75.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
class Solution75 {
    public void sortColors(int[] nums) {
        //先找0，交换到最前边
        for(int i = 0, j = 0; i < nums.length; i++){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                //swap(nums, i, j);
                j++;
            }
        }
        //再找2，交换到最后边。注意交换的指针必须从最后一位开始！
        // 不能从开头开始，因为如果最后一位本身就是2，要判断的也是2的话，就会造成没有改变！
        for(int k = nums.length - 1, l = nums.length - 1; k >= 0; k--){
            if(nums[k] == 2){
                int temp = nums[k];
                nums[k] = nums[l];
                nums[l] = temp;
                //swap(nums, k, l);
                l--;
            }
        }

    }
//     public void swap (int[] arr, int i, int j){

//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
}
