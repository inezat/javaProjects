package sorttimer2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Ian Nezat (inezat2)
 * Creates an array of random integers.
 * Uses the selection sort, insertion sort, merge sort and quick sort 
 * to sort the array.
 * Gets and prints run times for the sort methods.
 */
public class SortTimer2 {


 /**
 * This is the selectionSort method
 * @param nums - an array 
 */
public static void selectionSort(int[] nums){
    int n = nums.length; 
    
        for (int i = 0; i < n-1; i++) 
        {  
            int min = i; 
            for (int j = i+1; j < n; j++) 
                if (nums[j] < nums[min]) 
                    min = j; 
            int temp = nums[min]; 
            nums[min] = nums[i]; 
            nums[i] = temp; 
        } 
}


/**
 * This is the selectionSortPrint method
 * @param nums - an array
 */
public static void selectionSortPrint(int[] nums){
    int n = nums.length; 
    
        for (int i = 0; i < n-1; i++) 
        {  
            int min = i; 
            for (int j = i+1; j < n; j++) 
                if (nums[j] < nums[min]) 
                    min = j; 
            int temp = nums[min]; 
            nums[min] = nums[i]; 
            nums[i] = temp; 
        System.out.println("nums = " + Arrays.toString(nums));
        } 
}


/**
 * This is the insertionSort method
 * @param nums - an array
 */
public static void insertionSort(int[] nums){
    int n = nums.length; 
        for (int i=1; i<n; ++i) 
        { 
            int holder = nums[i]; 
            int j = i-1; 
            
            while (j>=0 && nums[j] > holder) 
            { 
                nums[j+1] = nums[j]; 
                j = j-1; 
            } 
            nums[j+1] = holder; 
        } 
}


/**
 * This is the insertionSortPrint method
 * @param nums - an array
 */
public static void insertionSortPrint(int[] nums){
    int n = nums.length; 
        for (int i=1; i<n; ++i) 
        { 
            int holder = nums[i]; 
            int j = i-1; 
            
            while (j>=0 && nums[j] > holder) 
            { 
                nums[j+1] = nums[j]; 
                j = j-1; 
            } 
            nums[j+1] = holder; 
        System.out.println("nums = "+Arrays.toString(nums));
        }
}


/**
 * This is the mergeSort method
 * @param nums - an array
 * @param left
 * @param right 
 */
public static void mergeSort(int[] nums, int left, int right){
    if(left < right){
        int mid = (left + right)/2;
        
        if(left < mid)
            mergeSort(nums, left, mid);
        
        if((mid+1) < right)
            mergeSort(nums, mid+1, right);
        
        int[] result = new int[right-left+1];
        int m = left, n = mid+1, k=0;
        
        while(m <= mid && n <= right){
            if(nums[m] < nums [n]){
                result[k] = nums[m];
                    k++;
                    m++;
            }else{
            result[k] = nums[n];
            k++;
            n++;
            }
        }
        
        if(n > mid+1){
            if(m <= mid){
                while(m <= mid){    
                result[k] = nums[m];
                k++;
                m++;
                }   
            }else{
                while(n <= right){
                result[k] = nums[n];
                k++;
                n++;
                }
            }
        }
        for(int i = 0; i < result.length;i++){
        nums[left + i] = result[i];
        }
    }
}


/**
 * This is the mergeSortPrint method
 * @param nums - an array
 * @param left
 * @param right 
 */
public static void mergeSortPrint(int[] nums, int left, int right){
    if(left < right){
        int mid = (left + right)/2;
        
        if(left < mid)
            mergeSortPrint(nums, left, mid);
        
        if((mid+1) < right)
            mergeSortPrint(nums, mid+1, right);
        
        int[] result = new int[right-left+1];
        int m = left, n = mid+1, k=0;
        
        while(m <= mid && n <= right){
            if(nums[m] < nums [n]){
                result[k] = nums[m];
                    k++;
                    m++;
            }else{
            result[k] = nums[n];
            k++;
            n++;
            }
        }
        
        if(n > mid+1){
            if(m <= mid){
                while(m <= mid){    
                result[k] = nums[m];
                k++;
                m++;
                }   
            }else{
                while(n <= right){
                result[k] = nums[n];
                k++;
                n++;
                }
            }
        }
        for(int i = 0; i < result.length;i++){
        nums[left + i] = result[i];
        }
    System.out.println("nums = " + Arrays.toString(nums));
    }
}


/**
 * This is the quickSort method
 * @param nums - an array
 * @param left
 * @param right 
 */
public static void quickSort(int[] nums, int left, int right){
    if(left < right){
        int pivotPoint = partition(nums, left, right);
        if(left < pivotPoint){
            quickSort(nums, left, pivotPoint);
        }
        if(pivotPoint+1 < right){
            quickSort(nums, pivotPoint+1, right);
        }
    }
}



/**
 * This is the partition method
 * @param nums - an array
 * @param left
 * @param right
 * @return j
 */
public static int partition(int[] nums, int left, int right){
    int pivot = nums[left];
    int i = left - 1;
    int j = right + 1;
    while(i < j){
        
        do{
        i++;   
        }while(nums[i] < pivot);
        
        do{
            j--;
        }while(nums[j] > pivot);
        
            int temp = nums[i];
        if(i < j){
            nums[i] = nums[j];
            nums[j] = temp;
            
        }
    }
    return j;
}


/**
 * This is the quickSortPrint method
 * @param nums - an array
 * @param left
 * @param right 
 */
public static void quickSortPrint(int[] nums, int left, int right){
    if(left < right){
        int pivotPoint = partition(nums, left, right);
        System.out.println("nums = " + Arrays.toString(nums));
        if(left < pivotPoint){
            quickSortPrint(nums, left, pivotPoint);
        }
        if(pivotPoint+1 < right){
            quickSortPrint(nums, pivotPoint+1, right);
        }
    }
}



/**
 * This is the main method
 * @param args 
 */
    public static void main(String[] args) {
         int[] numsSelection = {5,6,4,7,2,1,8,3};
        System.out.println("Selection Sort:");
        System.out.println("nums = " + Arrays.toString(numsSelection));
        selectionSortPrint(numsSelection);
        System.out.println();
        
        int[] numsInsertion = {5,8,4,6,2,1,7,3};
        System.out.println("Insertion Sort:");
        System.out.println("nums = " + Arrays.toString(numsInsertion));
        insertionSortPrint(numsInsertion);
        System.out.println();
        
        int[] numsMerge = {5,3,6,4,2,0,1};
        System.out.println("Merge Sort:");
        System.out.println("nums = " + Arrays.toString(numsMerge));
        mergeSortPrint(numsMerge, 0, numsMerge.length-1);
        System.out.println();
        
        int[] numsQuick = {5,8,4,7,2,1,6,3};
        System.out.println("Quick Sort:");
        System.out.println("nums = " + Arrays.toString(numsQuick));
        quickSortPrint(numsQuick, 0, numsQuick.length-1);
        System.out.println();
        
        int seed = 0;
        Random rand = new Random(seed);
        int maxRandomValue = 1000000;
        int numRuns = 3;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the starting value for the length n of "
                + "the array to be sorted, the stepsize by which n is "
                + "increased, and the number of steps: ");
        int start = in.nextInt();
        int stepSize = in.nextInt();
        int numSteps = in.nextInt();
        int end = start + numSteps * stepSize;
        System.out.println();
        
        for (int n = start; n <= end; n += stepSize)
        {            
            int[] nums1 = new int[n];
            int[] nums2 = new int[n];
            int[] nums3 = new int[n];
            int[] nums4 = new int[n];
            long sum1 = 0;
            long sum2 = 0;
            long sum3 = 0;
            long sum4 = 0;
            int m;
            
            for (int j = 1; j <= numRuns; j++)
            {                    
                for (int i = 0; i < n; i++)
                {
                    m = rand.nextInt(maxRandomValue) + 1;
                    nums1[i] = m;
                    nums2[i] = m;
                    nums3[i] = m;
                    nums4[i] = m;
                }
                
                long startTime = System.currentTimeMillis();
                selectionSort(nums1);
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                sum1 += elapsedTime;        
                
                startTime = System.currentTimeMillis();
                insertionSort(nums2);
                endTime = System.currentTimeMillis();
                elapsedTime = endTime - startTime;
                sum2 += elapsedTime;        

                startTime = System.currentTimeMillis();
                mergeSort(nums3, 0, nums3.length-1);
                endTime = System.currentTimeMillis();
                elapsedTime = endTime - startTime;
                sum3 += elapsedTime;        

                startTime = System.currentTimeMillis();
                quickSort(nums4, 0, nums4.length-1);
                endTime = System.currentTimeMillis();
                elapsedTime = endTime - startTime;
                sum4 += elapsedTime;                    
            }
            long average1 = (long)(1. * sum1 / numRuns);
            long average2 = (long)(1. * sum2 / numRuns);
            long average3 = (long)(1. * sum3 / numRuns);
            long average4 = (long)(1. * sum4 / numRuns);
            System.out.printf("n = %6d   Sort Run Time (milliseconds):  "
                    + "Selection: %4d   Insertion: %4d   Merge: %3d"
                    + "   Quick: %3d\n", 
                    n, average1, average2, average3, average4);
        }
    }
    
}
