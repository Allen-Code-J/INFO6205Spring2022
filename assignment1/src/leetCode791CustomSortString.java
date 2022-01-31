public class leetCode791CustomSortString {
}
class Solution791 {
    public String customSortString(String S, String T) {
        int[] result = new int[26];
        for(int i=0;i<T.length();i++){
            char c = T.charAt(i);
            result[c - 'a']++;
        }

        StringBuilder answer = new StringBuilder();

        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            while (result[c-'a'] > 0){
                answer.append(c);
                result[c-'a']--;
            }
        }
        for(int i=0;i<26;i++){
            while (result[i] > 0){
                answer.append((char)(i+'a'));
                result[i]--;
            }
        }
        return answer.toString();
    }
}

