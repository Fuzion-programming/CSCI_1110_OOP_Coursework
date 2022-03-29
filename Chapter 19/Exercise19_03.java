/*
Author: Jeff Lee
Date: 3/29/22

Description: using generics and hashset to return a unique arraylist
 */
import java.util.ArrayList;
import java.util.HashSet;

public class Exercise19_03 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);
    
    ArrayList<Integer> newList = removeDuplicates(list);
    
    System.out.print(newList);
  }
  
  public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
	  
	  HashSet<E> hashSet = new HashSet<>(list);
	  list.clear();
	  list.addAll(hashSet);
	  
	  return list;
  }
  
}