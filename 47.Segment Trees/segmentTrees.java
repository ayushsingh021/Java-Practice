public class segmentTrees{


    //Building a segment tree
    static int tree[];
    public static void init(int n){
        tree = new int[4*n];
    }
    public static int buildST(int arr[] , int STi , int start , int end){//O(n)

        //STi -- segment tree idx
            //base case
            if(start == end){
                tree[STi] = arr[start];
                return arr[start];
            }
            int mid = start + (end-start)/2;

            buildST(arr, 2*STi+1, start, mid); //left-subtree --2i+1
            buildST(arr, 2*STi+2, mid+1, end); //right-subtree -- 2i+2
            tree[STi ]= tree[2*STi+1]+ tree[2*STi+2];
            return tree[STi]; 
     }

    
    //Create
    public static int getSum(int arr[] , int qi , int qj){//O(logn)
        int n = arr.length;
        return getSumUtil(0 , 0 , n-1, qi, qj);
    }

    public static int getSumUtil(int i, int si , int sj, int qi , int qj){
        if(qj <= si || qi >= sj ){//non-overlapping
            return 0;
        }
        else if(si >= qi && sj <= qj){// complete overlapping
            return tree[i];
        }else{
            //partial overlap
            int mid= si + (sj-si)/2;
            int left = getSumUtil(2*i+1, si, mid, qi, qj);
            int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);

            return left + right;

        }
    }

    //Update
    public static void update(int arr[] , int idx , int newVal){//O(logn)
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;

        updateUtil(0,0,n-1 , idx ,diff);
    }
    public static void updateUtil(int i , int si , int sj , int idx , int diff){
        if(idx > sj || idx < si){
            //non-overlaping
            return;
        }
        tree[i] += diff;
        if(si != sj){//non-leaf
            int mid = si + (sj-si)/2;
            updateUtil(2*i+1, si, mid, idx, diff);//left-half
            updateUtil(2*i+2, mid+1, sj, idx, diff); //right-half
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);

        for(int i = 0 ; i < tree.length ; i++){
            System.out.print(tree[i]+ " ");
        }

        System.out.println(getSum(arr , 2,5));
        update(arr, 2, 2);
        System.out.println();
         for(int i = 0 ; i < tree.length ; i++){
            System.out.print(tree[i]+ " ");
        }
    }
}