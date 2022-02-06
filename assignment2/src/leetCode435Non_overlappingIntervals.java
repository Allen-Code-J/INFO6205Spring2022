class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2) {
            return 0;
        }


        Arrays.sort(intervals, (interval1, interval2) -> {
            if (interval1[0] == interval2[0]) {
                return Integer.compare(interval1[1], interval2[1]);
            }

            return Integer.compare(interval1[0], interval2[0]);
        });

        return eraseOverlapIntervals(intervals, 0, 1);
    }

    private int eraseOverlapIntervals(int[][] intervals, int pid, int id) {
        if (id >= intervals.length) {
            return 0;
        }

        if (intervals[pid][1] <= intervals[id][0]) {
            return eraseOverlapIntervals(intervals, id, id + 1);
        }

        if (intervals[pid][1] >= intervals[id][1]) {
            return eraseOverlapIntervals(intervals, id, id + 1) + 1;
        }


        return eraseOverlapIntervals(intervals, pid, id + 1) + 1;
    }
}

