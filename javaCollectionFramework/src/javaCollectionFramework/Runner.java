package javaCollectionFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
*@author Liran Hadad
*/
public class Runner {

	public static void main(String[] args) {
		//create new integer list
		List<Integer> list = new ArrayList<>();
		//add to list
		list.add(3);
		list.add(4);
		list.add(55);
		list.add(222);
		list.add(123);
		
		
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
		System.out.println("------------------");
		
		Iterator<Integer> iterator = list.iterator();
		
		//at the beginning it points to the first cell 3
		while(iterator.hasNext()) {
			int i = iterator.next();
			System.out.println(i);
		}
		System.out.println("------------------");
		
		//asremaining uses the iterator from the while, therefor the index is in the end
		//and wont print
		iterator.forEachRemaining(System.out::println);
		
		
		List<String> strList = new ArrayList<>();
		strList.add("3");
		strList.add("2");
		strList.add("1");
		strList.add("2");
		strList.add("4");

		System.out.println(strList);
		System.out.println("--------------------");
		removeAllItemsFromList(strList);
		
		
		//exercise
		ArrayList<Integer> input = range(1,10);
		System.out.println(input);
		System.out.println(doubleEach(input));
		System.out.println(complexifyEach(input));
		
	}
	
	
	private static ArrayList<Integer> range(int start, int end) {
		int size = end - start;
		ArrayList<Integer> newList = new ArrayList<>(size);
		
		for (int i = start; i < end; i++) {
			newList.add(i);
		}
		
		return newList;
	}


	public static void removeAllItemsFromList(List<String> list) {
		
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
	}
	
	public static ArrayList<Integer> doubleEach(ArrayList<Integer> inlist){
		ArrayList<Integer> doubledList = new ArrayList<>();
		Iterator<Integer> iterator = inlist.iterator();
		
		while(iterator.hasNext()) {
			doubledList.add( iterator.next() * 2);	
		}
		
		return doubledList;
	}
	
	public static ArrayList<Integer> complexifyEach(ArrayList<Integer> inlist){
		ArrayList<Integer> ansList = new ArrayList<>();
		Iterator<Integer> iterator = inlist.iterator();
		while(iterator.hasNext()) {
			ansList.add( iterator.next() * 4 + 3);	
		}
		
		return ansList;
	}

}
