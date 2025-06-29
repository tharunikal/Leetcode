class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            String key = helper(s);

            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
    String helper(String s){
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    
}
