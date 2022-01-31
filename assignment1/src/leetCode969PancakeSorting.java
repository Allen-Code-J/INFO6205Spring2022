import java.util.LinkedList;
import java.util.List;

public class leetCode969PancakeSorting {
}
class Solution969 {
    LinkedList<Integer> result = new LinkedList<>();
    public List<Integer> pancakeSort(int[] arr) {
        sort(arr,arr.length);
        return result;
    }

    public void sort(int[] pancakes,int n){
        if(n == 1) return;
        // 寻找最大烧饼的索引
        int maxCake = 0;
        int maxCakeIndex = 0;
        for(int i=0;i<n;i++){
            if(pancakes[i]>maxCake){
                maxCakeIndex = i;
                maxCake = pancakes[i];
            }
        }
        // 第一次反转 ， 将最大烧饼翻到最上面
        reverse(pancakes,0,maxCakeIndex);
        // 记录这一次反转
        result.add(maxCakeIndex+1);
        // 第二次 反转 ，将最大烧饼翻到最下面
        reverse(pancakes,0,n-1);
        result.add(n);
        // 递归调用 翻转剩下的烧饼
        sort(pancakes,n-1);
    }
    private void reverse(int[] arr, int i, int j) {
        // TODO
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}

