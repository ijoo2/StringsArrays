import java.util.HashMap;
import java.util.Hashtable;


public class Practice {
	
	String test = "InhaJoo";
	String test2 = "InhaJoo";

	public static void main(String args[]){
		
		Practice p = new Practice();
		boolean answer;
		
		System.out.println("String 1: " + p.test);
		System.out.println("String 2: " + p.test2);
		
		answer = p.CheckUniqueString(p.test);
		if(answer) System.out.println("Unique String: TRUE");
		else System.out.println("Unique String: FALSE");
		
		answer = p.CheckUniqueStringHash(p.test);
		if(answer) System.out.println("Unique String: TRUE");
		else System.out.println("Unique String: FALSE");

		answer = p.CheckPermutation(p.test, p.test2);
		if(answer) System.out.println("Permutation: TRUE");
		else System.out.println("Permutation: FALSE!");
		
		
	}
	
	/* Implement an algorithm to determine if a string has all unique characters.
	 *  What if you cannot use additional data structure?
	 *  Create a 256 size boolean array. Assuming ANSCI.
	 *  Go through string, convert character to integer value.
	 *  if boolean array at integer value is true, return false
	 *  else, set array at integer value true
	 *  return true if it went through loop successfully
	 *   */
	public boolean CheckUniqueString(String str){
		if(str.length() > 256)
			return false;
			
		boolean charCheck[] = new boolean[256];
		for(int i =0; i<str.length();i++){
		int c = str.charAt(i);
		if(charCheck[c])
			return false;		
		else
			charCheck[c] = true;
		}
		return true;
	}
	
	public boolean CheckUniqueStringHash(String str){
		if(str.length() > 256) 
			return false;
		
		Hashtable table = new Hashtable();
		for(int i=0;i<str.length();i++){
			if(table.containsKey(str.charAt(i)))
				return false;
			else
				table.put(str.charAt(i),true);
		}
		return true;
	}
	
	/*Given two strings, write a method to decide if one is a permutation of the other
	 * Make a HashMap.
	 * Go through first string. Add +1 to map
	 * Go through second string. -1 to each occurrence. If map gives -1, return false
	 * return true if successful from both loops.
	 * */
	public boolean CheckPermutation(String str1, String str2){
		if(str1.length() != str2.length())
			return false;
		
		HashMap<Character, Integer> map = new HashMap();
		
		int i;
		
		for(i=0;i<str1.length();i++){
			char c = str1.charAt(i);
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}
			else{
				map.put(c,1);
			}
		}
		
		for(i=0;i<str2.length();i++){
			char c = str2.charAt(i);
			if(!map.containsKey(c)){
				return false;
			}
			else{
				map.put(c,  map.get(c)-1);
				if(map.get(c)<0)
					return false;
			}
		}
		
		return true;
	}
}

