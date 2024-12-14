package String;

/**
 * 680. Valid Palindrome II
 * https://leetcode.com/problems/valid-palindrome-ii/description/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 **/
public class ValidPalindromeII_easy {

    public Boolean validPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int i=0, j=s.length()-1;

        while(i<s.length() && j> 0 && i<j) {
            if(s.charAt(i) != s.charAt(j)) {
                return checkPalindrom(s, i+1, j) || checkPalindrom(s,i,j-1);
            }
            j--;
            i++;
        }
        return true;
    }

    public Boolean checkPalindrom(String s, int i, int j) {
        while(i<s.length() && j> 0 && i<j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
