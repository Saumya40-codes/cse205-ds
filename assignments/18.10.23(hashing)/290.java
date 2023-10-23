class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        char[] txt = pattern.toCharArray();
        if(txt.length != arr.length){
        return false;
        }
        HashMap<String , Character> strtochar = new HashMap<>();
        HashMap<Character , String> chartostr = new HashMap<>();
        for(int i = 0 ; i < txt.length ; i++){
            String wrd = arr[i];
            char cr = txt[i];

            if(!strtochar.containsKey(wrd)){
                strtochar.put(wrd,cr);
            }
            if(!chartostr.containsKey(cr)){
                chartostr.put(cr,wrd);
            }
            if(!strtochar.get(wrd).equals(cr) || !chartostr.get(cr).equals(wrd)){
                return false;
            }
        }
        return true;
    }
}