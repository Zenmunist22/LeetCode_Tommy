class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        
        for (int i = 0; i < strs.length; i++){
            int[] countHash = new int[26];
            for (int j = 0; j < strs[i].length(); j++){
                countHash[strs[i].charAt(j) - 'a']++;
            }
            String hash = "";
            for (int x:  countHash){
                hash += " " + x;
            }
            if (hm.containsKey(hash)){
                ArrayList temp = hm.get(hash);
                temp.add(strs[i]);
                hm.put(hash, temp);

            }
            else{
                ArrayList<String> lst = new ArrayList<String>();
                lst.add(strs[i]);
                hm.put(hash, lst);
            }
        }
        List<List<String>> res = new ArrayList<List<String>>(hm.values());
        return res;
    }
}