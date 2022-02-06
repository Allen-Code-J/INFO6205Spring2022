class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);


        int bestSum = 100000;
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum - target) < Math.abs(bestSum - target)){
                    bestSum = sum;
                }
                if(sum > target){
                    while(left < right && nums[right] == nums[right-1]) right--;
                    right--;
                }
                else if(sum < target){
                    while(left < right && nums[left] == nums[left+1])left++;
                    left++;
                }else{
                    return target;
                }

            }
        }
        return bestSum;
    }
}