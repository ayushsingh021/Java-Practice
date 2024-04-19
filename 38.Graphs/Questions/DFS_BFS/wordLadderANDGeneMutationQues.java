
// A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

// Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.

// For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
// There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

// Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.

// Note that the starting point is assumed to be valid, so it might not be included in the bank.

 

// Example 1:

// Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
// Output: 1
// Example 2:

// Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
// Output: 2
//Gene Mutations solution
class Solution {
  public int minMutation(String startGene, String endGene, String[] bank) {
    Set<String> st = new HashSet<>();
    for (String val : bank) {
        st.add(val);
    }
    Set<String> vis = new HashSet<>();
    Queue<String> q = new LinkedList<>();
    q.add(startGene);
    vis.add(startGene);
    int level = 0;
    while (!q.isEmpty()) {
        int n = q.size();
        while (n-- > 0) {
            String curr = q.remove();
            if (curr.equals(endGene)) {
                // reached target
                return level;
            }
            char[] currArray = curr.toCharArray();
            for (char ch : "ACGT".toCharArray()) {
                for (int i = 0; i < currArray.length; i++) {
                    char original = currArray[i];
                    currArray[i] = ch; // first try with 'A' for all posn, Then 'C', Then G and Then 'T'
                    String neigh = new String(currArray);

                    if (!vis.contains(neigh) && st.contains(neigh)) {
                        vis.add(neigh);
                        q.add(neigh);
                    }

                    // Restore the original character for the next iteration
                    currArray[i] = original;
                }
            }
        }
        level++;
    }

    return -1;
}

}



// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
// sk == endWord
// Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

// Example 1:

// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
// Output: 5
// Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

//Word ladder solution  
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        // Collections.sort(wordList);
        for(int i =0 ; i < wordList.size() ; i++){
            st.add(wordList.get(i));
        }
        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        vis.add(beginWord);
        int level = 1;
        //BFS
        while(!q.isEmpty()){
            int n = q.size();
            while(n-- > 0){
                String curr = q.remove();
                System.out.println(curr);
                if(curr.equals(endWord)){
                    //reached target
                    return level;
                }
                 
                char[] currArray = curr.toCharArray();
                for (char ch : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
                for (int i = 0; i < currArray.length; i++) {
                    char original = currArray[i];
                    currArray[i] = ch; // first try with 'A' for all posn, Then 'C', Then G and Then 'T'
                    String neigh = new String(currArray);

                    if (!vis.contains(neigh) && st.contains(neigh)) {
                        vis.add(neigh);
                        q.add(neigh);
                    }

                    // Restore the original character for the next iteration
                    currArray[i] = original;
                }
            }
             
            }
            level++;
        }

        return 0;
       
    }
    
}