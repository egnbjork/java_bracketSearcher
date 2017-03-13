package berberyan;

import java.util.Deque;
import java.util.LinkedList;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BracketValidator {
	
	private BracketValidator() {
	}

	public static boolean bracketsComplete(String sample) {

		if (sample.isEmpty()) { //null statement
			return true;
		}

		Deque<Character> storedBrackets = new LinkedList<>();
		
		for (Character item : sample.toCharArray()) {
			if (bracketsBiMap().containsKey(item)) { // finds open bracket
				storedBrackets.push(item);
			} else if (bracketsBiMap().containsValue(item)) { // finds closing bracket
				if(doesBracketMatch(storedBrackets, item)) {
					//if bracket is matched, no value returned
				}
				else{ 						//found bracket not the same as one in stack
					return false;
				}
			}
		}
		return storedBrackets.isEmpty() ? true : false;
	}

	private static boolean doesBracketMatch(Deque<Character> storedBrackets, Character item) {
		if(!storedBrackets.isEmpty() && storedBrackets.pop().equals(bracketsBiMap().inverse().get(item))) {
			return true;
		}
		return false;
	}
	
	private static BiMap<Character, Character> bracketsBiMap() {
		BiMap<Character, Character> bracketsBiMap = HashBiMap.create();
		bracketsBiMap.put('(', ')');
		bracketsBiMap.put('[', ']');
		bracketsBiMap.put('{', '}');
		return bracketsBiMap;
	}
}
