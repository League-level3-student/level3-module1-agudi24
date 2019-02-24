package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		ArrayList<String> str = new ArrayList<String>();
		//   Don't forget to import the ArrayList class

		//2. Add five Strings to your list
		
		str.add("Hi");
		str.add("Hello");
		str.add("How");
		str.add("Are");
		str.add("You");
		//3. Print all the Strings using a standard for-loop
		for (int i = 0; i < str.size(); i++) {
			System.out.println(str.get(i));
		}
		
		//4. Print all the Strings using a for-each loop
		for (String a : str) {
			System.out.println(a);
		}
		
		//5. Print only the even numbered elements in the list.
		for (int i = 0; i < str.size(); i+=2) {
			System.out.println(str.get(i));
			if(i == 0) {
				System.out.println("");
			}
		}
		//6. Print all the Strings in reverse order.
		for (int i = str.size() - 1; i >= 0; i--) {
			System.out.println(str.get(i));
		}
		//7. Print only the Strings that have the letter 'e' in them.
		for (int i = 0; i < str.size(); i++) {
			for (int j = 0; j < str.get(i).length() - 1; j++) {
				if (str.get(i).charAt(j) == ('e')) {
					System.out.println(str.get(i));
				}
			}

			}
		}
	}

