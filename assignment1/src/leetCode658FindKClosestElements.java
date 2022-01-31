import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class leetCode658FindKClosestElements {
}
class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(result, (a, b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
        result = result.subList(0, k);
        Collections.sort(result);
        return result;
    }
}


