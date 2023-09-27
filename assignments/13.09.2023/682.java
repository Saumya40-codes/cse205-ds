class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String s: operations){
            if(s.equals("C")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else if(s.equals("D")){
                if(!stack.isEmpty()){
                    int prev = stack.peek();
                    stack.push(prev*2);
                }
            }
            else if(s.equals("+")){
                if(stack.size() >= 2){
                    int prev1 = stack.pop();
                    int prev2 = stack.pop();

                    int total = prev1 + prev2;
                    stack.push(prev2);
                    stack.push(prev1);

                    stack.push(total);
                }
            }

            else{
                stack.push(Integer.parseInt(s));
            }
        }

        int ans = 0;

        int len = stack.size();

        for(int i = 0; i < len ; i++){
            ans += stack.pop();
        }

        return ans;
    }
}