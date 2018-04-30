import java.util.ArrayList;

public class Sort
    {
    
    static <T extends Comparable<T>> void insertionSort(T[] array, int lowIndex, int highIndex, boolean reversed)
        {
        for(int i = lowIndex + 1; i <= highIndex; i ++)
            {
            int j = i;
            T temp = array[i];
            if(!reversed)
                {
                while(j > lowIndex && array[j-1].compareTo(temp) > 0)
                    {
                    array[j] = array[j-1];
                    j--;
                    }
                }
            else
                {
                while(j > lowIndex && array[j - 1].compareTo(temp) < 0)
                    {
                    array[j] = array[j-1];
                    j--;
                    }
                }
            array[j] = temp;
            }
        }
        
   public static <T extends Comparable<T>> void selectionSort(T[] A, int lowIndex, int highIndex, boolean reversed) 
        {
        for(int i = lowIndex; i <= highIndex; i++)
            {
            int track = i;
            for(int j = i + 1; j <= highIndex; j++)
                {
                if(!reversed)
                    {
                    if(A[j].compareTo(A[track]) < 0)
                        track = j;
                    }
                else
                    {
                    if(A[j].compareTo(A[track]) > 0)
                        track = j;
                    }
                }
            T temp = A[track];
            A[track] = A[i];
            A[i] = temp;
            }
        }
   
   private static <T extends Comparable<T>> LLNode<T> findMiddle(LLNode<T> list)
        {
        if(list == null)
            {
            return list;
            }
        
        LLNode<T> temp  = list;
        LLNode<T> temp2 = list;
        
        while(temp2 != null && temp2.next() != null && temp2.next().next() != null)
            {
            temp = temp.next();
            temp2 = temp2.next().next();
            }
        
        return temp;
        
        }

   public static <T extends Comparable<T>> LLNode<T> mergeSortLL(LLNode<T> list, boolean reversed) 
        {
        if(list == null || list.next() == null)
            {
            return list;
            }
       
        LLNode<T> curr = findMiddle(list);
        LLNode<T> half = curr.next();
        curr.setNext(null);
            
        LLNode<T> a = mergeSortLL(list, reversed);
        LLNode<T> b = mergeSortLL(half, reversed);
        
        LLNode<T> c = mergeLL(a, b, reversed);
        
        return c;       
        }
   
   private static <T extends Comparable<T>> LLNode<T> mergeLL(LLNode<T> list, LLNode<T> half, boolean reversed)
        {
        LLNode<T> sorted = null;
        
        if(list == null)
            {
            return half;
            }
        if(half == null)
            {
            return list;
            }       

        if(!reversed)
            {
            if(list.elem().compareTo(half.elem()) < 0)
                {
                sorted = list;
                sorted.setNext(mergeLL(list.next(), half, reversed));
                }   
            else
                {
                sorted = half;
                sorted.setNext(mergeLL(list, half.next(), reversed));
                }
            }
        else
            {
            if(list.elem().compareTo(half.elem()) > 0)
                {
                sorted = list;
                sorted.setNext(mergeLL(list.next(), half, reversed));
                }   
            else
                {
                sorted = half;
                sorted.setNext(mergeLL(list, half.next(), reversed));
                }
            }
        return sorted;
        }

   public static <T extends Comparable<T>> LLNode<T> insertionSortLL(LLNode<T> list, boolean reversed)
        {
        if(list == null)
            return null;
        
        LLNode<T> curr = list;
        LLNode<T> prev = null;
        
        while(curr != null && prev != list)
            {
            LLNode<T> temp = curr;
            for(temp = curr; temp.next() != prev; temp = temp.next())
                {
                if(!reversed)
                    {
                    if(temp.elem().compareTo(temp.next().elem()) > 0)
                        {
                        T temp2 = temp.elem();
                        temp.setElem(temp.next().elem());
                        temp.next().setElem(temp2);
                        }
                    }
                else
                    {
                    if(temp.elem().compareTo(temp.next().elem()) < 0)
                        {
                        T temp2 = temp.elem();
                        temp.setElem(temp.next().elem());
                        temp.next().setElem(temp2);
                        }
                    }
                }
            prev = temp;
            curr = list;
            }
        
        return list;
        }
 
   public static <T extends Comparable<T>> LLNode<T> selectionSortLL(LLNode<T> list, boolean reversed)
        {
        if(list == null)
            return null;

        LLNode<T> curr = list;
        while(curr != null)
            {
            LLNode<T> temp = curr;
            LLNode<T> temp2 = curr.next();
            while(temp2 != null)
                {
                if(reversed)
                    {
                    if(temp2.elem().compareTo(temp.elem()) > 0)
                        temp = temp2;
                    temp2 = temp2.next();
                    }
                else
                    {
                    if(temp2.elem().compareTo(temp.elem()) < 0)
                        temp = temp2;
                    temp2 = temp2.next();
                    }
                }
            if(temp != curr)
                {
                T val = curr.elem();
                curr.setElem(temp.elem());
                temp.setElem(val);
                }
            curr = curr.next();
            }
        return list;
        }
   
   public static <T extends Comparable<T>> LLNode<T> quickSortLL(LLNode<T> list, boolean reversed)
        {
        // TODO Fill in method stub
        if(list == null || list.next() == null)
            return list;
        
        LLNode<T> child = new LLNode(0);
        LLNode<T> childHead = child;
        
        LLNode<T> sib = new LLNode(0);
        LLNode<T> rightHead = sib;
        
        LLNode<T> mid = new LLNode(0);
        LLNode<T> midHead = mid;
        T temp = list.elem();

        if(!reversed) 
            {
            while(list != null) 
                {
                if(list.elem().compareTo(temp) < 0) 
                    {
                    child.setNext(list);
                    child = child.next();
                    }
                else if(list.elem().compareTo(temp) > 0) 
                    {
                    sib.setNext(list);
                    sib = sib.next();
                    } 
                else 
                    {
                    mid.setNext(list);
                    mid = mid.next();
                    }
                list = list.next();
                }
            } 
        else 
            {
            while(list != null) 
                {
                if(list.elem().compareTo(temp) > 0) 
                    {
                    child.setNext(list);
                    child = child.next();
                    } 
                else if(list.elem().compareTo(temp) < 0) 
                    {
                    sib.setNext(list);
                    sib = sib.next();
                    } 
                else 
                    {
                    mid.setNext(list);
                    mid = mid.next();
                    }
                list = list.next();
                }
            }

        child.setNext(null);
        sib.setNext(null);
        mid.setNext(null);
        
        LLNode<T> a = quickSortLL(childHead.next(), reversed);
        LLNode<T> b = quickSortLL(rightHead.next(), reversed);
        
        return quickSortHelperLL(a, midHead.next(), b, reversed);
        }
   
   private static <T extends Comparable<T>> LLNode<T> quickSortHelperLL(LLNode<T> child, LLNode<T> middle, LLNode<T> sib, boolean reversed) 
        {
        if(!reversed) 
            {
            LLNode<T> lnext = getNextNode(child);
            LLNode<T> mnext = getNextNode(middle);
            mnext.setNext(sib);
            if(lnext != null) 
                {
                lnext.setNext(middle);
                return child;
                } 
            else 
                {
                return middle;
                }
            } 
        else 
            {
            LLNode<T> lnext = getNextNode(child);
            LLNode<T> mnext = getNextNode(middle);
            mnext.setNext(sib);
            if(lnext != null) 
                {
                lnext.setNext(middle);
                return child;
                } 
            else 
                {
                return middle;
                }
            }
        }
    
    private static <T extends Comparable<T>> LLNode<T> getNextNode(LLNode<T> list) 
        {       
        LLNode<T> curr = list;
        while(curr != null && curr.next() != null) 
            {
            curr = curr.next();
            }
        return curr;
        }


   public static <T extends Comparable<T>> void shellSort(T[] array, int lowindex, int highindex, boolean reversed)
        {
        int size = highindex - lowindex + 1;
        for(int increment = (2^size) - 1; increment > 0; increment /= 2)
            {
            for(int offset = 0; offset < increment; offset++)
                {
                shellHelp(array, offset, increment, lowindex, highindex, reversed);
                }
            }
        }
   
   public static <T extends Comparable<T>> void shellHelp(T[] array, int offset, int increment, int lowindex, int highindex, boolean reversed)
        {
        int j;
        for(int i = offset + increment; i <= highindex; i += increment)
            {
            T temp = array[i];
            if(!reversed)
                {
                for(j = i - increment; j >= lowindex && array[j].compareTo(temp) > 0; j -= increment)
                    {
                    array[j + increment] = array[j];
                    }
                }
            else
                {
                for(j = i - increment; j >= lowindex && array[j].compareTo(temp) < 0; j -= increment)
                    {
                    array[j + increment] = array[j];
                    }
                }
            array[j + increment] = temp;
            }
        }

   public static <T extends Comparable<T>> void heapSort(T[] array, int lowindex, int highindex, boolean reversed)
        {
        int len = highindex-lowindex + 1;

        heapSortHelp(array, len, lowindex, reversed);
        
        for(int i = len; i > 1; i = i - 1)
            {
            swap(array, lowindex, lowindex + i - 1);
            heapPushDown(array, 1 , i - 1, lowindex, reversed);
            }
        
        }
   
   private static <T extends Comparable<T>> void heapSortHelp(T[] array, int len, int lowindex, boolean reversed)
        {
        for(int i = len / 2 ; i >= 1; i = i - 1)
            {
            heapPushDown(array, i , len, lowindex, reversed);
            }
        }
   
   private static <T extends Comparable<T>> void heapPushDown(T[] array, int len, int size, int lowindex, boolean reversed)
        {
        T head = array[lowindex + len - 1];
        int smallestChild;
        while(len <= size / 2)
            {
            smallestChild = 2 * len;
            if(!reversed)
                {
                if(smallestChild < size && array[lowindex + smallestChild - 1].compareTo(array[lowindex + smallestChild]) < 0)
                    {
                    smallestChild++;
                    }
                if(head.compareTo(array[lowindex + smallestChild - 1]) >= 0) 
                    break;
                }
            else
                {
                if(smallestChild < size && array[lowindex + smallestChild - 1].compareTo(array[lowindex + smallestChild]) > 0)
                    {
                    smallestChild++;
                    }
                if(head.compareTo(array[lowindex + smallestChild - 1]) <= 0) 
                    break;
                }
            array[lowindex + len - 1] = array[lowindex + smallestChild - 1];
            len = smallestChild;
            }
        array[lowindex + len - 1] = head;
        }
   
   public <T extends Comparable<T>> void quicksort(T[] array, int lowindex, int highindx, boolean reversed)
        {
        if(array.length == 0) 
            {
            return;
            }
       
        if(lowindex < highindx)
            {
            int pivot = partition(array, lowindex, highindx, reversed);
            this.quicksort(array, lowindex, pivot - 1, reversed);
            this.quicksort(array, pivot + 1, highindx, reversed);
            }
        }
   
   
   private <T extends Comparable<T>> int partition(T[] array, int lowindex, int highindx, boolean reversed)
        {
        int high = highindx;
        int length = lowindex + highindx;
        int middle = (length + ((length) / 2)) / 3;
        // Swap
        swap(array, middle, highindx);
        
        T pivot = array[highindx];
        lowindex--;
        while(lowindex < highindx)
            {
            if(!reversed)
                {
                while(pivot.compareTo(array[++lowindex]) > 0);
                while(lowindex < highindx && pivot.compareTo(array[--highindx]) < 0);
                // Swap
                swap(array, lowindex, highindx);
                }
            else
                {
                while(pivot.compareTo(array[++lowindex]) < 0);
                while(lowindex < highindx && pivot.compareTo(array[--highindx]) > 0);
                // Swap
                swap(array, lowindex, highindx);
                }
            }
        // Swap 
        swap(array, lowindex, high);
        return lowindex;
        }
   
   
   private static <T extends Comparable<T>> void swap(T[] array, int i, int j)
        {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        }

    
    }



