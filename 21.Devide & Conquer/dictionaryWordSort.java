public class dictionaryWordSort {


    public static String[] mergeSort(String[] arr , int lo ,int hi){
        //base case
        // System.out.println(lo+ " "+arr.length);

        // // if(lo == hi){
        //     String[] A ={ arr[lo] };
        //     return A;
        // // }
        //kaam

        if(lo<hi){
        
            int mid = lo - (hi-lo)/2 ; 
            String[] str1 = mergeSort(arr, lo, mid); //left
            String[] str2 = mergeSort(arr, mid+1, hi);//right
            String[] str3 = merge (str1 , str2); //merging the sorted array
            return str3;

         }else{
            String[] A ={ arr[lo] };
            return A;
         }
        

       }

       public static String[] merge( String[] str1, String[] str2){
        int m = str1.length;
        int n = str2.length;
        String[] arr3 = new String[m+n];

        //iterators
        int i = 0;
        int j = 0;
        int idx = 0;

        while(i<m && j< n){
            if(isAlphabeticallySmall(str1[i], str2[j])){
                arr3[idx]= str1[i];
                i++;
                idx++;
            }else{
                arr3[idx]= str2[j];
                j++;
                idx++;
            }
        }
        while(i<m){
            arr3[idx]= str1[i];
                i++;
                idx++;
        }
        while(j<n){
            arr3[idx]= str2[j];
                j++;
                idx++;
        }
        return arr3;
    }

       public static boolean isAlphabeticallySmall(String str1 , String str2){
            if(str1.compareTo(str2)<0){
                return true;
            }
            return false;
       }
    public static void main(String[] args) {
        String[] arr = {"sun","earth","mercury","mars"};
        String[] a = mergeSort(arr ,0 , arr.length-1 );

        for(int i =0 ; i < a.length ; i++){
            System.out.print(arr[i] + " ");
        }
        
    }
    
}
