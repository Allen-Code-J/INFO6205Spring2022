package midterm.src;//Question4

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */
public class question4 {
    public static void main(String[] args) {

    }
}

class Solution4{
   public int[][] question4(int[][] intervals){
       Arrays.sort(intervals,(a,b) -> a[1] - b[1]);
       List<int[]> result = new ArrayList<>(); int j = 0; int i = 0;
       while(i<intervals.length){
           if(intervals[i+1][0] > intervals[i][1]){
                i++;
                result.add(new int[]{intervals[i][0], intervals[i][1]});
                j++;
           }else if(intervals[i+1][0] <= intervals[i][1]){
              if(intervals[i+1][0]<intervals[i][0]){
                  result.add(new int[]{intervals[i+1][0], intervals[i+1][1]});
                  j++;
              }else{
                  result.add(new int[]{intervals[i][0], intervals[i+1][1]});
                  j++;
              }
           }
       }
       //turn list into int[][]
       int[][] result2 = new int[j][2];
       for(int i = 0; i < j; i++){
           result2[i][0] = result.get(i)[0];
           result2[i][1] = result.get(i)[1];
       }
       return result2;
   }
}