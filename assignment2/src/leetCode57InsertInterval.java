class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int length = intervals.length;
        int min = newInterval[0];
        int max = newInterval[1];


        int i = 0;
        int j = length - 1;

        for(; i < length; i++) {

            if(min <= intervals[i][1]) {

                min = Math.min(min, intervals[i][0]);
                break;
            }
        }

        for(; j >= 0; j--) {

            if(max >= intervals[j][0]) {

                max = Math.max(max, intervals[j][1]);
                break;
            }
        }
        int[][] result = new int[i + (length - 1 - j) + 1][2];
        int k = 0;

        for(; k < i; k++) {
            result[k] = intervals[k];
        }

        result[k++] = new int[]{min, max};

        for(; k < length + i - j; k++) {
            result[k] = intervals[k - i + j];
        }

        return result;
    }
}

