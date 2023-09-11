//5. Longest Palindromic Substring

class Solution {
    int start = 0;
    int end = 0;
    public String longestPalindrome(String s) {

        for(int i=0; i<s.length(); i++){
            expandAroundCenter(s,i,i); //center for current charchter
            //string, starting Index, ending index
            expandAroundCenter(s,i,i+1); //center between two character 
        }
        return s.substring(start, end + 1);
    }

    private void expandAroundCenter(String s, int left, int right){
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        left = left + 1; //from left to Right ==> palindromic substring
        right = right - 1;
        if(end - start + 1 < right - left + 1){
            start = left;
            end = right;
        }
    }
    
}
