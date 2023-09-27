class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < tickets.length ; i++){
            q.offer(new int[]{tickets[i],i});
        }

        int cnt = 0;

        while(!q.isEmpty()){

            int[] arr = q.poll();
            int num = arr[0];
            int idx = arr[1];

            num -= 1;

            if(num > 0){
                q.offer(new int[]{num,idx});
            }

            if(idx == k && num == 0){
                break;
            }

            cnt++;
        }

        return cnt+1; // +1 as count doesnt get incremented when break condition is excecuted
    }
}