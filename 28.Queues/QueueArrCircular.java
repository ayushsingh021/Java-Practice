public class QueueArrCircular {
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front;
        //constructor
        Queue(int n){
            arr = new int[n];
            size= n;
            rear =-1;
            front = -1;
        }
        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }
        public static boolean isFull(){
            return (rear+1)%size == front;
        }

        //add
        public static void add(int data){
            //end scenario
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            //add first element
            if(front == -1){
                front = 0;
            }
            // rear =rear+1;
            rear = (rear+1)%size;
            arr[rear] = data;
        }

        //remove  --similar to pop
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return- 1;
            }
            int result = arr[front];
            // for(int i =0 ; i<rear ; i++){
            //     arr[i] = arr[i+1];
            // }
            //last elemenr delete
            if(rear == front ){
                rear = front = -1;
            }else{
                front  = (front+1)%size;
            }

            return result;
        }
        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int ans  = arr[front];
            return ans;
        }
    }
    
    
    
    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);


        while(!q.isEmpty()){
            System.out.println( q.peek());
            q.remove();     
        }

      

    }
    
}