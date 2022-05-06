package FinalTest;

/**
 * Question1: String Compression:
 * Implement a method to perform basic string compression using the
 * counts of repeated characters. For example, the string aabcccccaaa would
 * become a2b1c5a3. If the "compressed" string would not become smaller than
 * the original string, your method should return the original string.
 * You can assume the string has only uppercase and lowercase letters (a - z).
 */

public class Problem1 {
    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println(new SolutionOne().compressString(str));
    }
}

class SolutionOne {
    /**
     * @param originalString: a string
     * @return: a compressed string
     */
    public String compressString(String str) {
        // write your code here
        if(str.length() <= 1) return str;

        StringBuffer result = new StringBuffer();
        int n = 1;
        int i = 0;
        for(i = 0; i < str.length() - 1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                n++;
            }else{
                result.append(str.charAt(i));
                result.append(n);
                n = 1;
            }
        }
        if(str.charAt(str.length()-2) == str.charAt(str.length()-1)){
            result.append(str.charAt(i));
            result.append(n);
        }
        String newStr = result.toString();
        if(newStr.length() >= str.length()) return str;
        else return newStr;
    }
}
