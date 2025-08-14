class Solution {
    public String largestGoodInteger(String s) {
        if (s.contains("999")) return "999";
        if (s.contains("888")) return "888";
        if (s.contains("777")) return "777";
        if (s.contains("666")) return "666";
        if (s.contains("555")) return "555";
        if (s.contains("444")) return "444";
        if (s.contains("333")) return "333";
        if (s.contains("222")) return "222";
        if (s.contains("111")) return "111";
        if (s.contains("000")) return "000";
        return "";
    }
}
