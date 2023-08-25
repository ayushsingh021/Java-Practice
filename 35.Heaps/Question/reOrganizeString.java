// Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

// Return any possible rearrangement of s or return "" if not possible.

 

// Example 1:

// Input: s = "aab"
// Output: "aba"
// Example 2:

// Input: s = "aaab"
// Output: ""


//intuition

// It's easy to realise what we need to do here, alternatively put characters with maximum frequency. The problem lies in implementing this.

// Even if you get the intuition of using Heaps, it's still a tricky one to implement.

// So, the trick is to store pair of {frequency,char} in a Heap. Then while Heap.size()>1 , at every iteration, take out the top two elements, append them to the ans string, decrease their frequency by 1 and push them again in the Heap.

// When the loop will break, either the Heap became empty or of 1 size.

// If it's empty, return the ans string.

// if it has size == 1, check the remaining frequency of the top/last element, if its 1, append it and return ans.

// Otherwise, return ""


class Solution {
    public class Pair  implements Comparable<Pair>{
        int freq;
        char alph;
        public Pair(int f  ,char a){
            this.freq = f;
            this.alph = a;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.freq - this.freq;
        }
    }
    public String reorganizeString(String s) {
        StringBuilder ans = new StringBuilder();
       
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) , 0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Set<Character> key = map.keySet();
        for(Character k : key){
            pq.add(new Pair(map.get(k) , k));
        }

        while(pq.size()>1){
           ans.append(pq.peek().alph);
           Pair top1 = pq.remove();
           ans.append(pq.peek().alph);
           Pair top2 = pq.remove();
        
           if( top1.freq > 1){
               pq.add(new Pair(top1.freq -1 , top1.alph));
           }
            if( top2.freq > 1){
               pq.add(new Pair(top2.freq -1 , top2.alph));
           }
            
        }

        if(pq.isEmpty()){
            return ans.toString();
        }
        else if(pq.size() == 1){
            if(pq.peek().freq == 1){
                ans.append(pq.remove().alph);
                return ans.toString();
            }
        }

        return"" ;


    }
}