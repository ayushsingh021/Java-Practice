public class mgsWord {

    public static void merge(String arr[],int p,int q,int r,int ind){
        int n1=q-p+1;
        int n2=r-q;
        String L[]=new String[n1];
        char Lc[]=new char[n1+1];
        String R[]=new String[n2];
        char Rc[]=new char[n2+1];
        for (int i = 0; i < n1; i++) {
            L[i]=arr[p+i];
            if(arr[p+i].length()<=ind){
                Lc[i]=Character.MIN_VALUE;
            }
            else{
                Lc[i]=arr[p+i].charAt(ind);

            }
        }
        for (int i = 0; i < n2; i++) {
            R[i]=arr[q+1+i];
            if(arr[q+1+i].length()<=ind){
                Rc[i]=Character.MIN_VALUE;
            }
            else{
                Rc[i]=arr[q+1+i].charAt(ind);
            }
        }
        Lc[n1]=Rc[n2]=Character.MAX_VALUE;
        int i=0,j=0;

        int init=0,dest=0;
        char checkc='\0';
        for (int k = p; k <= r; k++) {
            if(Lc[i]<Rc[j]){
                if(checkc!='\0'){
                    if(checkc!=Lc[i]){
                        mergeSort(arr, init, k-1,ind+1);
                        checkc='\0';
                    }
                }
                arr[k]=L[i++];
            }
            else if(Lc[i]==Rc[j]){

                if(checkc!='\0'){
                    if(checkc!=Lc[i]){
                        mergeSort(arr, init, k-1,ind+1);
                        checkc='\0';
                    }
                }
                
                if(checkc=='\0'){
                    checkc=Lc[i];
                    init=k;
                }
                arr[k]=L[i++];

            }
            else{
                if(checkc!='\0'){
                    if(checkc!=Rc[j]){
                        mergeSort(arr, init, k-1,ind+1);
                        checkc='\0';
                    }
                }
                arr[k]=R[j++];
            }
        }
        if(checkc!='\0'){
            mergeSort(arr, init, r,ind+1);
        }
    }


    public static void mergeSort(String arr[],int p,int r,int ind){
        // System.out.println(p+" "+r+" "+ind);
        if(p<r){
            int q=(p+r)/2;
            mergeSort(arr,p,q,ind);
            mergeSort(arr,q+1,r,ind);
            merge(arr,p,q,r,ind);

        }
    }

    public static void print(String arr[] ){
        for(String i:arr){
            System.out.print(i+" ");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        // String names[]={"abcde","aabcd","aaabc","aaaab","aaaaa","bcd"};
        // String names[]={"hello","govind","abc","bcd","def","pqr"};
        String names[]={"hello","govind","aabc","aa","aa","aaabc"};
        // String names[]={"hello","govind","ayush","golu","manish","aayush"};


        System.out.println("Array before sorting : ");
        print(names);

        mergeSort(names, 0, 5,0);

        System.out.println("Array after sorting : ");
        print(names);

    }
}
