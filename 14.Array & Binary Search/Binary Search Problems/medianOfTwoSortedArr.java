// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

 

// Example 1:

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

//with extra space -of merged array
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0 ; 
        int j = 0;
        int k = 0 ;
        int arr[] = new int[nums1.length + nums2.length];
        while(i < nums1.length && j< nums2.length){
            if(nums1[i] < nums2[j]){
                arr[k] = nums1[i];
                k++;
                i++;
            }else{
                arr[k] = nums2[j];
                k++;
                j++;
            } 
        }
        while(i < nums1.length){
             arr[k] = nums1[i];
              k++;
              i++;
        }
        while( j< nums2.length){
             arr[k] = nums2[j];
             k++;
             j++;
        }

       
        double ans =  0;
        if((arr.length&1)  == 0){
            //even
            int mid = arr.length/2; 
            ans = (double)(arr[mid] + arr[mid-1])/2;
            return ans;
        }

        ans = arr[arr.length/2];
        return ans;
}
}

//without using extra space -- optimal



import java.util.*;

public class Solutionx`{
    public static double median(int[] a, int[] b) {
        // Size of two given arrays
        int n1 = a.length;
        int n2 = b.length;

        int n = n1 + n2; //total size
        //required indices:
        int ind2 = n / 2;
        int ind1 = ind2 - 1;
        int cnt = 0;
        int ind1el = -1, ind2el = -1;

        //apply the merge step:
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (cnt == ind1) ind1el = a[i];
                if (cnt == ind2) ind2el = a[i];
                cnt++;
                i++;
            } else {
                if (cnt == ind1) ind1el = b[j];
                if (cnt == ind2) ind2el = b[j];
                cnt++;
                j++;
            }
        }

        //copy the left-out elements:
        while (i < n1) {
            if (cnt == ind1) ind1el = a[i];
            if (cnt == ind2) ind2el = a[i];
            cnt++;
            i++;
        }
        while (j < n2) {
            if (cnt == ind1) ind1el = b[j];
            if (cnt == ind2) ind2el = b[j];
            cnt++;
            j++;
        }

        //Find the median:
        if (n % 2 == 1) {
            return (double)ind2el;
        }

        return (double)((double)(ind1el + ind2el)) / 2.0;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        System.out.println("The median of two sorted arrays is " + median(a, b));
    }
}

// Approach 2 -- implication
// Given two arrays arr1 and arr2 of size N and M respectively and an element K. The task is to find the element that would be at the kth position of the final sorted array.
//  arr1[] = {2, 3, 6, 7, 9}
// arr2[] = {1, 4, 8, 10}
// k = 5
// Output:
// 6
// Explanation:
// The final sorted array would be -
// 1, 2, 3, 4, 6, 7, 8, 9, 10
// The 5th element of this array is 6.

class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        long cnt = 1 ;
        int i= 0 ; 
        int j = 0;
        while( i < n  && j < m){
            if(arr1[i] < arr2[j]){
                if(cnt == k ) return arr1[i];
                i++;
                cnt++;
            }else{
                if(cnt == k ) return arr2[j];
                j++;
                cnt++;
            }
        }
        while( i < n){
             if(cnt == k ) return arr1[i];
                i++;
                cnt++;
        }
        while(j < m ){
            if(cnt == k ) return arr2[j];
                j++;
                cnt++;
        }
        
        return 0;
        
    }
}