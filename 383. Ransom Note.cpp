class Solution {
public:
    bool canConstruct(string t, string s) {
        //t from s
        unordered_map<char,int>mp;

        for(int i=0;i<s.size();i++){
            mp[s[i]]++;
        }

        for(int i=0;i<t.size();i++){
            if(mp[t[i]]>0) mp[t[i]]--; // if have decrement its count by one from map
    // dont have suffucient character return false you can't make it.
            else return false;
        }
   // you can make it
        return true;
    }
};
