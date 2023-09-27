class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(char c: s.toCharArray()){

            if(c == '#'){
                if(!stack1.isEmpty()){
                    stack1.pop();
                }
            }
            else{
                stack1.push(c);
            }

        }

        for(char c: t.toCharArray()){

            if(c == '#'){
                if(!stack2.isEmpty()){
                    stack2.pop();
                }
            }
            else{
                stack2.push(c);
            }

        }

        if(stack1.size() != stack2.size()){
            return false;
        }

        int len = stack1.size();

        for(int i = 0; i < len; i++){
            char c1 = stack1.pop();
            char c2 = stack2.pop();
            if(c1 != c2){
                return false;
            }
        }
        return true;
    }
}