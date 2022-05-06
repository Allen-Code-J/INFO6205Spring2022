package FinalTest;

import java.util.*;

/**
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class Problem3 {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs1 = {""};
        String[] strs2 = {"a"};
        SolutionThree solutionThree = new SolutionThree();
        System.out.println(solutionThree.groupAnagrams(strs));
        System.out.println(solutionThree.groupAnagrams(strs1));
        System.out.println(solutionThree.groupAnagrams(strs2));

    }
}
class SolutionThree{
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        //TODO: Write your code here
        for(int i = 0; i < strs.length; i++){
            char[] chArray = strs[i].toCharArray();
            Arrays.sort(chArray);
            String key = new String(chArray);
            if(map.size() == 0){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            }else if(!map.containsKey(key)){
                List<String> list1 = new ArrayList<>();
                list1.add(strs[i]);
                map.put(key, list1);
            }else if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}

