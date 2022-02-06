class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //哈希表存储数字和出现的频率
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //最小堆，堆顶放置最少出现的数。这里compareTo（）是当两个数字出现频率相同的情况下，比较两个数字值的大小，当然这道题比不比较问题都不大
        PriorityQueue<Integer> queue = new PriorityQueue<>((v1, v2) -> map.get(v1).equals(map.get(v2)) ? v2.compareTo(v1) : map.get(v1) - map.get(v2));

        //根据出现的数字，选取其中出现最多的k个数字
        for(int num: map.keySet())  {
            queue.offer(num);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            list.add(queue.poll());
        }
        //这里反转数字是因为k个数字的出现频率是从小到大，翻过来为从大到小，当然这里翻不翻转对于这道题问题不大
        Collections.reverse(list);
        int[] res = new int[k];
        //用流将list转换为数组
        res = list.stream().mapToInt(Integer::valueOf).toArray();
        return res;
    }
}

