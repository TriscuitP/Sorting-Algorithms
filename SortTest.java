import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class SortTest<T extends Comparable<T>>
    {
    public static int[] randomArray(int size)
        {
        Random n = new Random();
        int[] array = new int[size];
        for(int i = 0; i < size; i++)
            {
            array[i] = n.nextInt(100);
            }
        return array;
        }
    
    public static LLNode randomLL(int size)
        {
        Random r = new Random();
        LLNode list = new LLNode(r.nextInt(100));
        LLNode temp = list;

        for (int i = 0; i < size - 1; i++)
            {
            temp.setNext(new LLNode(r.nextInt(100)));
            temp  = temp.next();
            }
        return list;
        }
    
    public static Integer[] reverseArray(Integer[] inputArray)
        {
        int temp;
        
        for (int i = 0; i < inputArray.length/2; i++) 
            {
            temp = inputArray[i];
            inputArray[i] = inputArray[inputArray.length-1-i];
            inputArray[inputArray.length-1-i] = temp;
            }
        return inputArray;
        }
    
    public static int[] reverseArray2(int[] inputArray)
        {
        int temp;
        
        for (int i = 0; i < inputArray.length/2; i++) 
            {
            temp = inputArray[i];
            inputArray[i] = inputArray[inputArray.length-1-i];
            inputArray[inputArray.length-1-i] = temp;
            }
        return inputArray;
        }

    public static LLNode reverse(LLNode node) 
        {
        LLNode prev = null;
        LLNode current = node;
        LLNode next = null;
        while (current != null) 
            {
            next = current.next();
            current.setNext(prev);
            prev = current;
            current = next;
            }
        node = prev;
        return node;
        }
    
    public static void sortTests()
        {
        // Insertion Sort Good
        Integer[] arr = {33, 4, 5, 17, 23, 90, 75, 45, 34, 85, 15, 20, 56, 53, 55, 76};
        for(int i = 0; i < arr.length; i++)
            {
            System.out.print(arr[i] + ", ");
            }
        Sort sorter = new Sort();
        sorter.insertionSort(arr, 0, 15, false);
        System.out.println();
        for(int i = 0; i < arr.length ; i++)
            {
            System.out.print(arr[i] + ", ");
            }
        System.out.println();
        
        // Insertion Sort Nodes Good
        LLNode arrB = randomLL(10);
        System.out.print(arrB);
        System.out.println();
        Sort sorterB = new Sort();
        sorterB.insertionSortLL(arrB, true);
        System.out.print(arrB);
        System.out.println();
        
        // ------------------------------------------------------------------
        // Selection Sort Good
        Integer[] arr3 = {33, 4, 5, 17, 23, 90, 75, 45, 34, 85, 15, 20, 56};
        for(int i = 0; i < arr3.length; i++)
            {
            System.out.print(arr3[i] + ", ");
            }
        Sort sorter3 = new Sort();
        sorter3.selectionSort(arr3, 1, 10, true);
        System.out.println();
        for(int i = 0; i < arr3.length ; i++)
            {
            System.out.print(arr3[i] + ", ");
            }
        System.out.println();
        
        // Selection Sort Nodes Good
        LLNode arr30 = randomLL(10);
        System.out.print(arr30);
        System.out.println();
        Sort sorter30 = new Sort();
        sorter30.selectionSortLL(arr30, false);
        System.out.print(arr30);
        System.out.println();
        
        // ------------------------------------------------------------------
        // Merge Sort Nodes Good 
        LLNode arrN = randomLL(10000);
        System.out.print(arrN);
        System.out.println();
        Sort sorterN = new Sort();
        arrN = sorter.mergeSortLL(arrN, true);
        System.out.print(arrN);
        System.out.println("\n");
        
        // ------------------------------------------------------------------
        // Shell Sort Good
        Integer[] arr10 = {33, 4, 5, 17, 23, 90, 75, 45, 34, 85, 15, 20, 56};
        for(int i = 0; i < arr10.length; i++)
            {
            System.out.print(arr10[i] + ", ");
            }
        System.out.println();
        Sort sorterA = new Sort();
        sorterA.shellSort(arr10, 0, 12, false);
        
        for(int i = 0; i < arr10.length ; i++)
            {
            System.out.print(arr10[i] + ", ");
            }
        System.out.println();
        
        // ------------------------------------------------------------------
        // Heap Sort Good
        Integer[] arr2 = {33, 4, 5, 17, 23, 90, 75, 45, 34, 85, 15, 56, 20};
        System.out.print("Unsorted: ");
        for(int i = 0; i < arr2.length; i++)
            {
            System.out.print(arr2[i] + ", ");
            }
        System.out.println();
        Sort sorter2 = new Sort();
        sorter2.heapSort(arr2, 0, 12, false);
        System.out.print("Sorted:   ");
        for(int i = 0; i < arr2.length ; i++)
            {
            System.out.print(arr2[i] + ", ");
            }
        System.out.println("\n");       
        
        // ------------------------------------------------------------------
        // Quick sort Good
        Integer[] arr9 = {33, 4, 5, 17, 23, 90, 75, 45, 34, 85, 15, 20, 56};
        for(int i = 0; i < arr9.length; i++)
            {
            System.out.print(arr9[i] + ", ");
            }
        System.out.println();
        Sort sorter7 = new Sort();
        sorter7.quicksort(arr9, 1, 10, false);
        for(int i = 0; i < arr9.length ; i++)
            {
            System.out.print(arr9[i] + ", ");
            }
        System.out.println("\n");
        
        // Quick Sort Node
        LLNode arr8 = randomLL(7);
        System.out.print(arr8);
        System.out.println();
        Sort sorter8 = new Sort();
        arr8 = sorter8.quickSortLL(arr8, true);
        System.out.print(arr8);
        System.out.println("\n");
        }
    
    public static void testInsertionSort(int NUMITER, int size, boolean reversed)
        {
        long startTime, endTime;
        double duration, setup;
        
        Integer[] list = new Integer[size];
        
        Random randomGenerator = new Random();
        Sort sorter = new Sort();
        startTime = System.currentTimeMillis();
        for(int i=0;i<NUMITER;i++) 
            {
            for (int j=0; j< size; j++)
                {
//              list[j] = randomGenerator.nextInt();
                list[j] = j;
                }
            
            list = reverseArray(list);

            sorter.insertionSort(list, 0, size-1, reversed);
            }
        
        endTime = System.currentTimeMillis();
        duration = ((double) (endTime - startTime)) / NUMITER;
        
        startTime = System.currentTimeMillis();
        for(int i=0;i<NUMITER;i++) 
            {
            for (int j=0; j< size; j++)
                {
//              list[j] = randomGenerator.nextInt();
                list[j] = j;
                }
            list = reverseArray(list);
            }
        endTime = System.currentTimeMillis();
        setup = ((double) (endTime - startTime)) / NUMITER;
        
        double time = duration - setup;
        NumberFormat formatter = new DecimalFormat("#0.00000");
        
        System.out.println("  - Size: " + size +
                   "\n  - Duration: " + formatter.format(time) + " milliseconds\n");
        
        
        }
    
    public static void testSelectionSort(int NUMITER, int size, boolean reversed)
        {
        long startTime, endTime;
        double duration, setup;
        
        Integer[] list = new Integer[size];
        
        Random randomGenerator = new Random();
        Sort sorter = new Sort();
        startTime = System.currentTimeMillis();
        for(int i=0;i<NUMITER;i++) 
            {
            for (int j=0; j< size; j++)
                {
//              list[j] = randomGenerator.nextInt();
                list[j] = j;
                }
            list = reverseArray(list);
            sorter.selectionSort(list, 0, size-1, reversed);
            }
        endTime = System.currentTimeMillis();
        duration = ((double) (endTime - startTime)) / NUMITER;
        
        startTime = System.currentTimeMillis();
        for(int i=0;i<NUMITER;i++) 
            {
            for (int j=0; j< size; j++)
                {
//              list[j] = randomGenerator.nextInt();
                list[j] = j;
                }
            list = reverseArray(list);
            }
        endTime = System.currentTimeMillis();
        setup = ((double) (endTime - startTime)) / NUMITER;
        
        double time = duration - setup;
        NumberFormat formatter = new DecimalFormat("#0.00000");
        
        System.out.println("  - Size: " + size +
                           "\n  - Duration: " + formatter.format(time) + " milliseconds\n");
        }
    
    public static void testShellSort(int NUMITER, int size, boolean reversed)
        {
        long startTime, endTime;
        double duration, setup;
        
        Integer[] list = new Integer[size];
        
        Random randomGenerator = new Random();
        Sort sorter = new Sort();
        startTime = System.currentTimeMillis();
        for(int i=0;i<NUMITER;i++) 
            {
            for (int j=0; j< size; j++)
                {
//              list[j] = randomGenerator.nextInt();
                list[j] = j;
                }
            list = reverseArray(list);
            sorter.shellSort(list, 0, size-1, reversed);
            }
        endTime = System.currentTimeMillis();
        duration = ((double) (endTime - startTime)) / NUMITER;
        
        startTime = System.currentTimeMillis();
        for(int i=0;i<NUMITER;i++) 
            {
            for (int j=0; j< size; j++)
                {
//              list[j] = randomGenerator.nextInt();
                list[j] = j;
                }
            list = reverseArray(list);
            }
        endTime = System.currentTimeMillis();
        setup = ((double) (endTime - startTime)) / NUMITER;
        
        double time = duration - setup;
        NumberFormat formatter = new DecimalFormat("#0.00000");
        
        System.out.println("  - Size: " + size +
                           "\n  - Duration: " + formatter.format(time) + " milliseconds\n");
        }
    
    public static void testHeapSort(int NUMITER, int size, boolean reversed)
        {
        long startTime, endTime;
        double duration, setup;
        
        Integer[] list = new Integer[size];
        
        Random randomGenerator = new Random();
        Sort sorter = new Sort();
        startTime = System.currentTimeMillis();
        for(int i=0;i<NUMITER;i++) 
            {
            for (int j=0; j< size; j++)
                {
//              list[j] = randomGenerator.nextInt();
                list[j] = j;
                }
            list = reverseArray(list);
            sorter.heapSort(list, 0, size-1, reversed);
            }
        endTime = System.currentTimeMillis();
        duration = ((double) (endTime - startTime)) / NUMITER;
        
        startTime = System.currentTimeMillis();
        for(int i=0;i<NUMITER;i++) 
            {
            for (int j=0; j< size; j++)
                {
//              list[j] = randomGenerator.nextInt();
                list[j] = j;
                }
            list = reverseArray(list);
            }
        endTime = System.currentTimeMillis();
        setup = ((double) (endTime - startTime)) / NUMITER;
        
        double time = duration - setup;
        NumberFormat formatter = new DecimalFormat("#0.00000");
        
        System.out.println("  - Size: " + size +
                           "\n  - Duration: " + formatter.format(time) + " milliseconds\n");
        }
    
    public static void testQuickSort(int NUMITER, int size, boolean reversed)
        {
        long startTime, endTime;
        double duration, setup;
        
        Integer[] list = new Integer[size];
        
        Random randomGenerator = new Random();
        Sort sorter = new Sort();
        startTime = System.currentTimeMillis();
        for(int i=0;i<NUMITER;i++) 
            {
            for (int j=0; j< size; j++)
                {
//              list[j] = randomGenerator.nextInt();
                list[j] = j;
                }
            list = reverseArray(list);
            sorter.quicksort(list, 0, size-1, reversed);
            }
        endTime = System.currentTimeMillis();
        duration = ((double) (endTime - startTime)) / NUMITER;
        
        startTime = System.currentTimeMillis();
        for(int i=0;i<NUMITER;i++) 
            {
            for (int j=0; j< size; j++)
                {
//              list[j] = randomGenerator.nextInt();
                list[j] = j;
                }
            list = reverseArray(list);
            }
        endTime = System.currentTimeMillis();
        setup = ((double) (endTime - startTime)) / NUMITER;
        
        double time = duration - setup;
        NumberFormat formatter = new DecimalFormat("#0.00000");
        
        System.out.println("  - Size: " + size +
                           "\n  - Duration: " + formatter.format(time) + " milliseconds\n");
        }
    
    public static void testInsertionSortLL(int NUMITER, int size, boolean reversed)
        {
        long startTime, endTime;
        double duration, setup;
        
        LLNode list, curr;
        
        Random randomGenerator = new Random();
        Sort sorter = new Sort();
        startTime = System.currentTimeMillis();
        for(int i=0;i<NUMITER;i++) 
            {
            list = new LLNode(randomGenerator.nextInt());
            curr = list;
            for (int j=0; j< size - 1; j++)
                {
//              curr.setNext(new LLNode(randomGenerator.nextInt()));
                curr.setNext(new LLNode(j));
                curr = curr.next();
                }
            curr = reverse(curr);
            sorter.insertionSortLL(list, reversed);
            }
        endTime = System.currentTimeMillis();
        duration = ((double) (endTime - startTime)) / NUMITER;
        
        startTime = System.currentTimeMillis();
        for(int i=0;i<NUMITER;i++) 
            {
            list = new LLNode(randomGenerator.nextInt());
            curr = list;
            for (int j=0; j< size - 1; j++)
                {
//              curr.setNext(new LLNode(randomGenerator.nextInt()));
                curr.setNext(new LLNode(j));
                curr = curr.next();
                }
            curr = reverse(curr);
            }
        endTime = System.currentTimeMillis();
        setup = ((double) (endTime - startTime)) / NUMITER;
        
        double time = duration - setup;
        NumberFormat formatter = new DecimalFormat("#0.00000");
        
        System.out.println("  - Size: " + size +
                           "\n  - Duration: " + formatter.format(time) + " milliseconds\n");
        }
    
    public static void testSelectionSortLL(int NUMITER, int size, boolean reversed)
        {
        long startTime, endTime;
        double duration, setup;
        
        LLNode list, curr;
        
        Random randomGenerator = new Random();
        Sort sorter = new Sort();
        startTime = System.currentTimeMillis();
        for(int i=0;i<NUMITER;i++) 
            {
            list = new LLNode(randomGenerator.nextInt());
            curr = list;
            for (int j=0; j< size - 1; j++)
                {
//              curr.setNext(new LLNode(randomGenerator.nextInt()));
                curr.setNext(new LLNode(j));
                curr = curr.next();
                }
            curr = reverse(curr);
            sorter.selectionSortLL(list, reversed);
            }
        endTime = System.currentTimeMillis();
        duration = ((double) (endTime - startTime)) / NUMITER;
        
        startTime = System.currentTimeMillis();
        for(int i=0;i<NUMITER;i++) 
            {
            list = new LLNode(randomGenerator.nextInt());
            curr = list;
            for (int j=0; j< size - 1; j++)
                {
//              curr.setNext(new LLNode(randomGenerator.nextInt()));
                curr.setNext(new LLNode(j));
                curr = curr.next();
                }
            curr = reverse(curr);
            }
        endTime = System.currentTimeMillis();
        setup = ((double) (endTime - startTime)) / NUMITER;
        
        double time = duration - setup;
        NumberFormat formatter = new DecimalFormat("#0.00000");
        
        System.out.println("  - Size: " + size +
                           "\n  - Duration: " + formatter.format(time) + " milliseconds\n");
        }
    
    public static void testMergeSortLL(int NUMITER, int size, boolean reversed)
        {
        long startTime, endTime;
        double duration, setup;
        
        LLNode list, curr;
        
        Random randomGenerator = new Random();
        Sort sorter = new Sort();
        startTime = System.currentTimeMillis();
        for(int i=0;i<NUMITER;i++) 
            {
            list = new LLNode(randomGenerator.nextInt());
            curr = list;
            for (int j=0; j< size - 1; j++)
                {
//              curr.setNext(new LLNode(randomGenerator.nextInt()));
                curr.setNext(new LLNode(j));
                curr = curr.next();
                }
            curr = reverse(curr);
            sorter.mergeSortLL(list, reversed);
            }
        endTime = System.currentTimeMillis();
        duration = ((double) (endTime - startTime)) / NUMITER;
        
        startTime = System.currentTimeMillis();
        for(int i=0;i<NUMITER;i++) 
            {
            list = new LLNode(randomGenerator.nextInt());
            curr = list;
            for (int j=0; j< size - 1; j++)
                {
//              curr.setNext(new LLNode(randomGenerator.nextInt()));
                curr.setNext(new LLNode(j));
                curr = curr.next();
                }
            curr = reverse(curr);
            }
        endTime = System.currentTimeMillis();
        setup = ((double) (endTime - startTime)) / NUMITER;
        
        double time = duration - setup;
        NumberFormat formatter = new DecimalFormat("#0.00000");
        
        System.out.println("  - Size: " + size +
                           "\n  - Duration: " + formatter.format(time) + " milliseconds\n");
        }
    
    public static void testQuickSortLL(int NUMITER, int size, boolean reversed)
        {
        long startTime, endTime;
        double duration, setup;
        
        LLNode list, curr;
        
        Random randomGenerator = new Random();
        Sort sorter = new Sort();
        startTime = System.currentTimeMillis();
        for(int i=0;i<NUMITER;i++) 
            {
            list = new LLNode(randomGenerator.nextInt());
            curr = list;
            for (int j=0; j< size - 1; j++)
                {
                curr.setNext(new LLNode(randomGenerator.nextInt()));
//              curr.setNext(new LLNode(j));
                curr = curr.next();
                }
//          curr = reverse(curr);
            sorter.quickSortLL(list, reversed);
            }
        endTime = System.currentTimeMillis();
        duration = ((double) (endTime - startTime)) / NUMITER;
        
        startTime = System.currentTimeMillis();
        for(int i=0;i<NUMITER;i++) 
            {
            list = new LLNode(randomGenerator.nextInt());
            curr = list;
            for (int j=0; j< size - 1; j++)
                {
                curr.setNext(new LLNode(randomGenerator.nextInt()));
//              curr.setNext(new LLNode(j));
                curr = curr.next();
                }
//          curr = reverse(curr);
            }
        endTime = System.currentTimeMillis();
        setup = ((double) (endTime - startTime)) / NUMITER;
        
        double time = duration - setup;
        NumberFormat formatter = new DecimalFormat("#0.00000");
        
        System.out.println("  - Size: " + size +
                           "\n  - Duration: " + formatter.format(time) + " milliseconds\n");
        }
    
    public static void main(String[] args)
        {
//      System.out.println("Insertion Sort");
//      testInsertionSort(100000, 10, false);   
//      testInsertionSort(100000, 50, false);   
//      testInsertionSort(10000, 100, false);   
//      testInsertionSort(10000, 200, false);   
//      testInsertionSort(10000, 500, false);   
//      testInsertionSort(1000, 1000, false);   
//      testInsertionSort(1000, 2000, false);   
//      testInsertionSort(1000, 5000, false);   
//      testInsertionSort(100, 10000, false);   
//      testInsertionSort(10, 50000, false);    
//      testInsertionSort(1, 100000, false);    
        
//      System.out.println("Selection Sort");
//      testSelectionSort(100000, 10, false);   
//      testSelectionSort(100000, 50, false);   
//      testSelectionSort(10000, 100, false);   
//      testSelectionSort(10000, 200, false);   
//      testSelectionSort(10000, 500, false);   
//      testSelectionSort(1000, 1000, false);   
//      testSelectionSort(1000, 2000, false);   
//      testSelectionSort(1000, 5000, false);   
//      testSelectionSort(100, 10000, false);   
//      testSelectionSort(10, 50000, false);    
//      testSelectionSort(1, 100000, false);    
        
//      System.out.println("Shell Sort");
//      testShellSort(100000, 10, false);   
//      testShellSort(100000, 50, false);   
//      testShellSort(10000, 100, false);   
//      testShellSort(10000, 200, false);   
//      testShellSort(10000, 500, false);   
//      testShellSort(1000, 1000, false);   
//      testShellSort(1000, 2000, false);   
//      testShellSort(1000, 5000, false);   
//      testShellSort(100, 10000, false);   
//      testShellSort(10, 50000, false);    
//      testShellSort(1, 100000, false);  
    
//      System.out.println("Heap Sort");
//      testHeapSort(100000, 10, false);   
//      testHeapSort(100000, 50, false);   
//      testHeapSort(10000, 100, false);   
//      testHeapSort(10000, 200, false);   
//      testHeapSort(10000, 500, false);   
//      testHeapSort(1000, 1000, false);   
//      testHeapSort(1000, 2000, false);   
//      testHeapSort(1000, 5000, false);   
//      testHeapSort(100, 10000, false);   
//      testHeapSort(10, 50000, false);    
//      testHeapSort(1, 100000, false);
        
//      System.out.println("Quick Sort");
//      testQuickSort(100000, 10, false);   
//      testQuickSort(100000, 50, false);   
//      testQuickSort(10000, 100, false);   
//      testQuickSort(10000, 200, false);   
//      testQuickSort(10000, 500, false);   
//      testQuickSort(1000, 1000, false);   
//      testQuickSort(1000, 2000, false);   
//      testQuickSort(1000, 5000, false);   
//      testQuickSort(100, 10000, false);   
//      testQuickSort(10, 50000, false);    
//      testQuickSort(1, 100000, false);
        
//      System.out.println("Insertion Sort LL");
//      testInsertionSortLL(100000, 10, false);   
//      testInsertionSortLL(100000, 50, false);   
//      testInsertionSortLL(10000, 100, false);   
//      testInsertionSortLL(10000, 200, false);   
//      testInsertionSortLL(10000, 500, false);   
//      testInsertionSortLL(1000, 1000, false);   
//      testInsertionSortLL(1000, 2000, false);   
//      testInsertionSortLL(1000, 5000, false);   
//      testInsertionSortLL(100, 10000, false);   
//      testInsertionSortLL(10, 50000, false);    
//      testInsertionSortLL(1, 100000, false);

//      System.out.println("Selection Sort LL");
//      testSelectionSortLL(100000, 10, false);   
//      testSelectionSortLL(100000, 50, false);   
//      testSelectionSortLL(10000, 100, false);   
//      testSelectionSortLL(10000, 200, false);   
//      testSelectionSortLL(10000, 500, false);   
//      testSelectionSortLL(1000, 1000, false);   
//      testSelectionSortLL(1000, 2000, false);   
//      testSelectionSortLL(1000, 5000, false);   
//      testSelectionSortLL(100, 10000, false);   
//      testSelectionSortLL(10, 50000, false);    
//      testSelectionSortLL(1, 100000, false);
        
//      System.out.println("MergeLL Sort");
//      testMergeSortLL(100000, 10, false);   
//      testMergeSortLL(100000, 50, false);   
//      testMergeSortLL(10000, 100, false);   
//      testMergeSortLL(10000, 200, false);   
//      testMergeSortLL(10000, 500, false);   
//      testMergeSortLL(1000, 1000, false);   
//      testMergeSortLL(100, 2000, false);   
//      testMergeSortLL(100, 5000, false);   
//      testMergeSortLL(10, 10000, false);   
//      testMergeSortLL(10, 50000, false);    
//      testMergeSortLL(1, 100000, false);
        
//      System.out.println("QuickLL Sort");
//      testQuickSortLL(100000, 10, false);   
//      testQuickSortLL(100000, 50, false);   
//      testQuickSortLL(10000, 100, false);   
//      testQuickSortLL(10000, 200, false);   
//      testQuickSortLL(10000, 500, false);   
//      testQuickSortLL(1000, 1000, false);   
//      testQuickSortLL(100, 2000, false);   
//      testQuickSortLL(100, 5000, false);   
//      testQuickSortLL(10, 10000, false);   
//      testQuickSortLL(10, 50000, false);    
//      testQuickSortLL(1, 100000, false);
        
        
        }
    
    }





