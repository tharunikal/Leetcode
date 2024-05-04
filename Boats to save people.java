class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans=0;
        int [] flag=new int [people.length];
        for(int i=0;i<people.length;i++){
            if(flag[i]==0){
                int j=people.length-1;
                while(i<j){
                    if(flag[j]==0 && people[i]+people[j]<=limit){
                        flag[j]=1;
                        break;
                    }
                    j--;
                }
                ans++;
            }
        }
        return ans;
    }
}
