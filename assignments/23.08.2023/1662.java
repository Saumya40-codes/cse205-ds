class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        String res = "";
        // for(int i = 0; i < word1.length ; i++){
        //     res += word1[i];
        // }

        String res1 = "";
        // for(int i = 0; i < word2.length; i++){
        //     res1 += word2[i];
        // }

        for(int i = 0 ; i < Math.max(word1.length , word2.length) ; i++){
            if(i < word1.length){
                res += word1[i];
            }

            if(i < word2.length){
                res1 += word2[i];
            }
        }

        return res.equals(res1);
    }
}