class Solution {
    public boolean isValid(String s) {
        

        Stack<Character> stack = new Stack<>();

        for(char c:s.toCharArray()){

            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
                continue;
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
            }

            if(c == ')' && stack.peek() == '('){
                stack.pop();
            }
            else if(c == '}' && stack.peek() == '{'){
                stack.pop();
            }

            else if(c == ']' && stack.peek() == '['){
                stack.pop();
            }
            else{
                return false;
            }
        }

        return stack.isEmpty();
    }
}