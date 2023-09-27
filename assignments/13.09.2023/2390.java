class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if(c == '*'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(c);
            }
        }

        StringBuilder ans = new StringBuilder();

        int len = stack.size();

        for(int i = 0; i < len; i++){
            ans.append(stack.pop());
        } 

        return ans.reverse().toString();
    }
}