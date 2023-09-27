class MyCircularQueue {

    private int rear;
    private int front;
    private int[] q;

    public MyCircularQueue(int k) {
        rear = -1;
        front = -1;

        q = new int[k];   
    }
    
    public boolean enQueue(int value) {
        if((rear+1)%q.length == front){
            return false;
        }

        front = front == -1? 0:front;

        rear = (rear+1)%q.length;
        q[rear] = value;

        return true;
    }
    
    public boolean deQueue() {
        if(front == -1){
            return false;
        }

        if(front == rear){
            front = -1;
            rear = -1;
            return true;
        }

        front = (front+1)%q.length;
        return true;
    }
    
    public int Front() {
        if(front == -1){
            return -1;
        }

        return q[front];
    }
    
    public int Rear() {
        if(rear == -1){
            return -1;
        }

        return q[rear];
    }
    
    public boolean isEmpty() {
        if(front == -1){
            return true;
        }

        return false;
    }
    
    public boolean isFull() {
        if((rear+1)%q.length == front){
            return true;
        }

        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */