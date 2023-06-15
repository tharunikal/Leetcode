class Solution {
public:
    int reverse(int x)
     {
        int reve=0;
        while(x!=0)
        {int n=x%10;
        if(reve>INT_MAX/10||reve<INT_MIN/10)//when the integer exceedthe 32 bit range
        //INT_MAX and INT_MIN are predefined limits in the header<limits.h>
        {
            return 0;
        }
                   
        reve=(reve*10)+n;
        x=x/10;
                 
        
        
        }
        return reve;
     }   
};

