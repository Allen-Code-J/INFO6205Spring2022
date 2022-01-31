import java.util.*;

public class leetCode692TopKFrequentWords {
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        List<String> ans = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>((x1, x2) -> x2.getValue() - x1.getValue() != 0 ? x2.getValue() - x1.getValue() : x1.getKey().compareTo(x2.getKey()));
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            pq.offer(e);
        }

        int index = 0;
        while (index < k) {
            index++;
            ans.add(pq.poll().getKey());
        }
        return ans;
    }
}

