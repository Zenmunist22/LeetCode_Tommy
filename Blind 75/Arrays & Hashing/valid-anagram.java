class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        if (s.length() != t.length()){
            return false;
        }
        for (char c: s.toCharArray()){
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }
        for (char c: t.toCharArray()){
            if (hm.get(c) == null || hm.get(c) == 0){
                return false;
            }
            hm.put(c, hm.get(c)-1);
        }
        return true;
    }
}