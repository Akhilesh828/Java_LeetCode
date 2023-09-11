//7. Reverse Integer

class Solution {
    public int reverse(int x) {
        int reversed =0;
        int max= Integer.MAX_VALUE;
        int min= Integer.MIN_VALUE;
        while(x != 0){
            int lastDigit = x%10;

            if(reversed > max/10 || (reversed == max/10 && lastDigit > 7))
            return 0; // over positive

            if(reversed < min/10 || (reversed == min/10 && lastDigit < -8))
            return 0; //over negative
            reversed = reversed * 10 + lastDigit;
            x = x/10;
        }
        return reversed;
    }
}

/*------------------------------------------------------------------------*/
//dont use this 

class Solution {
    public int reverse(int no) {
        int rem;
        int rev = 0;
        while(no !=0){
            rem=no%10;  
            rev = rev*10+rem;
            no=no/10;
        }
        return rev;
    }
}
