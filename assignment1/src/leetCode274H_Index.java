import java.util.Arrays;

class Solution274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int i = citations.length - 1;
        while ( i >= 0 && citations[i] > h ) {
            i = i - 1;
            h = h + 1;
        }
        return h;
    }
}

