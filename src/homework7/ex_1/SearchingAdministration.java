package homework7.ex_1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SearchingAdministration {
   UnsortedArray<Integer> unsortedArray;
   SortedArray<Integer> sortedArray;

   UnsortedLinkedList<Integer> unsortedLinkedList;
   SortedLinkedList<Integer> sortedLinkedList;

   Object[] array;

   public void display() {
       System.out.println(unsortedArray);
       System.out.println(sortedArray);
       System.out.println(unsortedLinkedList);
       System.out.println(sortedLinkedList);
   }
    public SearchingAdministration() {
        this.unsortedArray = new UnsortedArray<>();
        this.sortedArray = new SortedArray<>();
        this.unsortedLinkedList = new UnsortedLinkedList<>();
        this.sortedLinkedList = new SortedLinkedList<>();
    }

    public void searchElement(String type, int value) {
       if (type.equals("unsortedArray")) {
           boolean result = false;
           int index = 0;
           double startTime = System.nanoTime();
           for (int i = 0; i < unsortedArray.size(); i++) {
               if (unsortedArray.get(i) == value) {
                   result = true;
                   index = i;
                   break;
               }
           }
           double endTime = System.nanoTime();
           System.out.println("Time to search: (ns)" + (endTime - startTime));
           System.out.println("Value can search successfully : " + result);
           System.out.println("Index of " + value + " is: " + index);
       } else if (type.equals("sortedArray")) {
           int left = 0;
           int right = sortedArray.size() - 1;
           boolean result = false;
           int index = 0;
           double startTime = System.nanoTime();
           while (left <= right) {
               int mid = left + (right - left) / 2;
               if (sortedArray.get(mid) < value) {
                   left = mid + 1;
               }
               else if (sortedArray.get(mid) > value) {
                   right = mid - 1;
               }
               else {
                   result = true;
                   index = mid;
                   break;
               }
           }
           double endTime = System.nanoTime();
           if (result == false) {
               index = -1;
           }
           System.out.println("Time to search: (ns)" + (endTime - startTime));
           System.out.println("Value can search successfully : " + result);
           System.out.println("Index of " + value + " is: " + index);
       } else if (type.equals("unsortedLinkedList")) {
           boolean result = false;
           double startTime = System.nanoTime();
           Node<Integer> node = unsortedLinkedList.getHead();
           while (node.getData() != value && node.getNext() != null) {
               node = node.getNext();
           }
           if (node.getData() == value) {
               result = true;
           }
           double endTime = System.nanoTime();
           System.out.println("Time to search: (ns)" + (endTime - startTime));
           System.out.println("Value can search successfully : " + result);
       } else if (type.equals("sortedLinkedList")) {
           boolean result = false;
           double startTime = System.nanoTime();
           Node<Integer> node = sortedLinkedList.getHead();
           while (node.getData() != value && node.getNext() != null) {
               node = node.getNext();
           }
           if (node.getData() == value) {
               result = true;
           }
           double endTime = System.nanoTime();
           System.out.println("Time to search: (ns)" + (endTime - startTime));
           System.out.println("Value can search successfully : " + result);
       }
   }

   public void initData(int size) {
       Random random = new Random();
       Set<Integer> set = new HashSet<>();
       for (int i = 0; i < size; i++) {
           set.add(random.nextInt(400));
       }
       array = set.toArray();
   }

   public void intList() {
       for (int i = 0; i < array.length; i++) {
           unsortedArray.add((int) array[i]);
           sortedArray.add((int) array[i]);
           unsortedLinkedList.addBot((int) array[i]);
           sortedLinkedList.addBot((int) array[i]);
       }
   }


}
