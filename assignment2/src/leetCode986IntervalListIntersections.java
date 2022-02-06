class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            int left = Math.max(A[i][0], B[j][0]);
            int right = Math.min(A[i][1], B[j][1]);
            if (left <= right) {
                res.add(new int[] {left, right});
            }
            if (A[i][1] < B[j][1]) {
                i++;
            } else if (A[i][1] > B[j][1]){
                j++;
            }else{
                j++;
                i++;
            }
        }
        return res.toArray(new int[0][0]);
    }
}