import java.util.*;
public class insertHeap {

    static class Heap{
        ArrayList<Integer> arr = new  ArrayList<>();

        public void add(int data){
            //insert data at end idx
            arr.add(data);

            int x = arr.size()-1 ; //idx of child where it placed
            int par = (x-1)/2;
            //minHeap  -- parent  < child
            while(arr.get(x) < arr.get(par)){
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }

        //heapify is a private functon so that only get used in heap class but not in main in class
        private void heapify(int i){
            int left = 2*i +1;
            int right = 2*i +2;
            int minIdx = i;

            if(left < arr.size() && arr.get(left) < arr.get(minIdx)){
                minIdx = left ;
            }

            if(right < arr.size() && arr.get(right) < arr.get(minIdx)){
                minIdx =  right;
            }

            if(minIdx != i){ //the root is not min so here heapify will work so need to swap
                //swap root and minIdx
                int temp = arr.get(i);
                arr.set(i ,arr.get(minIdx));
                arr.set(minIdx, temp);
                //if even after doing heapify at minIdx heap is not arranged so called recusively
                heapify(minIdx);

            }
        }
        public int remove(){
            int data = arr.get(0);

            //swap 1st and last idx
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //remove last idx
            arr.remove(arr.size()-1);
            
            //finally if heap is mismanaged so do heapify
            heapify(0);
            return data;
        }
        public boolean isEmpty(){
            return arr.size() == 0;
        }

    }
        public static void main(String[] args) {
    
     }
    
}
