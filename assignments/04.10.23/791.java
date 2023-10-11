class Solution {
    public String customSortString(String order, String s) {
        int[] frq = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            frq[s.charAt(i)-'a']++;
        }

        String res = "";

        for(int i = 0; i < order.length();i++){
            while(frq[order.charAt(i)-'a']-- > 0){
                res += order.charAt(i);
            }
        }

        for(int i = 0; i < frq.length; i++){
            while(frq[i]-- > 0){
                res += (char)(i + 'a');
            }
        }

        return res;
    }
}