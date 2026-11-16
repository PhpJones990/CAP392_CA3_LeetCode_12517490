// Solution 1 
class Solution {
    public boolean isPalindrome(String s) {
        String modifiedInput = s.toLowerCase(); 

        int i = 0, j = modifiedInput.length() - 1;
        while(i < j) {
            if(!Character.isLetterOrDigit(modifiedInput.charAt(i))) i++;
            else if(!Character.isLetterOrDigit(modifiedInput.charAt(j))) j--;
            else if(modifiedInput.charAt(i++)!=modifiedInput.charAt(j--)) return false; 
        }
        return true;
    }
} 

// Solution 2
class Solution {
    public boolean isPalindrome(String s) {
        String modifiedInput = ""; 

        for (int i = 0; i < s.length(); i++) 
        {
            if (Character.isLetterOrDigit(s.charAt(i))) modifiedInput += Character.toLowerCase(s.charAt(i));  
        }

        int left = 0, right = modifiedInput.length() - 1; 
        while (left < right) 
        {
            if (modifiedInput.charAt(left++) != modifiedInput.charAt(right--)) return false; 
        }
        return true; 
    }
}
