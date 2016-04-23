//class Swap {
  // void swapReferences(int[] a, int i, int j){
  //     int temp = a[i];
  //     a[i] = a[j];
  //     a[j] = temp;
  // }
  // public int median(int[] a,int left,int right) {
  //   int center = (left+right) /2;
  //   if(a[center] < a[left])
  //     exchangeElements(a,left,center);
  //   if(a[right] < a[left])
  //     exchangeElements(a,left,right);
  //   if(a[right] < a[center])
  //     exchangeElements(a,center,right);
  //   //exchangeElements(a,center,right-1);
  //   return a[center];
  // }

//}

class ArrayUtils {

       public static void printArray(int[] array) {
           System.out.print("{");
           for (int i = 0; i < array.length; i++) {
               System.out.print(array[i]);
               if (i < array.length - 1) {
                   System.out.print(", ");
               }
           }
           System.out.println("}");
       }

       public static void exchangeElements(int[] array, int index1, int index2) {
           int temp = array[index1];
           array[index1] = array[index2];
           array[index2] = temp;
       }
       public static int median(int[] a,int left,int right) {
         int center = (left+right) /2;
         if(a[center] < a[left])
           exchangeElements(a,left,center);
         if(a[right] < a[left])
           exchangeElements(a,left,right);
         if(a[right] < a[center])
           exchangeElements(a,center,right);
         //exchangeElements(a,center,right-1);
         return a[center];
       }
   }
   public class QuickSort2 {

   public static void main(String[] args) {
     int[] array = new int[1000];
     for(int i=0;i<1000;i++){
       array[i]=1000-i;
     }

       //System.out.println("Before sort:");
       //ArrayUtils.printArray(array);
       long starTime=System.nanoTime();
       quickSort(array);
       long endTime=System.nanoTime();
       //System.out.println("After sort:");
       //ArrayUtils.printArray(array);
       long Time=endTime-starTime;
       System.out.println(Time + "ns");
     //   StringBuilder bulider=new StringBuilder("");
     // long starTime=System.nanoTime();
     // for(int j=0;j<10000;j++){
     //  bulider.append(j);
     // }
     // long endTime=System.nanoTime();
     // long Time=endTime-starTime;
     // System.out.println(Time + "ns");
   }

   public static void quickSort(int[] array) {
       subQuickSort(array, 0, array.length - 1);
   }

   private static void subQuickSort(int[] array, int start, int end) {
       if (array == null || (end - start + 1) < 2) {
           return;
       }

       int part = partition(array, start, end);

       if (part == start) {
           subQuickSort(array, part + 1, end);
       } else if (part == end) {
           subQuickSort(array, start, part - 1);
       } else {
           subQuickSort(array, start, part - 1);
           subQuickSort(array, part + 1, end);
       }
   }
   private static int partition(int[] array, int start, int end) {
       //int value = array[end];
       int value = ArrayUtils.median(array,start,end);
       int index = start - 1;

       for (int i = start; i < end; i++) {
           if (array[i] < value) {
               index++;
               if (index != i) {
                   ArrayUtils.exchangeElements(array, index, i);
               }
           }
       }

       if ((index + 1) != end) {
           ArrayUtils.exchangeElements(array, index + 1, end);
       }

       return index + 1;
   }
}
