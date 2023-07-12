import java.util.*;
public class hashMapCode {
    static class HashMap<K,V>{
        private class  Node{
            K key;
            V value;

            public Node (K key , V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; //n ( size of linked list)
        private int N; // size of array(buckets)
        private LinkedList<Node> buckets[]; // array of LL consisting nodes  //N

        @SuppressWarnings("uncheaked")
        public HashMap(){
            this.N = 4 ;
            this.buckets = new LinkedList[4];
            for(int i = 0 ; i < 4 ; i ++){
                buckets[i] = new LinkedList<>();
            }
        }
        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchLL(int bi ,K key){
            LinkedList<Node> ll = buckets[bi];
            int di =0 ;
            for(int i= 0 ; i < ll.size() ; i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }
        @SuppressWarnings("uncheaked")
        private void rehash(){
            LinkedList<Node> oldbucket[] = buckets;
            buckets = new LinkedList[2*N];
            N = 2*N;

            for(int i =0 ; i < buckets.length ; i++){
                buckets[i] = new LinkedList<>();
            }

            //nodes ---> add in bucket
            for(int i = 0 ; i < oldbucket.length ;i++){
                LinkedList<Node> ll = oldbucket[i];
                for(int j = 0 ; j < ll.size() ; j ++){
                    Node node= ll.remove();
                    put(node.key, node.value);
                }
            }
        }
        //put
        public void put(K key , V value){
            int bi = hashFunction(key); //bucket idx
            int di = searchLL(bi, key); //data index
            //two cases arrived either the node already there or Not(new node need to be created )
            if(di != -1){ //node is already there
                Node node = buckets[bi].get(di);
                node.value = value;
            }else{
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lamda = (double) n/N;
            if(lamda > 2.0 ){ //let threshhold vaue be 2
                rehash();
            }

        }

        //containskey
        public boolean containsKey(K key){
            int bi = hashFunction(key); //bucket idx
            int di = searchLL(bi, key); //data index
            //two cases arrived either the node already there or Not(new node need to be created )
            if(di != -1){ //node is there(valid)
               return true;
            }else{
               return false;
            }
        }

        //get
        public V get(K key){
            int bi = hashFunction(key); //bucket idx
            int di = searchLL(bi, key); //data index
            //two cases arrived either the node already there or Not(new node need to be created )
            if(di != -1){ //node is already there
                Node node = buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }

        //remove
        public V remove(K key){
            int bi = hashFunction(key); //bucket idx
            int di = searchLL(bi, key); //data index
            //two cases arrived either the node already there or Not(new node need to be created )
            if(di != -1){ //node is already there
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i = 0 ; i < buckets.length ; i++){
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(i, node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n==0;
        }

    }
    
    public static void main(String[] args) {
        HashMap<String , Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);

        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
    }
    
}
