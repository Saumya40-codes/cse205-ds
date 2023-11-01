class Solution {
    public int largestInteger(int num) {
        int temp = num;
        PriorityQueue odd = new PriorityQueue<>();
        PriorityQueue even = new PriorityQueue<>();


        while(temp != 0){
            int digit = temp%10;

            if(digit % 2 == 0) even.offer(digit);
            if(digit % 2 != 0) odd.offer(digit);

            temp /= 10;
        }

        StringBuilder sb = new StringBuilder();

        temp = num;

        while(temp != 0){
            int digit = temp%10;
            if(digit % 2 == 0){
                sb.insert(0,even.poll());
            }
            else{
                sb.insert(0,odd.poll());
            }
            temp /= 10;
        } 

        return Integer.parseInt(sb.toString());
    }
}