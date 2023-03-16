public class rotatedSortedArrKey {
    
    public static int searchIdx(int arr[], int tar ,int si , int ei){
        //base case
        if(si>ei){
            return -1;
        }
        //kaam
        int mid = si + (ei-si)/2;

        //tar FOUND (MID PE HI HAI TARGET)
        if(arr[mid]== tar){
            return mid;
        }

        //mid on L1
        if(arr[si]<= arr[mid]){
            if(tar >= arr[si] && tar <= arr[mid] ){
                //left of L1 (case a)
                return searchIdx(arr, tar, si, mid-1);

            }else{
                //right of L1 or whole (case b)
                return searchIdx(arr, tar, mid+1, ei);
            }
        }

        //mid on L2
        else{
            if(tar >= arr[mid] && tar <= arr[ei]){
                //right of L2 (case c)
                return searchIdx(arr, tar, mid+1, ei);
            }else{
                //right of L2 or whole (case d)
                return searchIdx(arr, tar, si, mid-1);
            }

        }
    }

    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int target = 5;
        int tarIdx = searchIdx(arr, target, 0, arr.length-1 );
        System.out.println(tarIdx);
    }
}
