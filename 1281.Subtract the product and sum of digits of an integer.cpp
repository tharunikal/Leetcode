class Solution {
public:
    int subtractProductAndSum(int n)
    { int sum=0;
    int product=1;
    while(n!=0)
    {
        int lastdigit=n%10;//extracting the digits of the number 
        sum+=lastdigit;
        product=product*lastdigit;
        n=n/10;

    }
     return product-sum;   
        
    }
    
};
