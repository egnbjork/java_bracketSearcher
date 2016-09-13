package berberyan;

import java.util.Stack;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BracketValidator {
	
	private BracketValidator() {
	}

	private static BiMap<Character, Character> bracketsBiMap() {
		BiMap<Character, Character> bracketsBiMap = HashBiMap.create();
		bracketsBiMap.put('(', ')');
		bracketsBiMap.put('[', ']');
		bracketsBiMap.put('{', '}');
		return bracketsBiMap;
	}

	public static boolean bracketsComplete(String sample) {

		if (sample.isEmpty()) { //nil statement
			return true;
		}

		Stack<Character> storedBrackets = new Stack<Character>();
		
		for (Character item : sample.toCharArray()) {
			if (bracketsBiMap().containsKey(item)) { // finds open bracket
				storedBrackets.push(item);
			} else if (bracketsBiMap().containsValue(item)) { // finds closing bracket
				if(storedBrackets.isEmpty()){ //closing bracket found but stack is empty
					return false;
				}
				else if (storedBrackets.pop() //found bracket same as opened one in stack
					.equals(bracketsBiMap()
					.inverse().get(item))) {
				} 
				else{ 						//found bracket not same as one in stack
					return false;
				}
			}
		}
		return storedBrackets.isEmpty() ? true : false;
	}
}
