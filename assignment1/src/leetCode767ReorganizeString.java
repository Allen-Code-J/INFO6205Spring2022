import java.util.PriorityQueue;

public class leetCode767ReorganizeString {
}

class Solution767 {
    public String reorganizeString(String S) {
        PriorityQueue<int[]> Pq;
        int i;
        int[] hashmap;
        int[] next;
        int[] last;
        StringBuilder result;


        result = new StringBuilder();
        Pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        hashmap = new int[26];
        for (i = 0; i < S.length(); i++) {
            hashmap[S.charAt(i) - 'a']++;
        }

        for (i = 0; i < 26; i++) {
            if (hashmap[i] > 0)
                Pq.add(new int[]{i, hashmap[i]});
        }
        next = Pq.remove();
        result.append((char) (next[0] + 'a'));
        next[1]--;
        while (Pq.isEmpty() == false) {
            last = next;
            next = Pq.remove();
            result.append((char) (next[0] + 'a'));
            next[1]--;
            if (last[1] > 0)
                Pq.add(last);
        }
        if (result.length() == S.length())
            return result.toString();
        return "";
    }
}

